# --- !Ups

create table livro (
  isbn                      integer not null,
  nome                      varchar(255),
  constraint pk_livro primary key (isbn))
;

create table usuario (
  id                        bigint not null,
  email                     varchar(254),
  name                      varchar(255),
  constraint pk_usuario primary key (id))
;

create table voto (
  escolhido_isbn            integer,
  nao_escolhido_isbn        integer,
  usuario_id                bigint)
;

create sequence livro_seq;

create sequence usuario_seq;

alter table voto add constraint fk_voto_escolhido_1 foreign key (escolhido_isbn) references livro (isbn);
create index ix_voto_escolhido_1 on voto (escolhido_isbn);
alter table voto add constraint fk_voto_naoEscolhido_2 foreign key (nao_escolhido_isbn) references livro (isbn);
create index ix_voto_naoEscolhido_2 on voto (nao_escolhido_isbn);
alter table voto add constraint fk_voto_usuario_3 foreign key (usuario_id) references usuario (id);
create index ix_voto_usuario_3 on voto (usuario_id);



# --- !Downs

drop table if exists livro cascade;

drop table if exists usuario cascade;

drop table if exists voto cascade;

drop sequence if exists livro_seq;

drop sequence if exists usuario_seq;

