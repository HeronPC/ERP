CREATE DATABASE IF NOT EXISTS erp;

USE erp;

CREATE TABLE usuarios (
Usuario VARCHAR(50) PRIMARY KEY,
Passwd VARCHAR(50),
email VARCHAR(50) UNIQUE ,
tel CHAR(9),
img VARCHAR(50)
);

CREATE TABLE bds(
Nombre VARCHAR(50),
Usuario VARCHAR(50),
FOREIGN KEY (Usuario) REFERENCES usuarios (Usuario)
);

Create table usuarioactual(
usuario varchar(50)
);


INSERT INTO usuarios VALUES ("root", "root", "", "", "");
