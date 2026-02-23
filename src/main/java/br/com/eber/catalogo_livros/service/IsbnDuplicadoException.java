package br.com.eber.catalogo_livros.service;

public class IsbnDuplicadoException extends RuntimeException {

    public IsbnDuplicadoException(String message) {
        super(message);
    }
}
