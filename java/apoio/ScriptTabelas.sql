CREATE DATABASE iCad;

CREATE TABLE permissao (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(20) NOT NULL  -- (admin, superadmin ou usuario)
);

CREATE TABLE cidade (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(60) NOT NULL
);

CREATE TABLE estado (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(30) NOT NULL
);

CREATE TABLE pais (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(60) NOT NULL
);

CREATE TABLE tipo_requisito (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(13) NOT NULL
);

CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY,
	usuario VARCHAR(50) NOT NULL,
	senha VARCHAR(2000) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	cpf VARCHAR(15) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(150) NOT NULL,
	situacao Varchar(20) NOT NULL,
	permissao VARCHAR(20) NOT NULL,
	cidade VARCHAR(60) NOT NULL,
	estado VARCHAR(30) NOT NULL,
	pais VARCHAR(60) NOT NULL
);

CREATE TABLE requisito (
	id SERIAL PRIMARY KEY,
	titulo VARCHAR(50) NOT NULL,
	descricao TEXT NOT NULL,
	codigo INT NOT NULL,
	complexidade INT NOT NULL,
	prioridade VARCHAR(10) NOT NULL,
	fk_tipo_requisito INT NOT NULL,
	CONSTRAINT fk_tipo_requisito FOREIGN KEY (id) REFERENCES tipo_requisito (id)
);

CREATE TABLE projeto (
	id SERIAL PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL
);

CREATE TABLE pessoa_projeto (
	fk_pessoa INT REFERENCES pessoa (id),
	fk_projeto INT REFERENCES projeto (id),
	CONSTRAINT pessoa_projeto_pkey PRIMARY KEY (fk_pessoa, fk_projeto)
);

CREATE TABLE projeto_requisito (
	fk_requisito INT REFERENCES requisito (id),
	fk_projeto INT REFERENCES projeto (id),
	CONSTRAINT projeto_requisito_pkey PRIMARY KEY (fk_requisito, fk_projeto)
);