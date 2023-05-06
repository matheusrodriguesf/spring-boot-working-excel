package br.com.arcelino.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcelino.bookstoreapi.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
