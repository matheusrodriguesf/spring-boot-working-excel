package br.com.arcelino.bookstoreapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_livro")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_livro")
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "isbn", nullable = false, length = 13)
    private String isbn;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "editora", nullable = false, length = 100)
    private String editora;

    @Column(name = "ano_publicacao", nullable = false, length = 4)
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

}