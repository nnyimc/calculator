package testing.model;

public enum CalculationType {
	ADDITION,
	MULTIPLICATION,
	DIVISION,
	SUBSTRACTION,
	CONVERSION;
	
	public static CalculationType fromSymbol(String operation) {
		
		switch(operation) {
			case "+":
				return ADDITION; 
			case "-":
				return SUBSTRACTION;
			case "/":
				return DIVISION;
			case "*":
				return MULTIPLICATION;
			case "x":
				return MULTIPLICATION;
			default:
				throw new UnsupportedOperationException("Not implemented yet");
		}
	}
}
