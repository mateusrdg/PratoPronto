package com.arquiteturahexagonal.aplicacao.adaptatores.controllers;

import com.arquiteturahexagonal.dominio.dtos.ProdutoDTO;
import com.arquiteturahexagonal.dominio.enums.CategoriaEnum;
import com.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void criar(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.criar(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{sku}")
    void atualizar(@PathVariable String sku, @RequestBody ProdutoDTO produtoDTO) throws NotFoundException {
        produtoServicePort.atualizar(sku, produtoDTO);
    }

    @DeleteMapping(value = "/{sku}")
    void deletar(@PathVariable String sku) throws NotFoundException {
        produtoServicePort.deletar(sku);
    }

    @GetMapping(value = "/categoria/{categoria}")
    List<ProdutoDTO> buscarPorCategoria(@PathVariable String categoria) throws NotFoundException {
        return produtoServicePort.buscarPorCategoria(CategoriaEnum.fromNome(categoria));
    }
}
