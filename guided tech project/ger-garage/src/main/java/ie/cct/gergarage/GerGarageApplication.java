package ie.cct.gergarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GerGarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerGarageApplication.class, args);
	}

}
