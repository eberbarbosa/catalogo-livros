package br.com.eber.catalogo_livros.service;

import br.com.eber.catalogo_livros.exception.LivroNaoEncontradoException;
import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.repository.LivroRepository;
import br.com.eber.catalogo_livros.repository.specification.LivroSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();

    }


    public Livro salvar(Livro livro) {

        System.out.println("ISBN recebido: '" + livro.getIsbn() + "'");
        System.out.println("Existe? " + livroRepository.existsByIsbn(livro.getIsbn()));

        if (livroRepository.existsByIsbn(livro.getIsbn())) {
            throw new IsbnDuplicadoException("!!! ISBN já cadastrado. !!!");
        }

        return livroRepository.save(livro);
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() ->
                        new LivroNaoEncontradoException("Livro não encontrado"));
    }

    public void deletar(Long id) {
        livroRepository.findById(id);
    }

    public Page<Livro> listar(Pageable pageable) {
        return livroRepository.findAll(pageable);
    }

    public List<Livro> buscarPorAutor(String nomeAutor) {
        return livroRepository.findByAutorContainingIgnoreCase(nomeAutor);
    }

    public List<Livro> buscarComFiltros(String titulo, String autor, Integer ano) {

        Specification<Livro> spec = Specification.allOf();

        if (titulo != null && !titulo.isBlank()) {
            spec = spec.and(LivroSpecification.tituloContains(titulo));
        }

        if (autor != null && !autor.isBlank()) {
            spec = spec.and(LivroSpecification.autorContains(autor));
        }

        if (ano != null) {
            spec = spec.and(LivroSpecification.anoIgual(ano));
        }

        return livroRepository.findAll(spec);
    }


    public Page<Livro> buscarComFiltrosPaginado(
            String titulo,
            String autor,
            Integer ano,
            Pageable pageable) {

        Specification<Livro> spec = Specification.allOf();

        if (titulo != null && !titulo.isBlank()) {
            spec = spec.and(LivroSpecification.tituloContains(titulo));
        }

        if (autor != null && !autor.isBlank()) {
            spec = spec.and(LivroSpecification.autorContains(autor));
        }

        if (ano != null) {
            spec = spec.and(LivroSpecification.anoIgual(ano));
        }

        return livroRepository.findAll(spec, pageable);
    }

}
