package com.arquiteturahexagonal.dominio;

import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Pedido {

    private UUID id;
    private List<Produto> produtos;
    private Cliente cliente;
    private StatusEnum status;

    public Pedido() {
    }

    public Pedido(UUID id, List<Produto> produtos, Cliente cliente, StatusEnum status) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.status = status;
    }

    public Pedido(List<Produto> produtos, Cliente cliente) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.status = StatusEnum.EM_ANDAMENTO;
    }

    public PedidoDTO toPedidoDTO() {
        return new PedidoDTO(this.produtos.stream().map(Produto::getSku).collect(Collectors.toList()), this.cliente.getCpf(), this.status);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
