package br.com.eber.catalogo_livros.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private String              message;
    private int                 status;
    private LocalDateTime       timestamp;
    private Map<String, String> errors;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, int status, Map<String, String> errors) {
        this(message, status);
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
