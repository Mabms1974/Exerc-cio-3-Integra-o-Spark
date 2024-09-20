package models;

public class Produto {
    public String nome;
    public String descricao;
    public float preco;
    public int quantidade;

    public Produto(String nome, String descricao, float preco, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}