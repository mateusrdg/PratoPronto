package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import javassist.NotFoundException;

import java.util.List;

public interface PedidoServicePort {

    PedidoDTO buscarPedidoPorCpf(String cpf)throws NotFoundException;

    void criaPedido(PedidoDTO pedidoDTO) throws NotFoundException;

    List<PedidoDTO> buscarPedidos();

}
