-- create database academicciBD

-- Visualizar as tabelas do Banco.
SELECT * FROM pg_catalog.pg_tables 
WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';

-- -----------------------------------------------------
-- -----------------------------------------------------
-- Criação da Estrutura do Banco
-- -----------------------------------------------------
-- -----------------------------------------------------

-- OLD NAO CRIAR ESTA TABELA, ELA NAO FUNCIONA!
CREATE TABLE cadastro
(
    id Primary Key NOT NULL serial,
    nome varchar(100) NOT NULL,
	matricula, 
	email, 
	telefone, 
	cpf
    telefone varchar(100) NOT NULL  
)

-- -----------------------------------------------------
-- Tabela 'contato'
-- -----------------------------------------------------
CREATE TABLE contato (
	id_contato 	SERIAL 		NOT NULL PRIMARY KEY,
	ddd 		CHAR(2) 	NOT NULL,
	telefone 	VARCHAR(9) 	NOT NULL
);

-- -----------------------------------------------------
-- Tabela 'pessoa'
-- -----------------------------------------------------
CREATE TABLE pessoa (
	mat_pessoa 		INT 			NOT NULL PRIMARY KEY,
	nome 			VARCHAR(100)	NOT NULL,
	sexo			CHAR(1) 		NOT NULL,
	dtNasc			DATE 			NOT NULL,
	email			VARCHAR(100) 	NOT NULL,
	cpf				VARCHAR(11) 	NOT NULL,
	rg				VARCHAR(25) 	NOT NULL,
	senha			VARCHAR(50) 		NULL,
	sal				VARCHAR(100) 		NULL,
	status			CHAR(1)				NULL,
	id_contato_FK 	INT 			NOT NULL,
    FOREIGN KEY (id_contato_FK) 	REFERENCES  contato (id_contato)
);

-- -----------------------------------------------------
-- Tabela perfil
-- -----------------------------------------------------
CREATE TABLE perfil (
	id_perfil	SERIAL 			NOT NULL PRIMARY KEY,
	tipo		VARCHAR(45) 	NOT NULL
);

-- -----------------------------------------------------
-- Tabela disciplina
-- -----------------------------------------------------
CREATE TABLE disciplina (
	id_disciplina	SERIAL 			NOT NULL PRIMARY KEY,
	nome			VARCHAR(100) 	NOT NULL,
	status			CHAR(1)		 	NOT NULL,
	forum			VARCHAR(100) 	NULL
);

-- -----------------------------------------------------
-- Tabela aviso
-- -----------------------------------------------------
CREATE TABLE aviso (
	id_aviso			SERIAL 			NOT NULL PRIMARY KEY,
	assunto				VARCHAR(100) 	NOT NULL,
	descricao			VARCHAR(500) 	NOT NULL,
	dtAviso				DATE 			NOT NULL,
	mat_pessoa_FK		INT 			NOT NULL,
	id_disciplina_FK	INT 			NOT NULL,
    FOREIGN KEY (mat_pessoa_FK)			REFERENCES pessoa (mat_pessoa),
    FOREIGN KEY (id_disciplina_FK) 		REFERENCES disciplina (id_disciplina)
);

-- -----------------------------------------------------
-- Tabela publicacao
-- -----------------------------------------------------
CREATE TABLE publicacao (
	id_publicacao		SERIAL 			NOT NULL PRIMARY KEY,
	nome				VARCHAR(50) 	NOT NULL,
	descricao			VARCHAR(200) 	NOT NULL,
	tamanho				VARCHAR(30) 		NULL,
	file_path			VARCHAR(500) 		NULL,
	dtPublicacao		DATE 			NOT NULL,
	id_disciplina_FK	INT 			NOT NULL,
    FOREIGN KEY (id_disciplina_FK)		REFERENCES disciplina (id_disciplina)
);

-- -----------------------------------------------------
-- Tabela perfil_pessoa
-- -----------------------------------------------------
CREATE TABLE perfil_pessoa (
	id_perfil_FK		INT 		NOT NULL,
	mat_pessoa_FK		INT 		NOT NULL,
    PRIMARY KEY (id_perfil_FK, mat_pessoa_FK),
	FOREIGN KEY (id_perfil_FK)		REFERENCES perfil (id_perfil),
    FOREIGN KEY (mat_pessoa_FK)	    REFERENCES pessoa (mat_pessoa)
);

-- -----------------------------------------------------
-- Tabela topico
-- -----------------------------------------------------
CREATE TABLE topico (
	id_topico			SERIAL 			NOT NULL PRIMARY KEY,
	titulo				VARCHAR(150)	NOT NULL,
	descricao			VARCHAR(300)	NOT NULL,
	mat_pessoa_FK 		INT 			NOT NULL,
	id_disciplina_FK 	INT 			NOT NULL,
    FOREIGN KEY (mat_pessoa_FK)	    	REFERENCES pessoa (mat_pessoa),
    FOREIGN KEY (id_disciplina_FK)    	REFERENCES disciplina (id_disciplina)
);

-- -----------------------------------------------------
-- Tabela periodo_letivo
-- -----------------------------------------------------
CREATE TABLE periodo_letivo (
	id_periodolet		SERIAL 			NOT NULL PRIMARY KEY,
	semestre			SMALLINT	 	NOT NULL,
	ano					SMALLINT	 	NOT NULL
);

-- -----------------------------------------------------
-- Tabela disciplina_periodolet
-- -----------------------------------------------------
CREATE TABLE disciplina_periodolet (
	id_disciplina_FK 	INT 			NOT NULL,
	id_periodolet_FK 	INT 			NOT NULL,
    PRIMARY KEY (id_disciplina_FK, id_periodolet_FK),
	FOREIGN KEY (id_disciplina_FK)		REFERENCES disciplina (id_disciplina),
    FOREIGN KEY (id_periodolet_FK)	    REFERENCES periodo_letivo (id_periodolet)
);

-- -----------------------------------------------------
-- Tabela resposta
-- -----------------------------------------------------
CREATE TABLE resposta (
	id_resposta 		SERIAL 			NOT NULL PRIMARY KEY,
	descricao			VARCHAR(500) 	NOT NULL,
	id_topico_FK		INT 			NOT NULL,
    FOREIGN KEY (id_topico_FK)		    REFERENCES topico (id_topico)
);

-- -----------------------------------------------------
-- Tabela anexo
-- -----------------------------------------------------
CREATE TABLE anexo (
	id_anexo			SERIAL 			NOT NULL PRIMARY KEY,
	nome				VARCHAR(50) 	NOT NULL,
	tamanho				VARCHAR(30) 		NULL,
	file_path			VARCHAR(500) 		NULL,
	id_topico_FK		INT 				NULL,
	id_resposta_FK		INT 				NULL,
    FOREIGN KEY (id_topico_FK)		    REFERENCES topico (id_topico),
    FOREIGN KEY (id_resposta_FK)	    REFERENCES resposta (id_resposta)
);

-- -----------------------------------------------------
-- Tabela pessoa_periodolet
-- -----------------------------------------------------
CREATE TABLE pessoa_periodolet (
	id_periodolet_FK	INT 		NOT NULL,
	mat_pessoa_FK		INT 		NOT NULL,
    PRIMARY KEY (id_periodolet_FK, mat_pessoa_FK),
	FOREIGN KEY (id_periodolet_FK)	REFERENCES periodo_letivo (id_periodolet),
    FOREIGN KEY (mat_pessoa_FK)	    REFERENCES pessoa (mat_pessoa)
);
