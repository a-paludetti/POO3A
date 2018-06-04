CREATE DATABASE poo3;

CREATE TABLE poo3.Pessoa (
    idPessoa BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
    Nome VARCHAR(255) NOT NULL,
    Documento VARCHAR(14),
    Descricao VARCHAR(255),
    Telefone VARCHAR(10),
    Email VARCHAR(50),
    Tipo VARCHAR(1) NOT NULL,
    Disabled BIT(1) NOT NULL,
    CONSTRAINT Pessoa PRIMARY KEY (idPessoa)
);

CREATE TABLE poo3.ContaPg (
    idConta BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
    Nome VARCHAR(255) NOT NULL,
    Valor FLOAT NOT NULL,
    NotaFiscal VARCHAR(50),
    Descricao VARCHAR(255),
    DataCadastro DATE NOT NULL,
    DataPagamento DATE NOT NULL,
    Responsavel VARCHAR(255) NOT NULL,
    PRIMARY KEY (idConta),
    FOREIGN KEY  (Responsavel) REFERENCES poo3.Pessoa(Nome)
);

CREATE TABLE poo3.ContaRcb (
    idConta BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
    Nome VARCHAR(255) NOT NULL,
    Valor FLOAT NOT NULL,
    NotaFiscal VARCHAR(50),
    Descricao VARCHAR(255),
    DataCadastro DATE NOT NULL,
    DataPagamento DATE NOT NULL,
    PRIMARY KEY (idConta),
    FOREIGN KEY  (Nome) REFERENCES poo3.Pessoa(Nome)
);

USE poo3;