package testing.services.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import testing.business.Calculator;
import testing.model.CalculationModel;
import testing.model.CalculationType;
import testing.presentation.SolutionFormatter;
import testing.service.CalculatorService;
import testing.service.CalculatorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	@Mock
	Calculator calculator;
	
	@Mock
	SolutionFormatter solutionFormatter;
	
	CalculatorService calculatorService;
	
	@BeforeEach
	public void init() {
		calculatorService = new CalculatorServiceImpl(calculator, solutionFormatter);
	}
	
	@Test
	public void calculate_shouldUseCalculatorOnce() {
		
		// GIVEN
		when(calculator.add(4, 5)).thenReturn(9);
		
		// WHEN
		calculatorService.calculate( new CalculationModel(CalculationType.ADDITION, 4, 5) ).getSolution();
		
		// THEN
		verify(calculator , times(1)).add(4,5);
	}
	
	@Test
	public void calculate_shouldUseCalculator_forAddition() {
		
		// GIVEN
		when(calculator.add(3, 0)).thenReturn(3);
		
		// WHEN
		final int result = calculatorService.calculate( new CalculationModel(CalculationType.ADDITION, 3, 0) ).getSolution();
		
		// THEN
		assertThat(result).isEqualTo(3);
		
	}
	
	@Test
	public void calculate_shouldUseCalculatorAddition_withoutUsingCalculatorSubstraction() {
		
		// GIVEN
		when(calculator.add(3, 0)).thenReturn(3);
		
		// WHEN
		calculatorService.calculate(new CalculationModel(CalculationType.ADDITION, 3, 0)).getSolution();
		
		// THEN
		verify( calculator, never() ).substract(3, 0);
	}
	
	@Test
	public void calculate_shouldThrowException_whenDividingByZero() {
		
		// GIVEN
		when( calculator.divide(10, 0) ).thenThrow( new ArithmeticException() );
		
		// WHEN
		assertThrows( ArithmeticException.class, () -> calculatorService.calculate( new CalculationModel(CalculationType.DIVISION, 10, 0) ) );
	
	   // THEN
		verify(calculator, times(1)).divide(10, 0);
	}
	
	@Test
	public void shouldFormatSolution_whenDoingAddition() {
		
		// GIVEN
		when(calculator.add(2000000, 100)).thenReturn(2000100);
		when(solutionFormatter.format(2000100)).thenReturn("2 000 100");
		
		// WHEN
		final String formattedResult = calculatorService
				.calculate(new CalculationModel(CalculationType.ADDITION, 2000000, 100))
				.getFormattedSolution();
		
		// THEN
		assertThat(formattedResult).isEqualTo("2 000 100");
	}

	
}
