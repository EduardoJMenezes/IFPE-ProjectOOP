package com.ifpeprojeto.entidades;

public class Produto {
    private String nome;
    private String preco;
    private int idProduto;
    
    public Produto(String nome, String preco, int idProduto){
        this.nome = nome;
        this.preco = preco;
        this.idProduto = idProduto;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
