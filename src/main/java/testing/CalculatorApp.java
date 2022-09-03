package testing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"testing.service"})
public class CalculatorApp {
	
	public static void main(String[]args) {
		SpringApplication.run(CalculatorApp.class, args);
	}

}
