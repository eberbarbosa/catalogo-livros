package br.com.eber.catalogo_livros.model;

import jakarta.persistence.*;

@Entity
@Table(name="livro")
public class Livro {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long   id;
    private String titulo;
    private String autor;
    private Double preco;
    private String isbn;
    private int    anoPublicacao;

    public Livro() {}


    public Livro(Long id, String titulo, String autor, Double preco, String isbn, int anoPublicacao) {
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

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
