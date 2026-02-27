package br.com.eber.catalogo_livros.repository.specification;

import br.com.eber.catalogo_livros.model.Livro;
import org.springframework.data.jpa.domain.Specification;

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
}
