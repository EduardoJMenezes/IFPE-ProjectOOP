create database projeto; 

use projeto;

drop database projeto;

create table funcionario(
    idFuncionario int primary key not null auto_increment,
    nome varchar(70) not null,
    salario varchar(60) not null
);

create table produto(
    idProduto int primary key not null auto_increment,
    nome varchar(50) not null,
    preco varchar(50) not null
);

create table fornecedor(
	idFornecedor int primary key not null auto_increment,
    nome varchar(50) not null,
    cnpj varchar(18) not null,
    desc_fornecedor varchar(90) not null
);

select * from cliente;
select * from produto;
select * from fornecedor;