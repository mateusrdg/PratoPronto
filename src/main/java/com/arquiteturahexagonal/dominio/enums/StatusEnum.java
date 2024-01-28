package com.arquiteturahexagonal.dominio.enums;

import javassist.NotFoundException;

public enum StatusEnum {
    EM_ANDAMENTO("andamento"),
    EM_ENTREGA("entrega"),
    CONCLUIDO("concluido");

    StatusEnum(String nome) {
        this.nome = nome;
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public static StatusEnum fromNome(String nome) throws NotFoundException {
        for(StatusEnum categoriaEnum : StatusEnum.values()){
            if(categoriaEnum.getNome().equals(nome)){
                return categoriaEnum;
            }
        }
        throw new NotFoundException("Status inexistente");
    }
}
