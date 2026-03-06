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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Livros", description = "API para gerenciamento de livros")
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {

        this.livroService = livroService;
    }


@Operation(summary = "Listar todos os livros")
@GetMapping
public ResponseEntity<PageResponseDTO<LivroResponseDTO>> listar(
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String autor,
        @RequestParam(required = false) Integer ano,
        @RequestParam(required = false) Integer anoInicio,
        @RequestParam(required = false) Integer anoFim,
        @RequestParam(required = false) BigDecimal precoMin,
        @RequestParam(required = false) BigDecimal precoMax,
        Pageable pageable) {

    Page<LivroResponseDTO> page = livroService
            .buscarComFiltrosPaginado(
                    titulo,
                    autor,
                    ano,
                    anoInicio,
                    anoFim,
                    precoMin,
                    precoMax,
                    pageable)
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


    @Operation(summary = "Buscar livro por ID")
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


    @Operation(summary = "Cadastrar um novo livro")
    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvar(
            @RequestBody @Valid LivroRequestDTO dto) {

        Livro livro = new Livro(
                null,
                dto.getTitulo(),
                dto.getAutor(),
                dto.getPreco(),
                dto.getIsbn(),
                dto.getAnoPublicacao()
        );

        Livro livroSalvo = livroService.salvar(livro);

        LivroResponseDTO response = new LivroResponseDTO(
                livroSalvo.getId(),
                livroSalvo.getTitulo(),
                livroSalvo.getAutor(),
                livroSalvo.getPreco(),
                livroSalvo.getIsbn(),
                livroSalvo.getAnoPublicacao()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualizar um livro")
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid LivroRequestDTO dto) {

        Livro livro = new Livro(
                id,
                dto.getTitulo(),
                dto.getAutor(),
                dto.getPreco(),
                dto.getIsbn(),
                dto.getAnoPublicacao()
        );

        Livro livroAtualizado = livroService.atualizar(id, livro);

        LivroResponseDTO response = new LivroResponseDTO(
                livroAtualizado.getId(),
                livroAtualizado.getTitulo(),
                livroAtualizado.getAutor(),
                livroAtualizado.getPreco(),
                livroAtualizado.getIsbn(),
                livroAtualizado.getAnoPublicacao()
        );

        return ResponseEntity.ok(response);
    }


}


