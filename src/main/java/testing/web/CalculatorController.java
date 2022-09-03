package testing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import testing.model.CalculationModel;
import testing.service.CalculatorService;
import testing.service.CalculatorServiceImpl;

@Controller
public class CalculatorController {
	
	public static final String CALCULATOR_TEMPLATE = "calculator";
	
	private final CalculatorService calculatorService;
	
	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = (CalculatorServiceImpl) calculatorService;
	}
	
	@GetMapping("/")
	public String index(CalculationModel calculationModel) {
		return "redirect:/calculator";
	}
	
	@GetMapping("/calculator")
	public String root(CalculationModel calculationModel) {
		return CALCULATOR_TEMPLATE;
	}
	
	@PostMapping("/calculator")
	public String calculate(@Valid CalculationModel calculationModel, BindingResult bindingResult, Model model) {
		return CALCULATOR_TEMPLATE;
	}
}
