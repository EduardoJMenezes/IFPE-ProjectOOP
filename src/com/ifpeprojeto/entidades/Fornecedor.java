package com.ifpeprojeto.entidades;

public class Fornecedor {

    private int idFornecedor;
    private String nome;
    private String cnpj;
    private String desc_fornecedor;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String nome, String cnpj, String desc_fornecedor) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.desc_fornecedor = desc_fornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDesc_fornecedor() {
        return desc_fornecedor;
    }

    public void setDesc_fornecedor(String desc_fornecedor) {
        this.desc_fornecedor = desc_fornecedor;
    }

}
