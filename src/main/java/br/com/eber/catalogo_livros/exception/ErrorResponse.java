package br.com.eber.catalogo_livros.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private String              message;
    private int                 status;
    private LocalDateTime       timestamp;
    private Map<String, String> errors;

    //  Para erros simples (404, 409, 500)
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.errors = null;
    }

    //  Para erros de validação (400 com mapa)
    public ErrorResponse(String message, int status, Map<String, String> errors) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.errors = errors;
    }


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
