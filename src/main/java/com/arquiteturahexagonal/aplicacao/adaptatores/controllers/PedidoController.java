package com.arquiteturahexagonal.aplicacao.adaptatores.controllers;

import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    void criaPedido(@RequestBody PedidoDTO pedidoDTO)throws NotFoundException {
        pedidoServicePort.criaPedido(pedidoDTO);
    }

    @GetMapping(value = "/{cpf}")
    PedidoDTO buscarPedidoPorCpf(@PathVariable String cpf) throws NotFoundException {
        return pedidoServicePort.buscarPedidoPorCpf(cpf);
    }

    @GetMapping()
    List<PedidoDTO> getPedidos() {
        return pedidoServicePort.buscarPedidos();
    }
}
