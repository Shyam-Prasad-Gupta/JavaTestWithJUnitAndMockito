package com.shyam.app.order.spy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class ListTest {

	@Spy
	List<String> list = new ArrayList<String>();
	
	@Mock
	List<String> list2 = new ArrayList<String>();
	
	@BeforeEach
	public void initialize() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		
		list.add("shyam");
		//list.add("prasad");
		//this stub will call the actual method and return the set value
		Mockito.when(list.get(0)).thenReturn("gupta");
		//this will not call the actual method
		Mockito.doReturn(3).when(list).size();
		Assertions.assertEquals(3, list.size());
	}
	
	@Test
	void test2() {
		
		//this stub will mock the list
		Mockito.when(list2.get(0)).thenReturn("gupta");
		//this will not call the actual method
		//Mockito.when(list2.get(0)).thenCallRealMethod();
		Assertions.assertEquals("gupta", list2.get(0));
		Mockito.when(list2.get(0)).thenThrow(IndexOutOfBoundsException.class);
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{list2.get(0);});
	}

}
