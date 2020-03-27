package com.shyam.calculator.test.parameterized;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.shyam.calculator.Calculator;
import com.shyam.calculator.CalculatorImpl;

@ExtendWith(TestParameterResolver.class)
public class CalculatorTestNew {

	/*private int num1;
	private int num2;
	private int result;

	public CalculatorTestNew(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.result = result;
	}*/
	
	//@ParameterizedTest
	/*@Parameters
	public static Collection<Integer[]> data(){
		
		return Arrays.asList(new Integer[][]{{-1,2,1}, {1,2,3}, {6,7,13}});
	}*/

	private Calculator calc = new CalculatorImpl();

	@Test
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
