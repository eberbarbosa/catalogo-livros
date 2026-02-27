package br.com.eber.catalogo_livros.exception;

import br.com.eber.catalogo_livros.service.IsbnDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        erros.put(error.getField(), error.getDefaultMessage()));

        ErrorResponse response = new ErrorResponse(
                "Erro de validação",
                HttpStatus.BAD_REQUEST.value(),
                erros
        );

        return ResponseEntity.badRequest().body(response);
    }

    // ISBN duplicado
    @ExceptionHandler(IsbnDuplicadoException.class)
    public ResponseEntity<ErrorResponse> handleIsbnDuplicado(IsbnDuplicadoException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.CONFLICT.value()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    // Livro não encontrado
    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            LivroNaoEncontradoException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getClass().getName(),
                500
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}