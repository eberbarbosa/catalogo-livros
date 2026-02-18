package br.com.eber.catalogo_livros.repository;

import br.com.eber.catalogo_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long > {
}
