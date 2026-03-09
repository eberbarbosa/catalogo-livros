package br.com.eber.catalogo_livros.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Schema(description = "Dados para cadastro ou atualização de um livro")
public class LivroRequestDTO {

//    @NotBlank(message = "Título é obrigatório")
//    private String titulo;
//
//    @NotBlank(message = "Autor é obrigatório")
//    private String autor;
//
//    @NotNull(message = "Preço é obrigatório")
//    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
//    private BigDecimal preco;
//
//    @NotBlank(message = "ISBN é obrigatório")
//    private String isbn;
//
//    @NotNull(message = "Ano é obrigatório")
//    @Min(value = 1000, message = "Ano inválido")
//    private Integer    anoPublicacao;


        @Schema(example = "Clean Code")
        @NotBlank(message = "Título é obrigatório")
        private String titulo;

        @Schema(example = "Robert C. Martin")
        @NotBlank(message = "Autor é obrigatório")
        private String autor;

        @Schema(example = "120.50")
        @NotNull(message = "Preço é obrigatório")
        private BigDecimal preco;

        @Schema(example = "9780132350884")
        @NotBlank(message = "ISBN é obrigatório")
        private String isbn;

        @Schema(example = "2008")
        @NotNull(message = "Ano é obrigatório")
        private Integer anoPublicacao;


    public LivroRequestDTO(){}


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
