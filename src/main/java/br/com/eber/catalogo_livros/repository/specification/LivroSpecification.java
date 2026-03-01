package br.com.eber.catalogo_livros.repository.specification;

import br.com.eber.catalogo_livros.model.Livro;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class LivroSpecification {

    public static Specification<Livro> tituloContains(String titulo) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
    }

    public static Specification<Livro> autorContains(String autor) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("autor")), "%" + autor.toLowerCase() + "%");
    }

    public static Specification<Livro> anoIgual(Integer ano) {
        return (root, query, cb) ->
                cb.equal(root.get("anoPublicacao"), ano);
    }

    public static Specification<Livro> anoEntre(Integer inicio, Integer fim) {
        return (root, query, cb) ->
                cb.between(root.get("ano"), inicio, fim);
    }

    public static Specification<Livro> precoEntre(BigDecimal min, BigDecimal max) {
        return (root, query, cb) ->
                cb.between(root.get("preco"), min, max);
    }
}
