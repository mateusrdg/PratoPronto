package com.arquiteturahexagonal.aplicacao.adaptatores.controllers;

import com.arquiteturahexagonal.dominio.dtos.ClienteDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.ClienteServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @PostMapping
    void cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        clienteServicePort.cadastraCliente(clienteDTO);
    }

    @GetMapping(value = "/{cpf}")
    ClienteDTO buscarClientePorCpf(@PathVariable String cpf) throws NotFoundException {
        return clienteServicePort.buscarClientePorCpf(cpf);
    }
}
