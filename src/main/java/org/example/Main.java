package application;

import org.jdbi.v3.core.Jdbi;
import services.ProdutoService;
import spark.Spark;

public class Main {

    public static void main(String[] args) {
        // Conectar ao PostgreSQL
        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/cadastroproduto", "root", "root");

        ProdutoService produtoService = new ProdutoService(jdbi);
        ProdutoApplication produtoApplication = new ProdutoApplication(produtoService);

        // Inicializar rotas
        produtoApplication.initializeRoutes();

        // Configurar Spark (porta, etc)
        Spark.port(4567);
    }
}