package ambiental.sustentavel.entities;

import java.time.LocalDate;

import ambiental.sustentavel.enums.CategoriaAcao;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String titulo;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column
    private String responsavel;

    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;

    @Column(nullable = false)
    private LocalDate dataRealizacao;

}
