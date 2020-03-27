package com.shyam.scrapbook.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shyam.scrapbook.A;
import com.shyam.scrapbook.B;

public class ATest {

	@Mock
	private B b;

	private A a;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShouldCallVoidMethod() throws Exception {

		// when(b.voidMethod()).thenReturn(1);
		doNothing().when(b).voidMethod();
		Assertions.assertEquals(1, a.usesVoidMethod());
		// assert same, checks if the 2 reference refers to the same object
		Assertions.assertSame(1, a.usesVoidMethod());
		a.usesVoidMethod();
		verify(b, atLeast(2)).voidMethod();
	}

	@Test
	public void usesVoidMethodShouldThrowRuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidMethod();
		Assertions.assertThrows(RuntimeException.class, () -> {
			a.usesVoidMethod();
		});
	}

	@Test
	public void usesVoidMethodShouldStubDifferently() throws Exception {

		//we are stub the void method multiple times but in order like on first call it will return void on
		//on second call it will throw an exception
		doNothing().doThrow(Exception.class).when(b).voidMethod();

		Assertions.assertEquals(1, a.usesVoidMethod());
		Assertions.assertThrows(RuntimeException.class, () -> {
			a.usesVoidMethod();
		});
		
		
	}

}
