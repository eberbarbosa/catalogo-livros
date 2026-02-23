package br.com.eber.catalogo_livros.repository;

import br.com.eber.catalogo_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long > {

    List<Livro> findByAutorContainingIgnoreCase(String autor);

    boolean existsByIsbn(String isbn);

}
