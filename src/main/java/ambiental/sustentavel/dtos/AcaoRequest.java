package ambiental.sustentavel.dtos;

import java.time.LocalDate;

import ambiental.sustentavel.enums.CategoriaAcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record AcaoRequest(

    @NotBlank
    String titulo,

    @Size(max = 255, message = "a descrição pode ter no máximo 255 letras")
    String descricao,

    @NotBlank
    String responsavel,

    @NotNull
    CategoriaAcao categoria,

    @PastOrPresent
    LocalDate dataRealizacao
) {}