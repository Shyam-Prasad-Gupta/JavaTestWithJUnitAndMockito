package com.shyam.calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	@Override
	public float div(int a, int b) throws Exception {
		try {
			return a / b;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
