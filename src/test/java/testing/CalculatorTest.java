package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

		@Test
		void testAddTwoPositiveNumbers() {
			
			// ARRANGE
			int firstNumber = 6;
			int secondNumber = 4;
			Calculator calculator = new Calculator();
			
			// ACT
			int result = calculator.add(firstNumber, secondNumber);
			
			// ASSERT
			assertEquals(10, result);
			
		}
		
		@Test
		void testMultiplyTwoPositiveNumbers() {
			
			// ARRANGE 
			int firstNumber = 4;
			int secondNumber = 5;
			Calculator calculator = new Calculator();
			
			// ACT
			int result = calculator.multiply(firstNumber, secondNumber);
			
			// ASSERT
			assertEquals(20, result);
		}
		
		@Test
		void testDivideTwoPositiveNumbers() {
			
			// ARRANGE 
			int firstNumber = 8;
			int secondNumber = 2;
			Calculator calculator = new Calculator();
			
			// ACT
			int result = calculator.divide(firstNumber, secondNumber);
			
			// ASSERT
			assertEquals(4, result);
			
		}
		
		@Test
		void testSubstractTwoPositiveNumbers() {
			
			// ARRANGE
			int firstNumber = 40;
			int secondNumber = 13;
			Calculator calculator = new Calculator();
			
			// ACT
			int result = calculator.substract(firstNumber, secondNumber);
			
			// ASSERT
			assertEquals(27, result);
		}
}
