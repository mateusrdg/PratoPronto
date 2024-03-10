package com.pratopronto.dominio.portas.interfaces;

import com.pratopronto.dominio.dtos.cliente.ClienteDTO;
import javassist.NotFoundException;

public interface ClienteServicePort {

    ClienteDTO buscarClientePorCpf(String cpf)throws NotFoundException;

    void cadastraCliente(ClienteDTO clienteDTO);

}
