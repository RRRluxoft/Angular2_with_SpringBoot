package home.investigation.rrr.fullstackappangularspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class FullStackAppAngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackAppAngularSpringBootApplication.class, args);
	}
}
