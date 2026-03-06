package br.com.eber.catalogo_livros.exception;

public class IsbnDuplicadoException extends RuntimeException {

    public IsbnDuplicadoException(String message) {
        super(message);
    }
}
