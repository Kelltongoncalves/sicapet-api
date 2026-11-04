package br.com.sicapet.api.dto;
import br.com.sicapet.api.entity.SexoAnimal;
import br.com.sicapet.api.entity.TipoAnimal;
public record AnimalResponse(Long id, TipoAnimal tipo, SexoAnimal sexo, Integer quantidade,
                             Long idTutor, String nomeTutor, String bairro) {}
