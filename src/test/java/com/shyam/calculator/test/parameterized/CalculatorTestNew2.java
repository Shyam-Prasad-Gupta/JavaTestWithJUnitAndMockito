package com.shyam.calculator.test.parameterized;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.shyam.calculator.Calculator;
import com.shyam.calculator.CalculatorImpl;

@ExtendWith(TestParameterResolver.class)
public class CalculatorTestNew2 {

	private Calculator calc = new CalculatorImpl();

	@Test
	@RepeatedTest(value = 5)
	public void testAdd(List<Integer[]> params) {

		System.out.println(params.getClass());
		Integer[] input1 = params.get(0);
		Integer[] input2 = params.get(1);
		Integer[] result = params.get(2);

		for (int i = 0; i < input1.length; i++) {
			Assertions.assertEquals(result[i], calc.add(input1[i].intValue(), input2[i].intValue()));
		}
	}

}
