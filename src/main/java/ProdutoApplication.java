package application;

import com.google.gson.Gson;
import models.Produto;
import services.ProdutoService;

import static spark.Spark.*;

public class ProdutoApplication {

    private final ProdutoService produtoService;
    private final Gson gson = new Gson();

    public ProdutoApplication(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void initializeRoutes() {

        // Criar Produto
        post("/produtos", (req, res) -> {
            Produto produto = gson.fromJson(req.body(), Produto.class);
            produtoService.adicionarProduto(produto);
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "Produto criado com sucesso"));
        });

        // Obter Produto por ID
        get("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Produto produto = produtoService.obterProduto(id);
            if (produto != null) {
                res.type("application/json");
                return gson.toJson(produto);
            } else {
                res.status(404);
                return gson.toJson(new StandardResponse(StatusResponse.ERROR, "Produto não encontrado"));
            }
        });

        // Listar todos os produtos
        get("/produtos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(produtoService.listarProdutos());
        });

        // Atualizar Produto
        put("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Produto produto = gson.fromJson(req.body(), Produto.class);
            produtoService.atualizarProduto(id, produto);
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "Produto atualizado com sucesso"));
        });

        // Deletar Produto
        delete("/produtos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            produtoService.removerProduto(id);
            res.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, "Produto deletado com sucesso"));
        });
    }
}