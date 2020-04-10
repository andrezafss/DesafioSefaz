-- Scripts para criacao do projeto --

CREATE TABLE usuario (
   email VARCHAR(11) NOT NULL,
   nome VARCHAR(100) NOT NULL,
   senha VARCHAR(10) NOT NULL,
   PRIMARY KEY (email) 
);

CREATE TABLE telefone (
	id INTEGER IDENTITY PRIMARY KEY,
   numero VARCHAR(100) NOT NULL,
   ddd int NOT NULL,
   tipo VARCHAR(100) NOT NULL,
   email_usuario VARCHAR(11) NOT NULL   
   );

ALTER TABLE telefone
ADD FOREIGN KEY (email_usuario) 
REFERENCES usuario(email);