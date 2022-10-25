package com.ifpeprojeto.entidades;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String salario;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String salario) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.salario = salario;
    }

    public int getidFuncionario() {
        return idFuncionario;
    }

    public void setidFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}
