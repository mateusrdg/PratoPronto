package com.pratopronto.dominio.portas.interfaces;

import com.pratopronto.dominio.dtos.pedido.AtualizaPedidoDTO;
import com.pratopronto.dominio.dtos.pedido.PedidoDTO;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface PedidoServicePort {
    PedidoDTO buscarPedidoPorCpf(String cpf)throws NotFoundException;
    PedidoDTO criaPedido(PedidoDTO pedidoDTO) throws NotFoundException;
    List<PedidoDTO> buscarPedidos();
    void atualizaStatus(UUID id, AtualizaPedidoDTO atualizaPedidoDTO)throws NotFoundException;

}
