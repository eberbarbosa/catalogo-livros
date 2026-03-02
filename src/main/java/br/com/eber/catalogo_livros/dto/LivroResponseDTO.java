package br.com.eber.catalogo_livros.dto;

import java.math.BigDecimal;

public class LivroResponseDTO {

    private Long   id;
    private String titulo;
    private String autor;
    private Double preco;
    private String isbn;
    private int    anoPublicacao;

    public LivroResponseDTO(Long id, String titulo, String autor, BigDecimal preco, String isbn, Integer anoPublicacao) {}


    public LivroResponseDTO(Long id, String titulo, String autor, Double preco, String isbn, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
