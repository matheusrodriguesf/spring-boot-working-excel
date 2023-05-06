package br.com.arcelino.bookstoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {
    private Integer id;
    private String titulo;
    private String isbn;
    private String editora;
    private String autor;
    private Integer ano;
    private String categoria;
}