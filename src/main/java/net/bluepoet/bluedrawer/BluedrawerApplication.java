package net.bluepoet.bluedrawer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BluedrawerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluedrawerApplication.class, args);
	}
}
