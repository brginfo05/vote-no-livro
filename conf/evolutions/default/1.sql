# --- !Ups


CREATE TABLE livro (
    isbn integer NOT NULL,
    capa character varying(255),
    nome character varying(255)
);

CREATE TABLE usuario (
    id bigint NOT NULL AUTO_INCREMENT,
    email character varying(254),
    name character varying(255)
);

CREATE TABLE voto (
    id bigint NOT NULL AUTO_INCREMENT,
    votado boolean NOT NULL,
    par_isbn integer,
    usuario_id bigint,
    visualizado_isbn integer
);

ALTER TABLE livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (isbn);


ALTER TABLE usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


ALTER TABLE voto
    ADD CONSTRAINT voto_pkey PRIMARY KEY (id);


ALTER TABLE voto
    ADD CONSTRAINT fk_csk51tsl0axr0xdrp5ral8y7c FOREIGN KEY (visualizado_isbn) REFERENCES livro(isbn);

ALTER TABLE voto
    ADD CONSTRAINT fk_oidsbghjhfvy88jc914u5aoxh FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE voto
    ADD CONSTRAINT fk_v3qv9v8sdsbk26bto96gs95y FOREIGN KEY (par_isbn) REFERENCES livro(isbn);