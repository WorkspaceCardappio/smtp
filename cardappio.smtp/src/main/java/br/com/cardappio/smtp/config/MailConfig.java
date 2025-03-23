package br.com.cardappio.smtp.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender mailSender() {

        Dotenv dotenv = Dotenv.load();

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(dotenv.get("MAIL_HOST"));
        mailSender.setPort(Integer.parseInt(dotenv.get("MAIL_PORT")));
        mailSender.setUsername(dotenv.get("MAIL_USERNAME"));
        mailSender.setPassword(dotenv.get("MAIL_PASSWORD"));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.trust", dotenv.get("MAIL_HOST"));
        properties.put("mail.smtp.from", dotenv.get("MAIL_USERNAME"));

        return mailSender;
    }
}
