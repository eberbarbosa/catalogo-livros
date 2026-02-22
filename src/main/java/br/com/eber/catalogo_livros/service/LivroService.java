package br.com.eber.catalogo_livros.service;

import br.com.eber.catalogo_livros.exception.LivroNaoEncontradoException;
import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.repository.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
