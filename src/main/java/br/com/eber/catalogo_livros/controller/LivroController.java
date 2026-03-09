package br.com.eber.catalogo_livros.controller;

import br.com.eber.catalogo_livros.dto.LivroRequestDTO;
import br.com.eber.catalogo_livros.dto.LivroResponseDTO;
import br.com.eber.catalogo_livros.dto.PageResponseDTO;
import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.service.LivroService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;



@CrossOrigin(origins = "*")
@Tag(name = "Livros", description = "API para gerenciamento de livros")
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {

        this.livroService = livroService;
    }


//@Operation(summary = "Listar todos os livros")
//@GetMapping
//public ResponseEntity<PageResponseDTO<LivroResponseDTO>> listar(
//
//        @RequestParam(required = false) String titulo,
//        @RequestParam(required = false) String autor,
//        @RequestParam(required = false) Integer ano,
//        @RequestParam(required = false) Integer anoInicio,
//        @RequestParam(required = false) Integer anoFim,
//        @RequestParam(required = false) BigDecimal precoMin,
//        @RequestParam(required = false) BigDecimal precoMax,
//        Pageable pageable) {

    @Operation(summary = "Listar todos os livros com filtros e paginação")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Lista de livros retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<PageResponseDTO<LivroResponseDTO>> listar(

            @Parameter(description = "Filtrar livros pelo título")
            @RequestParam(required = false) String titulo,

            @Parameter(description = "Filtrar livros pelo autor")
            @RequestParam(required = false) String autor,

            @Parameter(description = "Filtrar por ano específico")
            @RequestParam(required = false) Integer ano,

            @Parameter(description = "Ano inicial do intervalo")
            @RequestParam(required = false) Integer anoInicio,

            @Parameter(description = "Ano final do intervalo")
            @RequestParam(required = false) Integer anoFim,

            @Parameter(description = "Preço mínimo do livro")
            @RequestParam(required = false) BigDecimal precoMin,

            @Parameter(description = "Preço máximo do livro")
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



//    @Operation(summary = "Buscar livro por ID")
//    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Livro encontrado"),
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
})
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


//    @Operation(summary = "Cadastrar um novo livro")
//    @PostMapping
    @Operation(summary = "Cadastrar um novo livro")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Livro cadastrado com sucesso"),
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
})
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

//    @Operation(summary = "Atualizar um livro")
//    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um livro")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
})
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

//    @Operation(summary = "Remover um livro")
//    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um livro")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Livro removido com sucesso"),
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        livroService.deletar(id);

        return ResponseEntity.noContent().build();
    }


}


