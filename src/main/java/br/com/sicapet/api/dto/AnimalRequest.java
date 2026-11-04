package br.com.sicapet.api.dto;

import br.com.sicapet.api.entity.SexoAnimal;
import br.com.sicapet.api.entity.TipoAnimal;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AnimalRequest(
    @NotNull TipoAnimal tipo,
    @NotNull SexoAnimal sexo,
    @NotNull @Min(1) Integer quantidade,
    @NotNull Long idTutor
) {}
