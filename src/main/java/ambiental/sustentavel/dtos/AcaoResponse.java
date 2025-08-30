package ambiental.sustentavel.dtos;

import java.time.LocalDate;

import ambiental.sustentavel.enums.CategoriaAcao;

public record AcaoResponse(
    Long id,
    
    String titulo,

    String descricao,

    String responsavel,

    CategoriaAcao categoria,

    LocalDate dataRealizacao
){}
