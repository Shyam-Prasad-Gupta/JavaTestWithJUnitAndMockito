package com.shyam.calculator.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.shyam.calculator.Calculator;
import com.shyam.calculator.CalculatorImpl;

public class CalculatorTest {

	private Calculator calc = new CalculatorImpl();;

	@Test
	public void testAdd() {

		// test addition
		Assertions.assertEquals(45, calc.add(30, 15));
		Assertions.assertEquals(0, calc.add(12, -12));
		Assertions.assertEquals(0, calc.add(-1, 1));
		Assertions.assertEquals(100, calc.add(0, 100));
		Assertions.assertEquals(12, calc.add(12, 0));
		Assertions.assertEquals(-23, calc.add(-12, -11));
	}

	@Test
	public void testSub() {

		// test sub
		Assertions.assertEquals(15, calc.sub(30, 15));
		Assertions.assertEquals(24, calc.sub(12, -12));
		Assertions.assertEquals(-2, calc.sub(-1, 1));
		Assertions.assertEquals(-100, calc.sub(0, 100));
		Assertions.assertEquals(12, calc.sub(12, 0));
		Assertions.assertEquals(-1, calc.sub(-12, -11));
	}

	@Test
	public void testMul() {
		// test mul
		Assertions.assertEquals(450, calc.mul(30, 15));
		Assertions.assertEquals(-144, calc.mul(12, -12));
		Assertions.assertEquals(-1, calc.mul(-1, 1));
		Assertions.assertEquals(0, calc.mul(0, 100));
		Assertions.assertEquals(-0, calc.mul(12, 0));
		Assertions.assertEquals(132, calc.mul(-12, -11));
	}

	@Test
	public void testDiv() throws Exception {
		// test divide
		Assertions.assertEquals(2.0, calc.div(30, 15));
		Assertions.assertEquals(-1.0, calc.div(12, -12));
		Assertions.assertEquals(-1.0, calc.div(-1, 1));
		Assertions.assertEquals(0.0, calc.div(0, 100));
		Assertions.assertThrows(Exception.class, ()->{calc.div(12, 0);});
		Assertions.assertEquals(1.0, calc.div(-12, -11));
	}

}
