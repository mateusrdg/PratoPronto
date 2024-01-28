package com.arquiteturahexagonal.dominio.adaptadores.services;

import com.arquiteturahexagonal.aplicacao.adaptatores.controllers.exception.NotFoundException;
import com.arquiteturahexagonal.dominio.Cliente;
import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.Produto;
import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.ClienteRepositoryPort;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PedidoServiceImp implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;
    private final ClienteRepositoryPort clienteRepositoryPort;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public void criaPedido(PedidoDTO pedidoDTO) throws NotFoundException {
        Cliente cliente = validaCliente(pedidoDTO.getCpfCliente());
        List<Produto> produtos = validaProdutos(pedidoDTO.getProdutos());

        Pedido pedido = new Pedido(produtos, cliente);
        this.pedidoRepositoryPort.salvar(pedido);
    }

    private List<Produto> validaProdutos(List<String> listaSkus) {
        List<Produto> produtos = produtoRepositoryPort.buscarProdutosPorSku(listaSkus);
        if (produtos.isEmpty())
            throw new NotFoundException("Produtos não existem");
        return produtos;
    }

    private Cliente validaCliente(String cpfCliente) {
        Optional<Cliente> clienteOptional = clienteRepositoryPort.buscarPeloCpf(cpfCliente);
        if (clienteOptional.isEmpty())
            throw new NotFoundException("Cliente não existe");
        return clienteOptional.get();
    }

    @Override
    public List<PedidoDTO> buscarPedidos() {
        List<Pedido> pedidos = this.pedidoRepositoryPort.buscarTodos();
        return pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO buscarPedidoPorCpf(String cpf) throws NotFoundException {
        Cliente cliente = validaCliente(cpf);
        Optional<Pedido> pedidoOptional = this.pedidoRepositoryPort.buscarPeloCliente(cliente);
        return pedidoOptional.map(Pedido::toPedidoDTO).orElseThrow(() -> new NotFoundException("Pedido não existe"));
    }

}
