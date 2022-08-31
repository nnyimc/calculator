package testing.service;

import testing.business.Calculator;
import testing.model.CalculationModel;
import testing.model.CalculationType;
import testing.presentation.SolutionFormatter;

public class CalculatorServiceImpl implements CalculatorService {
	
	private final Calculator calculator;
	private SolutionFormatter solutionFormatter;
	
	public CalculatorServiceImpl (Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public CalculationModel calculate(CalculationModel calculationModel) {
		final CalculationType calculationType = calculationModel.getCalculationType();
		
		Integer response = null;
		
		switch(calculationType) {
			case ADDITION:
				response = calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
				break;
			case SUBSTRACTION:
				response = calculator.substract(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
				break;
			case MULTIPLICATION:
				response = calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
				break;
			case DIVISION:
				response = calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
				break;
			default:
				throw new UnsupportedOperationException("Unsupported calculations");
		}
		calculationModel.setSolution(response);
		return calculationModel;
	}

}
