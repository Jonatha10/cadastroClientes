CREATE DATABASE estudos;
CREATE TABLE Clientes(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );
  SELECT * FROM Clientes; 
  
  
insert into `Clientes` (`cpf`, `email`, `id`, `nome`, `telefone`) values ('12345689', 'jao123@gmail.com', 1, 'joao', '(11) 1111-4444');
insert into `Clientes` (`cpf`, `email`, `id`, `nome`, `telefone`) values ('12345689', 'jurema@gmail.com', 2, 'jurema', '(11) 1111-4444');
insert into `Clientes` (`cpf`, `email`, `id`, `nome`, `telefone`) values ('123456789', 'mario@gmail.com', 3, 'mario', '123456789');
