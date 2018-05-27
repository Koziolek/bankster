package pl.koziolekweb.jlns.bankster;

import pl.koziolekweb.jlns.bankster.configuration.GatewaySpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApplicationStarter {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewaySpringConfiguration.class, args);
	}
}

