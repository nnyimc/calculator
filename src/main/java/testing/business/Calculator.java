package testing.business;

import java.util.HashSet;
import java.util.Set;

public class Calculator implements CalculatorInterface {

	@Override
	public int add(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	@Override
	public int multiply(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}
	
	@Override
	public int divide(int firstNumber, int secondNumber) {
		return firstNumber / secondNumber;
	}

	@Override
	public int substract(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

	public Set<Integer> toDigitsSet(int number) {
		Set<Integer> integers = new HashSet<Integer>();
		String numberString = String.valueOf(number);
		
		for (int i = 0; i < numberString.length(); i++) {
			if (numberString.charAt(i) != '-') {
				integers.add( Integer.parseInt("" + numberString.charAt(i),10) );
			}
		}
		return integers;
	}
	
}
