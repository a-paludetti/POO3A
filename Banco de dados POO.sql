CREATE DATABASE poo3;

CREATE TABLE Pessoa (
idPessoa	BIGINT			not null	auto_increment	unique,
Nome 		varchar(255) 	not null,
Documento 	varchar(14),
Descricao 	varchar(255),
Telefone 	varchar(10),
Email 		varchar(50),
Tipo 		varchar(1) 		not null,
Disabled		bit(1)			not null	DEFAULT (0),
CONSTRAINT Pessoa PRIMARY KEY (idPessoa),
)

CREATE TABLE Conta (
idConta 		BIGINT			not null	auto_increment	unique,
Nome 			varchar(255) 	not null
Valor 			float 			not null,
NotaFiscal		varchar(50),
Descricao		varchar(255),
DataCadastro	date,
PRIMARY KEY (idConta),
);
