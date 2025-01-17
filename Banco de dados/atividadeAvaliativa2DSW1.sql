CREATE DATABASE atividadeAvaliativa2;

USE atividadeAvaliativa2;

CREATE TABLE usuario(
	login VARCHAR(50) PRIMARY KEY NOT NULL,
    senha VARCHAR(45) NOT NULL
);

CREATE TABLE pedidos(
	idpedidos INT PRIMARY KEY NOT NULL,
    nomeCliente VARCHAR(145) NOT NULL,
    enderecoEntrega VARCHAR(200) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(300) NOT NULL
);

INSERT INTO usuario (login, senha) VALUES ('admin', '123');

SELECT * FROM pedidos;

SELECT * FROM usuario;
