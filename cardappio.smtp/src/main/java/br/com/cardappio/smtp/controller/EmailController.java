package br.com.cardappio.smtp.controller;

import br.com.cardappio.smtp.dto.EmailRequest;
import br.com.cardappio.smtp.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody @Valid EmailRequest request) throws MessagingException {

        service.sendEmail(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
