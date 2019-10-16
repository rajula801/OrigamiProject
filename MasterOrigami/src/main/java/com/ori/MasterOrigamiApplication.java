package com.ori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MasterOrigamiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterOrigamiApplication.class, args);
	}

}
