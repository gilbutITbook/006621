package org.androidtown.calculator;

public abstract class CalculatorObject implements Calculator {

	@Override
	public abstract int add(int a, int b);

	@Override
	public int subtract(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("���ⱸ������");
	}

	@Override
	public int multiply(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("���ϱⱸ������");
	}

	@Override
	public int divide(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("�����ⱸ������");
	}

}
