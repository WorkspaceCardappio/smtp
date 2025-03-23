package br.com.cardappio.smtp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SMTPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SMTPApplication.class, args);
	}

}
