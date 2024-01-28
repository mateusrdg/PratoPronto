package com.arquiteturahexagonal.dominio.portas.repositories;

import com.arquiteturahexagonal.dominio.Cliente;
import com.arquiteturahexagonal.dominio.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {

    Optional<Pedido> buscarPeloCliente(Cliente cliente);

    void salvar(Pedido pedido);

    List<Pedido> buscarTodos();
}
