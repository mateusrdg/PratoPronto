package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.dtos.ClienteDTO;
import com.arquiteturahexagonal.dominio.dtos.EstoqueDTO;
import com.arquiteturahexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ClienteServicePort {

    ClienteDTO buscarClientePorCpf(String cpf)throws NotFoundException;

    void cadastraCliente(ClienteDTO clienteDTO);

}
