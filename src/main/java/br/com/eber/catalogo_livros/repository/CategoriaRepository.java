package br.com.eber.catalogo_livros.repository;



import br.com.eber.catalogo_livros.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
