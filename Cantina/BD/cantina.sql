-- Criando o banco de dados;
DROP DATABASE IF EXISTS cantina;
CREATE DATABASE IF NOT EXISTS cantina;

-- Selecionando o banco de dados;
USE cantina;

-- Criando a tabela login;
CREATE TABLE login(
id int(6) NOT NULL,
usuario varchar(50) NOT NULL,
senha varchar(8) NOT NULL,
-- nivel varchar(15) NOT NULL,
PRIMARY KEY (id));

-- Inserindo os dados na tabela login;
INSERT INTO login (id, usuario, senha) VALUES
	(1,"ADMIN","admin123");

-- Criando a tabela pessoa;
CREATE TABLE pessoa(
p_cod int(6) not null,
p_tipo varchar(15) not null,
p_nome varchar(50) not null,
p_rg varchar(15) null,
p_cpf varchar(15) not null,
p_endereco varchar(50) not null,
p_bairro varchar(30) not null,
p_cidade varchar(30) not null,
p_fone varchar(15) not null,
p_email varchar(30) null,
PRIMARY KEY (p_cod));

-- Inserindo os dados na tabela pessoa;
INSERT INTO pessoa (p_cod, p_tipo, p_nome, p_rg, p_cpf, p_endereco, p_bairro, p_cidade, p_fone, p_email) VALUES 
	(1,"Funcionario","CARLOS",NULL,"111.111.111.11","RUA 1","UM","A","(11)11111111",NULL),
	(2,"Cliente","MARIA",NULL,"222.222.222.22","RUA 2","DOIS","B","(22)22222222",NULL),
	(3,"Funcionario","ANTONIO",NULL,"333.333.333.33","RUA 3","TRES","C","(33)33333333",NULL),
	(4,"Cliente","PAULA",NULL,"444.444.444.44","RUA 4","QUATRO","D","(44)44444444",NULL);

-- Criando a tabela produto;
CREATE TABLE produto(
prod_cod int(6) not null,
prod_desc varchar(50) not null,
prod_tipo varchar(25)not null,
-- item_cod int(6) not null,
-- cat_cod int(6) not null,
PRIMARY KEY (prod_cod));
-- FOREIGN KEY fk_item(item_cod) REFERENCES item(item_cod) ON DELETE CASCADE,
-- FOREIGN KEY fk_categoria(cat_cod) REFERENCES categoria(codigo) ON DELETE CASCADE);						

-- Inserindo os dados na tabela produto;
INSERT INTO produto (prod_cod, prod_desc, prod_tipo) VALUES 
	(1,"EMPADA","SALGADOS"),
	(2,"ESFIHA","SALGADOS"),
	(3,"COCA COLA","REFRIGERANTES");

-- Criando a tabela categoria;
CREATE TABLE categoria(
codigo int(6) not null,
tipo varchar(25) not null,
PRIMARY KEY (codigo));

-- Inserindo os dados na tabela categoria;
INSERT INTO categoria (codigo, tipo) VALUES 
	(1,"SALGADOS"),
	(2,"DOCES"),
	(3,"REFRIGERANTES"),
	(4,"SUCOS"),
	(5,"REFEICOES");

-- Criando a tabela pedido;
CREATE TABLE pedido(
ped_item int(2) not null AUTO_INCREMENT,
ped_produto varchar(50) not null,
ped_qtde int(4) not null,
ped_vtotal float not null,
ped_pgto varchar(8) not null,
ped_cliente varchar(50) null,
ped_data date not null,
ped_situacao varchar(10) not null,
ped_func varchar(50) null,
PRIMARY KEY(ped_item));	
	
-- Criando a tabela de Pessoas Excluídas;
-- DROP TABLE IF EXISTS mortopes;
CREATE TABLE IF NOT EXISTS mortopes(
p_cod int(6) not null PRIMARY KEY,
p_tipo varchar(15) not null,
p_nome varchar(50) not null,
p_rg varchar(15) null,
p_cpf varchar(15) null,
p_endereco varchar(50) null,
p_bairro varchar(30) null,
p_cidade varchar(30) null,
p_fone varchar(15) null,
p_email varchar(30) null);

-- Criando a tabela de Produtos Excluídos;
-- DROP TABLE IF EXISTS mortoprod;
CREATE TABLE IF NOT EXISTS mortoprod(
prod_cod int(6) not null,
prod_desc varchar(50) not null,
prod_tipo varchar(25)not null);


-- TRIGGER(gatilho) Pessoas;
-- DROP TRIGGER IF EXISTS pes;
DELIMITER //
CREATE TRIGGER pes BEFORE DELETE ON pessoa
FOR EACH ROW 
BEGIN
    INSERT INTO mortopes VALUES (OLD.p_cod, OLD.p_tipo, OLD.p_nome, OLD.p_rg, OLD.p_cpf, OLD.p_endereco, OLD.p_bairro, OLD.p_cidade, OLD.p_fone, OLD.p_email);     	     
END //
DELIMITER ;


-- TRIGGER(gatilho) Produtos;
-- DROP TRIGGER IF EXISTS prod;
DELIMITER //
CREATE TRIGGER prod BEFORE DELETE ON produto
FOR EACH ROW 
BEGIN
    INSERT INTO mortoprod VALUES (OLD.prod_cod, OLD.prod_desc, OLD.prod_tipo);     	     
END //
DELIMITER ;


-- TRIGGER(gatilho) Verifica Pessoa antes de Inserir
-- DROP TRIGGER IF EXISTS incluirPessoa;
DELIMITER //
CREATE TRIGGER incluirPessoa BEFORE INSERT ON pessoa
FOR EACH ROW
	BEGIN
		DECLARE estatus BOOLEAN DEFAULT FALSE;
		DECLARE p_nome VARCHAR(50);
		SET p_nome = NEW.p_nome;
		
		CALL exibirPessoaExcluida(p_nome, estatus);
		IF estatus THEN
			DELETE FROM mortopes WHERE p_nome = p_nome;
		END IF;
	END //
DELIMITER ;


-- TRIGGER(gatilho) Verifica Produto antes de Inserir
-- DROP TRIGGER IF EXISTS incluirProduto;
DELIMITER //
CREATE TRIGGER incluirProduto BEFORE INSERT ON produto
FOR EACH ROW
	BEGIN
		DECLARE estatus BOOLEAN DEFAULT FALSE;
		DECLARE prod_desc VARCHAR(50);
		SET prod_desc = NEW.prod_desc;
		
		CALL exibirProdutoExcluido(prod_desc, estatus);
		IF estatus THEN
			DELETE FROM mortoprod WHERE prod_desc = prod_desc;
		END IF;
	END //
DELIMITER ;


-- PROCEDURE Salva Pessoas Excluidas
-- DROP PROCEDURE IF EXISTS mortopes;
DELIMITER //
CREATE PROCEDURE mortopes(IN cp varchar(6))
BEGIN
DECLARE fim INT DEFAULT FALSE;
DECLARE codpes int(6);
DECLARE tipopes varchar(15);
DECLARE nomepes varchar(50);
DECLARE rgpes varchar(15);
DECLARE cpfpes varchar(15);
DECLARE enderecopes varchar(50);
DECLARE bairropes varchar(30);
DECLARE cidadepes varchar(30);
DECLARE fonepes varchar(15);
DECLARE emailpes varchar(30);
DECLARE pes CURSOR FOR SELECT * FROM
				cantina.pessoa AS lp WHERE p_nome=cp;
DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET fim = TRUE;
OPEN pes;
read_loop: LOOP
			FETCH pes INTO codpes, tipopes, nomepes, rgpes, cpfpes, enderecopes, bairropes, cidadepes, fonepes, emailpes; -- FETCH = lê a tabela
				IF fim THEN LEAVE read_loop;
				END IF;
				INSERT INTO cantina.mortopes VALUES (codpes, tipopes, nomepes, rgpes, cpfpes, enderecopes, bairropes, cidadepes, fonepes, emailpes);
			END LOOP;
CLOSE pes;
END //
DELIMITER ;


-- PROCEDURE Salva Produtos Excluidos
-- DROP PROCEDURE IF EXISTS mortoprod;
DELIMITER //
CREATE PROCEDURE mortoprod(IN cpr varchar(6))
BEGIN
DECLARE fim INT DEFAULT FALSE;
DECLARE codprod int(6);
DECLARE descprod varchar(50);
DECLARE tipoprod varchar(25);
DECLARE prod CURSOR FOR SELECT * FROM
				cantina.produto AS lpr WHERE prod_desc=cpr;
DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET fim = TRUE;
OPEN prod;
read_loop: LOOP
			FETCH prod INTO codprod, descprod, tipoprod; -- FETCH = lê a tabela
				IF fim THEN LEAVE read_loop;
				END IF;
				INSERT INTO cantina.mortoprod VALUES (codprod, descprod, tipoprod);
			END LOOP;
CLOSE prod;
END //
DELIMITER ;


-- PROCEDURE Recuperar Pessoas Excluidas
-- DROP PROCEDURE IF EXISTS recmortopes;
DELIMITER //
CREATE PROCEDURE recmortopes(IN rp varchar(6))
BEGIN  
DECLARE fim INT DEFAULT FALSE;  
DECLARE rcodpes int(6);
DECLARE rtipopes varchar(15);
DECLARE rnomepes varchar(50);
DECLARE rrgpes varchar(15);
DECLARE rcpfpes varchar(15);
DECLARE renderecopes varchar(50);
DECLARE rbairropes varchar(30);
DECLARE rcidadepes varchar(30);
DECLARE rfonepes varchar(15);
DECLARE remailpes varchar(30);
DECLARE rpes CURSOR FOR SELECT * FROM 
		mortopes AS mp WHERE p_nome=rp;  
DECLARE CONTINUE HANDLER FOR NOT FOUND 
                    SET fim = TRUE;  
OPEN rpes;
read_loop:  LOOP
				FETCH rpes INTO rcodpes, rtipopes, rnomepes, rrgpes, rcpfpes, renderecopes, rbairropes, rcidadepes, rfonepes, remailpes;	   
				IF fim THEN LEAVE read_loop;   
				END IF;	   
				INSERT INTO cantina.pessoa VALUES (rcodpes, rtipopes, rnomepes, rrgpes, rcpfpes, renderecopes, rbairropes, rcidadepes, rfonepes, remailpes); 
				DELETE FROM cantina.mortopes WHERE p_nome=rp;
			END LOOP; 
CLOSE rpes;
 END //
DELIMITER ;


-- PROCEDURE Recuperar Produtos Excluidos
-- DROP PROCEDURE IF EXISTS recmortoprod;
DELIMITER //
CREATE PROCEDURE recmortoprod(IN rpr varchar(6))
BEGIN  
DECLARE fim INT DEFAULT FALSE;  
DECLARE rprodcod int(6);
DECLARE rproddesc varchar(50);
DECLARE rprodtipo varchar(25);
DECLARE rprod CURSOR FOR SELECT * FROM 
		mortoprod AS mp WHERE prod_desc=rpr;  
DECLARE CONTINUE HANDLER FOR NOT FOUND 
                    SET fim = TRUE;  
OPEN rprod;
read_loop:  LOOP
				FETCH rprod INTO rprodcod, rproddesc, rprodtipo;	   
				IF fim THEN LEAVE read_loop;   
				END IF;	   
				INSERT INTO cantina.produto VALUES (rprodcod, rproddesc, rprodtipo); 
				DELETE FROM cantina.mortoprod WHERE prod_desc=rpr;
			END LOOP; 
CLOSE rprod;
 END //
DELIMITER ;


-- PROCEDURE Exclui mortopes e exibe na tabela pessoa
-- DROP PROCEDURE IF EXISTS exibirPessoaExcluida;
DELIMITER //
CREATE PROCEDURE exibirPessoaExcluida(IN p_nome VARCHAR(50), OUT estatus BOOLEAN)
	BEGIN
		DECLARE fim INT DEFAULT FALSE;
		DECLARE cp VARCHAR(50);
		DECLARE pessoam CURSOR FOR SELECT mp.p_nome FROM cantina.mortopes AS mp WHERE mp.p_nome = p_nome;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = TRUE;
		OPEN pessoam;
			FETCH pessoam INTO cp;
			IF fim = TRUE then
				SET estatus = FALSE;
			ELSE
				SET estatus = TRUE;
			END IF;
		CLOSE pessoam;
	END // 
DELIMITER ;


-- PROCEDURE Exclui mortoprod e exibe na tabela produto
-- DROP PROCEDURE IF EXISTS exibirProdutosExcluido;
DELIMITER //
CREATE PROCEDURE exibirProdutoExcluido(IN prod_desc VARCHAR(50), OUT estatus BOOLEAN)
	BEGIN
		DECLARE fim INT DEFAULT FALSE;
		DECLARE cpr VARCHAR(50);
		DECLARE prodm CURSOR FOR SELECT mpr.prod_desc FROM cantina.mortoprod AS mpr WHERE mpr.prod_desc = prod_desc;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = TRUE;
		OPEN prodm;
			FETCH prodm INTO cpr;
			IF fim = TRUE then
				SET estatus = FALSE;
			ELSE
				SET estatus = TRUE;
			END IF;
		CLOSE prodm;
	END // 
DELIMITER ;