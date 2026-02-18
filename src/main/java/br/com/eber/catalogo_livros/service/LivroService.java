package br.com.eber.catalogo_livros.service;

import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public void deletar(Long id) {
        livroRepository.findById(id);
    }
}
