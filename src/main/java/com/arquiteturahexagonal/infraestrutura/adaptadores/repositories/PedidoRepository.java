package com.arquiteturahexagonal.infraestrutura.adaptadores.repositories;

import com.arquiteturahexagonal.dominio.Cliente;
import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.ClienteEntity;
import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository springPedidoRepository;

    public PedidoRepository(SpringPedidoRepository springPedidoRepository) {
        this.springPedidoRepository = springPedidoRepository;
    }

    @Override
    public Optional<Pedido> buscarPeloCliente(Cliente cliente) {
        Optional<PedidoEntity> pedidoEntity = this.springPedidoRepository.findByCliente(cliente);
        return pedidoEntity.map(PedidoEntity::toPedido);
    }

    @Override
    public void salvar(Pedido pedido) {
        var pedidoEntity = new PedidoEntity(pedido);
        this.springPedidoRepository.save(pedidoEntity);
    }

    @Override
    public List<Pedido> buscarTodos() {
        List<PedidoEntity> pedidoEntities = this.springPedidoRepository.findAll();
        return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }
}
