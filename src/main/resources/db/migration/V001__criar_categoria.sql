CREATE TABLE categoria (
  id              	SERIAL PRIMARY KEY,
  nome           	VARCHAR(60) NOT NULL,
  descricao  		VARCHAR(300) NULL
);


INSERT INTO categoria(nome, descricao) VALUES ('categoria teste', 'descricao teste');