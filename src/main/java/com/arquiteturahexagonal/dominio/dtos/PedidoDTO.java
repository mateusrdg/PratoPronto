package com.arquiteturahexagonal.dominio.dtos;

import com.arquiteturahexagonal.dominio.enums.StatusEnum;

import java.util.List;

public class PedidoDTO {
    private List<String> produtos;
    private String cpfCliente;
    private StatusEnum status;

    public PedidoDTO(List<String> produtos, String cpfCliente, StatusEnum status) {
        this.produtos = produtos;
        this.cpfCliente = cpfCliente;
        this.status = status;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
