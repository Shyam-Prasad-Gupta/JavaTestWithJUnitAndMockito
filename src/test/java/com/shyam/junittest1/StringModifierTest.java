package com.shyam.junittest1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class StringModifierTest {

	private StringModifier stringModifier;

	@BeforeEach
	public void setup() {
		stringModifier = new StringModifier();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		Assertions.assertNotNull("shyam");
		Assertions.assertEquals("KASH", stringModifier.truncateAInFirst2Positions("AAKASH"));
		Assertions.assertEquals("KSH", stringModifier.truncateAInFirst2Positions("AKSH"));
		Assertions.assertEquals(stringModifier.truncateAInFirst2Positions("KASH"), "KASH");
	}

	@Test
	public void expectedIllegalArgumentExceptionForNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			stringModifier.truncateAInFirst2Positions(null);
		});
	}
	
	@Test
	public void expectedIllegalArgumentExceptionForBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			stringModifier.truncateAInFirst2Positions("");
		});
	}

	@AfterEach
	public void destroy() {
		stringModifier = null;
	}

}
