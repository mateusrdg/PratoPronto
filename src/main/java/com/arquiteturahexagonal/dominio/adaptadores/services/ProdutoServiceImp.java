package com.arquiteturahexagonal.dominio.adaptadores.services;

import com.arquiteturahexagonal.aplicacao.adaptatores.controllers.exception.BadRequestException;
import com.arquiteturahexagonal.dominio.Produto;
import com.arquiteturahexagonal.dominio.dtos.ProdutoDTO;
import com.arquiteturahexagonal.dominio.enums.CategoriaEnum;
import com.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProdutoServiceImp implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoServiceImp(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criar(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        validaInsercao(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    private void validaInsercao(ProdutoDTO produtoDTO) {
        Optional<Produto> produtoConsultado = this.produtoRepository.buscarPeloSku(produtoDTO.getSku());
        if (produtoConsultado.isPresent())
            throw new BadRequestException("Sku ja cadastrado");
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDTO> buscarProdutosPorSkus(List<String> skus) {
        return this.produtoRepository.buscarProdutosPorSku(skus).stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void atualizar(String sku, ProdutoDTO produtoDTO) throws NotFoundException {
        Optional<Produto> produtoOptional = this.produtoRepository.buscarPeloSku(sku);

        if (produtoOptional.isEmpty())
            throw new NotFoundException("Produto não encontrado");

        Produto produto = produtoOptional.get();
        produto.atualizar(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public void deletar(String sku) throws NotFoundException {
        Optional<Produto> produtoOptional = this.produtoRepository.buscarPeloSku(sku);

        if (produtoOptional.isEmpty())
            throw new NotFoundException("Produto não encontrado");

        this.produtoRepository.deletar(sku);
    }
    @Override
    public List<ProdutoDTO> buscarPorCategoria(CategoriaEnum categoria){
        List<Produto> produtos = this.produtoRepository.buscarPorCategoria(categoria);
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }
}
