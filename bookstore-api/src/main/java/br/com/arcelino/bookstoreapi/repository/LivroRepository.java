package br.com.arcelino.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arcelino.bookstoreapi.dto.LivroDto;
import br.com.arcelino.bookstoreapi.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("""
            select new br.com.arcelino.bookstoreapi.dto.LivroDto(
                livro.titulo as titulo,
                livro.isbn as isbn,
                livro.editora as editora,
                livro.autor as autor,
                livro.ano as ano,
                livro.categoria.nome as categoria)
                from Livro livro
                """)
    List<LivroDto> getLivros();

}
