package br.com.arcelino.bookstoreapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arcelino.bookstoreapi.dto.LivroDto;
import br.com.arcelino.bookstoreapi.entity.Livro;
import br.com.arcelino.bookstoreapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> all() {
        return livroRepository.findAll(Sort.by("titulo").ascending());
    }

    public List<LivroDto> getLivros() {
        return livroRepository.getLivros();
    }
}
