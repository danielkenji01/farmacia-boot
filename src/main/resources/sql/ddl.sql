create table categoria (
	id int primary key auto_increment,
    nome varchar(50) not null
);

create table fornecedor (
	id int primary key auto_increment,
    nome varchar(50) not null,
    endereco varchar(50) not null
);

create table produto (
	id int primary key auto_increment,
    nome varchar(50) not null,
    categoria_id int,
    fornecedor_id int,
    preco numeric(5,2) not null,

    constraint produto_categoria_id_fk foreign key (categoria_id) references categoria (id),
    constraint produto_fornecedor_id_fk foreign key (fornecedor_id) references fornecedor (id)
);

create table venda (
	id int primary key auto_increment,
    data_venda timestamp not null,
    valor_total numeric(5,2) not null,
    tipo_pagamento varchar(20) not null
);

create table item_venda (
	id int primary key auto_increment,
    produto_id int not null,
    venda_id int not null,
    valor_unitario numeric(5,2) not null,
    quantidade int not null,
    valor_total numeric(5,2) not null,

    constraint item_venda_venda_id_fk foreign key (venda_id) references venda (id),
    constraint item_venda_produto_id_fk foreign key (produto_id) references produto (id)
);