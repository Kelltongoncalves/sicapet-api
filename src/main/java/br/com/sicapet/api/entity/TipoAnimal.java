package br.com.sicapet.api.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoAnimal {
    CAO("Cão"), GATO("Gato");
    private final String descricao;
    TipoAnimal(String descricao){this.descricao=descricao;}
    @JsonValue public String getDescricao(){return descricao;}
    @JsonCreator
    public static TipoAnimal fromValue(String value){
        for(TipoAnimal t: values())
            if(t.name().equalsIgnoreCase(value) || t.descricao.equalsIgnoreCase(value)) return t;
        throw new IllegalArgumentException("Tipo de animal inválido: " + value);
    }
}
