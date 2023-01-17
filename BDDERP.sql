CREATE DATABASE if NOT EXISTS PruebaScript;

USE PruebaScript;

CREATE OR REPLACE TABLE proveedores(
CIF CHAR(9) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE,
Direccion VARCHAR(100),
Email VARCHAR(50),
Tel CHAR(9) UNIQUE
);

CREATE OR REPLACE TABLE recepciones(
Referencia VARCHAR(15) PRIMARY KEY,
Nombre VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
Tel CHAR(9),
Estado VARCHAR(100),
CONSTRAINT Nombre FOREIGN KEY (Nombre) REFERENCES proveedores (Nombre),
CONSTRAINT Tel FOREIGN KEY (Tel) REFERENCES proveedores (Tel)
);

CREATE OR REPLACE TABLE devoluciones(
Referencia VARCHAR(15) PRIMARY KEY,
Cliente VARCHAR(50),
Documento VARCHAR(100),
Estado VARCHAR(100)
);

CREATE OR REPLACE TABLE productosdev(
Referencia VARCHAR(15),
Producto VARCHAR(50),
Cantidad INT,
CONSTRAINT Referenciadev FOREIGN KEY (Referencia) 
REFERENCES devoluciones (Referencia)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE OR REPLACE TABLE clientes(
CIF CHAR(9) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE,
Direccion VARCHAR(100),
Email VARCHAR(50),
Tel CHAR(9) UNIQUE
);

CREATE OR REPLACE TABLE expediciones(
Referencia VARCHAR(15) PRIMARY KEY,
Direccion VARCHAR(50),
Nombre VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
Tel CHAR(9),
Estado VARCHAR(100),
CONSTRAINT Nombre1 FOREIGN KEY (Nombre) REFERENCES clientes (Nombre),
CONSTRAINT Tel1 FOREIGN KEY (Tel) REFERENCES clientes (Tel)
);

CREATE OR REPLACE TABLE productosexp(
Referencia VARCHAR(15),
Producto VARCHAR(50),
Cantidad INT,
CONSTRAINT Referenciaexp FOREIGN KEY (Referencia) 
REFERENCES expediciones (Referencia)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE OR REPLACE TABLE productosrec(
Referencia VARCHAR(15),
Producto VARCHAR(50),
Cantidad INT,
CONSTRAINT Referencia FOREIGN KEY (Referencia) 
REFERENCES Recepciones (Referencia)
ON UPDATE CASCADE
ON DELETE CASCADE
);

INSERT INTO proveedores VALUES ('CAD87542G', 'Iago S.L.', 'C/ Calatrava n8', 'iago@safareyes.es', '678542987');

INSERT INTO recepciones VALUES ('HSJF', 'Iago S.L.', '2020-03-04', 'agfg.pdf', '678542987', 'En camino');

INSERT INTO productosrec VALUES ('HSJF', 'Mueble', 54);
INSERT INTO productosrec VALUES ('HSJF', 'Silla', 34);
INSERT INTO productosrec VALUES('HSJF', 'Cabesona', 34);
