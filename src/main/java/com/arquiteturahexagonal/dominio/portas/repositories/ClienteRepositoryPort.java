package com.arquiteturahexagonal.dominio.portas.repositories;

import com.arquiteturahexagonal.dominio.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {

    Optional<Cliente> buscarPeloCpf(String cpf);

    void salvar(Cliente cliente);
}
