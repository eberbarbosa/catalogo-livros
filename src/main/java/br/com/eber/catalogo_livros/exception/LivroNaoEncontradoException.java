package br.com.eber.catalogo_livros.exception;

public class LivroNaoEncontradoException extends RuntimeException {

    public LivroNaoEncontradoException(String mensagem) {

        super(mensagem);

    }
}
