package br.com.eber.catalogo_livros.controller;

import br.com.eber.catalogo_livros.dto.LivroRequestDTO;
import br.com.eber.catalogo_livros.dto.LivroResponseDTO;
import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {

        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarTodos() {

        List<LivroResponseDTO> lista = livroService.listarTodos()
                .stream()
                .map(livro -> new LivroResponseDTO(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getPreco(),
                        livro.getIsbn(),
                        livro.getAnoPublicacao()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvar(@Valid @RequestBody LivroRequestDTO dto) {

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setPreco(dto.getPreco());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        Livro novoLivro = livroService.salvar(livro);

        LivroResponseDTO response = new LivroResponseDTO(
                novoLivro.getId(),
                novoLivro.getTitulo(),
                novoLivro.getAutor(),
                novoLivro.getPreco(),
                novoLivro.getIsbn(),
                novoLivro.getAnoPublicacao()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Long id) {

        Livro livro = livroService.buscarPorId(id);

        LivroResponseDTO dto = new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco(),
                livro.getIsbn(),
                livro.getAnoPublicacao()
        );

        return ResponseEntity.ok(dto);
    }
}


