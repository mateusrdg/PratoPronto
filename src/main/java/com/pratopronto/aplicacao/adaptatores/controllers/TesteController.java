package com.pratopronto.aplicacao.adaptatores.controllers;

import com.pratopronto.aplicacao.adaptatores.controllers.exception.NotFoundException;
import com.pratopronto.dominio.dtos.cliente.ClienteDTO;
import com.pratopronto.dominio.portas.interfaces.ClienteServicePort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("testes")
public class TesteController {

    private final ClienteServicePort clienteServicePort;

    public TesteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @PostMapping
    void cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        clienteServicePort.cadastraCliente(clienteDTO);
    }

    @GetMapping( )
    String buscarClientePorCpf() throws NotFoundException {
        return "Teste";
    }
}
