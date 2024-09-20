package dao;

import models.Produto;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ProdutoDAO {

    @SqlUpdate("INSERT INTO produto (nome, descricao, preco, quantidade) VALUES (:nome, :descricao, :preco, :quantidade)")
    void inserirProduto(@Bind("nome") String nome, @Bind("descricao") String descricao, @Bind("preco") float preco, @Bind("quantidade") int quantidade);

    @SqlQuery("SELECT * FROM produto WHERE id = :id")
    Produto buscarProduto(@Bind("id") int id);

    @SqlQuery("SELECT * FROM produto")
    List<Produto> listarProdutos();

    @SqlUpdate("UPDATE produto SET nome = :nome, descricao = :descricao, preco = :preco, quantidade = :quantidade WHERE id = :id")
    void atualizarProduto(@Bind("id") int id, @Bind("nome") String nome, @Bind("descricao") String descricao, @Bind("preco") float preco, @Bind("quantidade") int quantidade);

    @SqlUpdate("DELETE FROM produto WHERE id = :id")
    void deletarProduto(@Bind("id") int id);
}