drop database if exists travelguide;
create database travelguide;
use travelguide;

CREATE TABLE Usuario (
idUsuario int PRIMARY KEY auto_increment,
nome varchar(50),
dataNascimento date,
cpf varchar(15),
email varchar(50),
cidade varchar(50),
senha varchar(12)
);

insert into Usuario (nome,dataNascimento,cpf,email,cidade,senha) values
('Arthur Jorge','1996-05-08','105.356.456-45','arthursenai@gmail.com','Florianópolis','080596');
 
 select * from ONIBUS;
desc onibus;
select * from horario  where idOnibus =1;