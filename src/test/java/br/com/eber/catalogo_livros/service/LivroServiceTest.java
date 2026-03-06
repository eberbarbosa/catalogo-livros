package br.com.eber.catalogo_livros.service;

import br.com.eber.catalogo_livros.model.Livro;
import br.com.eber.catalogo_livros.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    private Livro livroExemplo;

    @BeforeEach
    void setUp() {
        livroExemplo = new Livro(
                null,
                "Java Básico",
                "Eber Barbosa",
                new BigDecimal("150.00"),
                "1234567890",
                2026
        );
    }

    // 6️⃣ Primeiro teste: salvar livro
    @Test
    void deveSalvarLivroCorretamente() {
        // quando salvar for chamado no repository, retorna o livro com id
        Livro livroSalvo = new Livro(
                1L,
                livroExemplo.getTitulo(),
                livroExemplo.getAutor(),
                livroExemplo.getPreco(),
                livroExemplo.getIsbn(),
                livroExemplo.getAnoPublicacao()
        );

        when(livroRepository.save(livroExemplo)).thenReturn(livroSalvo);

        Livro resultado = livroService.salvar(livroExemplo);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Java Básico", resultado.getTitulo());

        // verifica se repository.save foi chamado exatamente 1 vez
        verify(livroRepository, times(1)).save(livroExemplo);
    }

    @Test
    void deveBuscarLivroPorId() {

        Livro livro = new Livro();
        livro.setId(1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        Livro resultado = livroService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
    }

    @Test
    void deveDeletarLivro() {

        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Java");
        livro.setAutor("Autor");

        when(livroRepository.findById(1L))
                .thenReturn(Optional.of(livro));

        livroService.deletar(1L);

        verify(livroRepository).delete(livro);
    }
}
