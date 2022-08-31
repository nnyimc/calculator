package testing.model;

public class CalculationModel {
	
	private static final String SEPARATOR = " ";
	private Integer leftArgument;
	private Integer rightArgument;
	private CalculationType calculationType;
	private Integer solution;
	
	public CalculationModel(CalculationType calculationType, int leftArgument, int rightArgument) {
		
		this.calculationType = calculationType;
		this.leftArgument = leftArgument;
		this.rightArgument = rightArgument;
		
	}
	
	public static CalculationModel fromText(String calculation) {
		
		final String[] parts = calculation.split(SEPARATOR);
		final int leftArgument = Integer.parseInt(parts[0]);
		final int rightArgument = Integer.parseInt(parts[2]);
		final CalculationType calculationType = CalculationType.fromSymbol(parts[1]);
		return new CalculationModel(calculationType, leftArgument, rightArgument);
		
	}

	public Integer getLeftArgument() {
		return leftArgument;
	}

	public void setLeftArgument(Integer leftArgument) {
		this.leftArgument = leftArgument;
	}

	public Integer getRightArgument() {
		return rightArgument;
	}

	public void setRightArgument(Integer rightArgument) {
		this.rightArgument = rightArgument;
	}

	public CalculationType getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(CalculationType calculationType) {
		this.calculationType = calculationType;
	}

	public Integer getSolution() {
		return solution;
	}

	public void setSolution(Integer solution) {
		this.solution = solution;
	}
	
}
