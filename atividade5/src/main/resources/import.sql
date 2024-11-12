INSERT INTO PRODUTO (DESCRICAO,PRECO) VALUES ('Arroz', 35.50);
INSERT INTO PRODUTO (DESCRICAO,PRECO) VALUES ('Feijão', 7.90);
INSERT INTO PRODUTO (DESCRICAO,PRECO) VALUES ('Leite', 5.65);
INSERT INTO PRODUTO (DESCRICAO,PRECO) VALUES ('Picanha', 135.50);

INSERT INTO VENDA (DATA,PESSOA_ID) VALUES ('2020-01-01',1);
INSERT INTO VENDA (DATA,PESSOA_ID) VALUES ('2021-02-11',2);
INSERT INTO VENDA (DATA,PESSOA_ID) VALUES ('2022-03-21',3);
INSERT INTO VENDA (DATA,PESSOA_ID) VALUES ('2023-04-30',1);
INSERT INTO VENDA (DATA,PESSOA_ID) VALUES ('2024-05-15',3);



INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (1, 1, 10);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (2, 2, 5);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (3, 2, 2);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (4, 1, 4);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (1, 3, 3);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (2, 3, 2);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (1, 4, 1);
INSERT INTO ITEM_VENDA (PRODUTO_ID, VENDA_ID, QUANTIDADE) VALUES (4, 5, 32);




INSERT INTO PESSOA_FISICA (Id,CPF, EMAIL, NOME, TELEFONE) VALUES ( 1,'065.445.433-22', 'Gu.@gmail.com', 'Gustavo', '(63)9995-4454');
INSERT INTO PESSOA_FISICA (Id,CPF, EMAIL, NOME, TELEFONE) VALUES ( 2,'165.435.412-02', 'Alex.@gmail.com', 'Alex', '(64)9945-8854');


--insert into PESSOA_FISICA (CPF,EMAIL,NOME,TELEFONE) values ('12345678901','GGG','Gustavo','123456789');

INSERT INTO PESSOA_JURIDICA (Id,CNPJ, EMAIL, Razao_social, TELEFONE) VALUES ( 3,'04.568.566/0002-92', 'Gui.@gmail.com', 'GERDAL', '(62)3571-3321');
INSERT INTO PESSOA_JURIDICA (Id,CNPJ, EMAIL, Razao_social, TELEFONE) VALUES ( 4,'12.334.443/0001-99', 'mmauatacado@hotmail.com', 'Meu Atacado', '(45)5545-5432');