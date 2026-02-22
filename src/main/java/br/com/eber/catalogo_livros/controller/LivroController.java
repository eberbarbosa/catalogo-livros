package br.com.eber.catalogo_livros.controller;

import br.com.eber.catalogo_livros.dto.LivroRequestDTO;
import br.com.eber.catalogo_livros.dto.LivroResponseDTO;
import br.com.eber.catalogo_livros.dto.PageResponseDTO;
import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<PageResponseDTO<LivroResponseDTO>> listar (Pageable pageable) {

        Page<LivroResponseDTO> page = livroService.listar(pageable)
                .map(livro -> new LivroResponseDTO(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getPreco(),
                        livro.getIsbn(),
                        livro.getAnoPublicacao()
                ));
        return ResponseEntity.ok(new PageResponseDTO<>(page));

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

    @GetMapping("/autor")
    public ResponseEntity<List<LivroResponseDTO>> buscarPorAutor(@RequestParam String nome) {

        List<LivroResponseDTO> lista = livroService.buscarPorAutor(nome)
                .stream()
                .map(livro -> new LivroResponseDTO(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getPreco(),
                        livro.getIsbn(),
                        livro.getAnoPublicacao()
                ))
                .toList();

        return ResponseEntity.ok(lista);
    }




}


