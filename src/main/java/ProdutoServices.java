package services;

import dao.ProdutoDAO;
import models.Produto;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO;

    public ProdutoService(Jdbi jdbi) {
        this.produtoDAO = jdbi.onDemand(ProdutoDAO.class);
    }

    public void adicionarProduto(Produto produto) {
        produtoDAO.inserirProduto(produto.nome, produto.descricao, produto.preco, produto.quantidade);
    }

    public Produto obterProduto(int id) {
        return produtoDAO.buscarProduto(id);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    public void atualizarProduto(int id, Produto produto) {
        produtoDAO.atualizarProduto(id, produto.nome, produto.descricao, produto.preco, produto.quantidade);
    }

    public void removerProduto(int id) {
        produtoDAO.deletarProduto(id);
    }
}