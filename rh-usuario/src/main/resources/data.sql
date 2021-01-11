INSERT INTO tb_usuario (nome, email, senha) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_usuario (nome, email, senha) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_papel (nome_papel) VALUES ('ROLE_OPERADOR');
INSERT INTO tb_papel (nome_papel) VALUES ('ROLE_ADMIN');

INSERT INTO tb_USUARIO_PAPEL   (USUARIO_ID , PAPEL_ID ) VALUES (1, 1);
INSERT INTO tb_USUARIO_PAPEL   (USUARIO_ID , PAPEL_ID ) VALUES (2, 1);
INSERT INTO tb_USUARIO_PAPEL   (USUARIO_ID , PAPEL_ID ) VALUES (2, 2);