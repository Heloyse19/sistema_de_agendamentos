package com.org.sistemaAgend.model;

public enum StatusAgendamento {
    AGUARDANDO("Aguardando"),
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado"),
    REALIZADO("Realizado");

    private String descricao;

    StatusAgendamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
