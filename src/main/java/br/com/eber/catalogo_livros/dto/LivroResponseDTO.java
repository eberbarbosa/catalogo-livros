package br.com.eber.catalogo_livros.dto;

public class LivroResponseDTO {

    private Long   id;
    private String titulo;
    private String autor;
    private Double preco;
    private int    isbn;
    private int    anoPublicacao;

    public LivroRequestDTO(){}

    public LivroResponseDTO(Long id, String titulo, String autor, Double preco, int isbn, int anoPublicacao) {
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

    public int getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
