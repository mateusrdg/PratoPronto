package com.arquiteturahexagonal.dominio.adaptadores.services;

import com.arquiteturahexagonal.aplicacao.adaptatores.controllers.exception.NotFoundException;
import com.arquiteturahexagonal.dominio.Cliente;
import com.arquiteturahexagonal.dominio.dtos.ClienteDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.ClienteServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.ClienteRepositoryPort;

import java.util.Optional;

public class ClienteServiceImp implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImp(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public void cadastraCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        this.clienteRepositoryPort.salvar(cliente);
    }

    @Override
    public ClienteDTO buscarClientePorCpf(String cpf) {
        Optional<Cliente> cliente = this.clienteRepositoryPort.buscarPeloCpf(cpf);
        return cliente.map(Cliente::toClienteDTO).orElseThrow(() -> new NotFoundException("Cliente não existe"));
    }

}
