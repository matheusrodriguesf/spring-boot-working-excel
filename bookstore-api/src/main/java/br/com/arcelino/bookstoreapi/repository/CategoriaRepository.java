package br.com.arcelino.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcelino.bookstoreapi.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
