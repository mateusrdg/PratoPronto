package com.arquiteturahexagonal.infraestrutura.adaptadores.entidades;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PedidoProdutoEntity> pedidoProdutos = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    private StatusEnum status;

    public PedidoEntity() {
    }

    public PedidoEntity(Pedido pedido) {
        this.pedidoProdutos = pedido.getProdutos().stream()
                .map(produto -> new PedidoProdutoEntity(this, new ProdutoEntity(produto)))
                .collect(Collectors.toList());
        this.cliente = new ClienteEntity(pedido.getCliente());
        this.status = pedido.getStatus();
    }

    public Pedido toPedido() {
        return new Pedido(this.id, this.pedidoProdutos.stream().map(PedidoProdutoEntity::getProduto)
                .map(ProdutoEntity::toProduto).collect(Collectors.toList()), this.cliente.toCliente(), this.status);
    }
}
