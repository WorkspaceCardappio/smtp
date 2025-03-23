package br.com.cardappio.smtp.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @NotBlank(message = "O destinatário é obrigatório.") String receiver,
        @NotBlank(message = "O assunto é obrigatório.") String subject,
        @NotBlank(message = "O conteúdo é obrigatório.") String content
) {}
