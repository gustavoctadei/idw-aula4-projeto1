create table contato (
	id_contato int not null auto_increment,
	nome varchar(50) null,
	telefone varchar(50) null,
	email varchar(50),
	data_cadastro date null,
	observacao text,
	primary key (id_contato)
);
