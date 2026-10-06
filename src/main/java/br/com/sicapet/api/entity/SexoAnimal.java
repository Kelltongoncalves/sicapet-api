package br.com.sicapet.api.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexoAnimal {
    MACHO("Macho"), FEMEA("Fêmea");
    private final String descricao;
    SexoAnimal(String descricao){this.descricao=descricao;}
    @JsonValue public String getDescricao(){return descricao;}
    @JsonCreator
    public static SexoAnimal fromValue(String value){
        for(SexoAnimal s: values())
            if(s.name().equalsIgnoreCase(value) || s.descricao.equalsIgnoreCase(value)) return s;
        throw new IllegalArgumentException("Sexo inválido: " + value);
    }
}
