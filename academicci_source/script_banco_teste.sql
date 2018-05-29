-- create database academicciBD

-- Visualizar as tabelas do Banco.
SELECT * FROM pg_catalog.pg_tables 
WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';


CREATE TABLE cadastro
(
    id Primary Key NOT NULL serial,
    nome varchar(100) NOT NULL,
    telefone varchar(100) NOT NULL  
)

