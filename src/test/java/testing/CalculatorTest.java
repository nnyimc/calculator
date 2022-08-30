package testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
		
		private Calculator calculator;
	
		@BeforeEach
		public void initCalculator() {
			calculator = new Calculator();
		}

		@Test
		void testAddTwoPositiveNumbers() {
			
			// ARRANGE
			int firstNumber = 6;
			int secondNumber = 4;
			
			// ACT
			int result = calculator.add(firstNumber, secondNumber);
			
			// ASSERT
			assertEquals(10, result);
			
		}
		
		@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
		@CsvSource({ "1,1,2", "2,2,4", "3,4,7", "5,7,12"})
		void testAddTwoNumbers( int firstNumber, int secondNumber, int expectedResult ) {
			
			// ARRANGE
			
			// ACT
			int actualResult = calculator.add(firstNumber, secondNumber);
			
			// ASSERT
			assertThat(actualResult).isEqualTo(expectedResult);
		}
		
		@Test
		void testMultiplyTwoPositiveNumbers() {
			
			// ARRANGE 
			int firstNumber = 4;
			int secondNumber = 5;
			
			// ACT
			int result = calculator.multiply(firstNumber, secondNumber);
			
			// ASSERT
			assertThat(result).isEqualTo(20);
		}
		
		@ParameterizedTest(name = "{0} x 0 est égal à 0")
		@ValueSource(ints = { 1, 2, 3, 5, 8, 13 })
		public void multiplyByZero_shouldReturnZero(int arg) {
			
			// ARRANGE
			
			// ACT
			int result = calculator.multiply(arg, 0);
			
			// ASSERT
			assertThat(result).isEqualTo(0);
		}
		
		@Test
		void testDivideTwoPositiveNumbers() {
			
			// ARRANGE 
			int firstNumber = 8;
			int secondNumber = 2;
			
			// ACT
			int result = calculator.divide(firstNumber, secondNumber);
			
			// ASSERT
			assertThat(result).isEqualTo(4);
		}
		
		@Test
		void testSubstractTwoPositiveNumbers() {
			
			// ARRANGE
			int firstNumber = 40;
			int secondNumber = 13;
			
			// ACT
			int result = calculator.substract(firstNumber, secondNumber);
			
			// ASSERT
			assertThat(result).isEqualTo(27);
		}
		
		@Test
		public void digitsSet_shouldReturnSetOfPositiveIntegers() {
			
			// GIVEN
			int number = 87452;
			
			// WHEN
			Set<Integer> actualDigits = calculator.toDigitsSet(number);
			
			// THEN
			assertThat(actualDigits).containsExactlyInAnyOrder(8,7,4,5,2);
		}
		
		@Test
		public void digitsSet_shouldAcceptNegativeNumbers() {
			
			// GIVEN
			int number = -2422;
			
			// WHEN
			Set<Integer> actualDigits = calculator.toDigitsSet(number);
			
			// THEN
			assertThat(actualDigits).containsExactlyInAnyOrder(2,4);
		}
	
		@Test
		public void digitsSet_shouldReturnAlistOfZeros() {
			
			// GIVEN
			int number = 0;
			
			// WHEN
			Set<Integer> actualDigits = calculator.toDigitsSet(number);
			
			// THEN
			assertThat(actualDigits).containsExactly(0);
		}
		
}
