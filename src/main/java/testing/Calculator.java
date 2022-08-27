package testing;

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
	
}
