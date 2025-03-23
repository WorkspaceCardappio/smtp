package br.com.cardappio.smtp.service;

import br.com.cardappio.smtp.dto.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    public void sendEmail(EmailRequest request) throws MessagingException {

        MimeMessage message = getMessage(request);

        sender.send(message);

    }

    private MimeMessage getMessage(EmailRequest request) throws MessagingException {
        MimeMessage mensagem = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true, StandardCharsets.UTF_8.name());
        helper.setTo(request.receiver());
        helper.setSubject(request.subject());
        helper.setText(request.content());
        helper.setFrom("trabalhosti7s@gmail.com");

        return mensagem;
    }
}
