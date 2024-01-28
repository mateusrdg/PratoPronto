package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.dtos.ProdutoDTO;
import com.arquiteturahexagonal.dominio.enums.CategoriaEnum;
import javassist.NotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    List<ProdutoDTO> buscarProdutosPorSkus(List<String> skus);

    void criar(ProdutoDTO produtoDTO);

    void atualizar(String sku, ProdutoDTO produtoDTO) throws NotFoundException;

    void deletar(String sku) throws NotFoundException;

    List<ProdutoDTO> buscarPorCategoria(CategoriaEnum categoria) throws NotFoundException;
}
