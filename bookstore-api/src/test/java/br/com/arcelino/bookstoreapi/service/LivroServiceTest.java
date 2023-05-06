package br.com.arcelino.bookstoreapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import br.com.arcelino.bookstoreapi.dto.LivroDto;
import br.com.arcelino.bookstoreapi.entity.Livro;
import br.com.arcelino.bookstoreapi.repository.LivroRepository;

public class LivroServiceTest {

    @Test
    public void testAll() {
        var livroRepository = mock(LivroRepository.class);
        List<Livro> expectedLivros = new ArrayList<>();
        expectedLivros.add(new Livro(1, "Titulo 1", "Descricao 1", "Autor 1", "Editora 1", "ISBN 1", 2021, null));
        expectedLivros.add(new Livro(2, "Titulo 2", "Descricao 2", "Autor 2", "Editora 2", "ISBN 2", 2022, null));
        when(livroRepository.findAll(Sort.by("titulo").ascending())).thenReturn(expectedLivros);

        var livroService = new LivroService(livroRepository);
        var actualLivros = livroService.all();

        verify(livroRepository).findAll(Sort.by("titulo").ascending());
        assertEquals(expectedLivros, actualLivros);
    }

    @Test
    public void testGetLivros() {

        var livroRepository = mock(LivroRepository.class);
        List<LivroDto> expectedLivrosDto = new ArrayList<>();
        expectedLivrosDto.add(new LivroDto(1, "Titulo 1", "ISBN 1", "Editora 1", "Autor 1", 2021, "Categoria 1"));
        expectedLivrosDto.add(new LivroDto(2, "Titulo 2", "ISBN 2", "Editora 2", "Autor 2", 2022, "Categoria 2"));
        when(livroRepository.getLivros()).thenReturn(expectedLivrosDto);

        var livroService = new LivroService(livroRepository);
        var actualLivrosDto = livroService.getLivros();

        verify(livroRepository).getLivros();
        assertEquals(expectedLivrosDto, actualLivrosDto);
    }
}