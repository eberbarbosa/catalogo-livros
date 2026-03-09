package br.com.eber.catalogo_livros.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados retornados de um livro")
public class LivroResponseDTO {

//    private Long       id;
//    private String     titulo;
//    private String     autor;
//    private BigDecimal preco;
//    private String     isbn;
//    private int        anoPublicacao;

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Clean Code")
    private String titulo;

    @Schema(example = "Robert C. Martin")
    private String autor;

    @Schema(example = "120.50")
    private BigDecimal preco;

    @Schema(example = "9780132350884")
    private String isbn;

    @Schema(example = "2008")
    private int anoPublicacao;

    public LivroResponseDTO(Long id, String titulo, String autor, BigDecimal preco, String isbn, int anoPublicacao) {
        this.id =            id;
        this.titulo =        titulo;
        this.autor =         autor;
        this.preco =         preco;
        this.isbn =          isbn;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
