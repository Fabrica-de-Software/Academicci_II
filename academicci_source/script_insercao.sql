-- -----------------------------------------------------
-- -----------------------------------------------------
-- Insercao no Banco
-- -----------------------------------------------------
-- ----------------------------------------------------- 

-- -----------------------------------------------------
-- Tabela 'contato'
-- -----------------------------------------------------

INSERT INTO contato (ddd, telefone) VALUES (62, 992569475);
INSERT INTO contato (ddd, telefone) VALUES (62, 975327575);
INSERT INTO contato (ddd, telefone) VALUES (62, 993752527);
INSERT INTO contato (ddd, telefone) VALUES (62, 997527527);
INSERT INTO contato (ddd, telefone) VALUES (62, 991056652);
INSERT INTO contato (ddd, telefone) VALUES (62, 995620386);
INSERT INTO contato (ddd, telefone) VALUES (62, 999652835);
INSERT INTO contato (ddd, telefone) VALUES (62, 997867896);
INSERT INTO contato (ddd, telefone) VALUES (62, 996877874);
INSERT INTO contato (ddd, telefone) VALUES (62, 996748413);

-- -----------------------------------------------------
-- Tabela 'pessoa'
-- -----------------------------------------------------

INSERT INTO pessoa 	(mat_pessoa, nome, sexo, dtNasc, email, cpf, rg, id_contato_FK) VALUES 
					(01415690, 'Almerinda Aquino', 	'f', '1971-07-13',	'almerinda@mail.com', 	'61148246010', '297726918', 1),
					(01314569, 'Aniano Ferraz', 	'm', '1982-09-10',	'aninao@mail.com',		'54027440099', '418757896', 10),
					(01527845, 'Armando Torrado', 	'm', '2000-03-23',	'armando@mail.com',		'79775298075', '911225341', 5),
					(01645632, 'Clara Peña', 		'f', '1983-03-04',	'clara@mail.com',		'05460564077', '121182769', 8),
					(01736947, 'Débora Barbosa', 	'f', '1987-12-15',	'debora@mail.com',		'15103900068', '482575657', 7),
					(01493214, 'Félix Vilariça', 	'm', '1992-03-14',	'felix@mail.com',		'50284281310', '429434121', 3),
					(01684152, 'Girão Matos', 		'm', '1996-01-26',	'girao@mail.com',		'45407629666', '462001271', 9),
					(01794517, 'Gualdim Jaguariúna','m', '2000-01-01',	'gualdim@mail.com',		'52356517820', '428091027', 2),
					(01443223, 'Helena Naves', 		'f', '1999-10-17',	'helena@mail.com',		'31707236852', '141117163', 4),
					(01419685, 'Solano Torquato', 	'm', '1999-10-06',	'solano@mail.com',		'81359032355', '249074564', 6);

-- -----------------------------------------------------
-- Tabela perfil
-- -----------------------------------------------------
INSERT INTO perfil (tipo) VALUES ('aluno');
INSERT INTO perfil (tipo) VALUES ('monitor');
INSERT INTO perfil (tipo) VALUES ('docente');
INSERT INTO perfil (tipo) VALUES ('coordenacao');

-- -----------------------------------------------------
-- Tabela disciplina
-- ----------------------------------------------------- 
INSERT INTO disciplina 	(nome, grade_curric) VALUES 
						('Algoritmos e Programação II',					'2017/01'),
						('Sistemas Gerenciadores de Banco de Dados',	'2018/01'),
						('Sistemas Operacionais',						'2016/02'),
						('Compiladores',								'2016/02');
						
-- -----------------------------------------------------
-- Tabela aviso
-- -----------------------------------------------------
INSERT INTO aviso 	(assunto, descricao, dtAviso, mat_pessoa_FK, id_disciplina_FK) VALUES 
					('Aviso01', 'Não haverá aula hoje.',					'2018-05-14', 01415690, 1),
					('Aviso02', 'Levar notebooks para a aula de hoje.',		'2017-12-21', 01415690, 3),
					('Aviso03', 'A aula será no laboratorio 07',			'2018-01-28', 01415690, 2),
					('Aviso04', 'As notas já estão disponíveis no Lyceum',	'2018-03-10', 01493214, 1),
					('Aviso05', 'Monitor Wanderson atenderá na h107',		'2018-09-06', 01493214, 4);

-- -----------------------------------------------------
-- Tabela publicacao
-- -----------------------------------------------------
INSERT INTO publicacao 	(nome, descricao, dtPublicacao, id_disciplina_FK) VALUES 
						('plano_ensino.pdf', 			'Plano de Ensino da Disciplina.', 			'2017-10-25', 1),
						('slides_aula01_SO.pdf',		'Slides da 1ª Aula',						'2018-01-26', 3),
						('lista de exercícios.pdf',		'Lista com data de entrega para a 2VA.',	'2017-03-21', 2),
						('codigo_exemplo_arquivo.pdf',	'Manipulação de arquivos: Exemplo.',		'2017-03-22', 4),
						('aula10.pdf',					'Diagrama da aula 10',						'2017-03-11', 1);

-- -----------------------------------------------------
-- Tabela perfil_pessoa
-- -----------------------------------------------------
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (2, 01415690);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (2, 01493214);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (1, 01314569);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (1, 01527845);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (3, 01645632);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (3, 01736947);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (4, 01684152);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (1, 01794517);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (2, 01443223);
INSERT INTO perfil_pessoa (id_perfil_FK, mat_pessoa_FK) VALUES (2, 01419685);

-- -----------------------------------------------------
-- Tabela topico
-- -----------------------------------------------------
INSERT INTO topico 	(descricao, mat_pessoa_FK, id_disciplina_FK) VALUES 
					('Não consigo abrir um arquivo em C',	01314569, 4),
					('Dúvida Exercício 04 da lista 01', 	01314569, 4),
					('Alter Table não funciona', 			01527845, 2);
					
-- -----------------------------------------------------
-- Tabela periodo_letivo
-- -----------------------------------------------------
INSERT INTO periodo_letivo (semestre, ano) VALUES (2, 2017);
INSERT INTO periodo_letivo (semestre, ano) VALUES (1, 2018);

-- -----------------------------------------------------
-- Tabela disciplina_periodolet
-- -----------------------------------------------------
INSERT INTO disciplina_periodolet (id_disciplina_FK, id_periodolet_FK) VALUES (1, 1);
INSERT INTO disciplina_periodolet (id_disciplina_FK, id_periodolet_FK) VALUES (2, 2);
INSERT INTO disciplina_periodolet (id_disciplina_FK, id_periodolet_FK) VALUES (3, 2);
INSERT INTO disciplina_periodolet (id_disciplina_FK, id_periodolet_FK) VALUES (4, 2);

-- -----------------------------------------------------
-- Tabela resposta
-- -----------------------------------------------------
INSERT INTO resposta (descricao, id_topico_FK) VALUES ('Olá, 01314569! Favor, verificar o exemplo postado', 1);

-- -----------------------------------------------------
-- Tabela anexo
-- -----------------------------------------------------
INSERT INTO anexo (nome, id_topico_FK, id_resposta_FK) VALUES ('exemplo_erro.png', 1, 1);

-- -----------------------------------------------------
-- Tabela pessoa_periodolet
-- -----------------------------------------------------
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (1, 01415690);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01314569);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01527845);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01645632);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01736947);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01493214);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01684152);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01794517);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01443223);
INSERT INTO pessoa_periodolet (id_periodolet_FK, mat_pessoa_FK) VALUES (2, 01419685);























