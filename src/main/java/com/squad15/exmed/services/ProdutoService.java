package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.ProdutoRepository;
import com.squad15.exmed.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

}
