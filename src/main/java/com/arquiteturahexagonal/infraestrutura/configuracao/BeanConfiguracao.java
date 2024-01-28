package com.arquiteturahexagonal.infraestrutura.configuracao;

import com.arquiteturahexagonal.dominio.adaptadores.services.ClienteServiceImp;
import com.arquiteturahexagonal.dominio.adaptadores.services.PedidoServiceImp;
import com.arquiteturahexagonal.dominio.adaptadores.services.ProdutoServiceImp;
import com.arquiteturahexagonal.dominio.portas.interfaces.ClienteServicePort;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import com.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.ClienteRepositoryPort;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImp(produtoRepositoryPort);
    }

    @Bean
    ClienteServicePort clienteServicePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new ClienteServiceImp(clienteRepositoryPort);
    }

    @Bean
    PedidoServicePort pedidoServicePort(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        return new PedidoServiceImp(pedidoRepositoryPort, produtoRepositoryPort, clienteRepositoryPort);
    }
}
