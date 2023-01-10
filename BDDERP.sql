CREATE DATABASE if NOT EXISTS ERP;

USE ERP;

CREATE OR REPLACE TABLE recepciones(
Referencia VARCHAR(15) PRIMARY KEY,
Proveedor VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
Contacto VARCHAR(50),
Estado VARCHAR(100)
);

SELECT Contacto, Referencia, FechaPrevista, Documento, Estado FROM recepciones;

Select Producto, Cantidad from productosrec WHERE referencia = "HSJF";

CREATE OR REPLACE TABLE devoluciones(
Referencia VARCHAR(15) PRIMARY KEY,
Proveedor VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
NombreProducto VARCHAR(50),
Cantidad INT
);

CREATE OR REPLACE TABLE expediciones(
Referencia VARCHAR(15) PRIMARY KEY,
Proveedor VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
NombreProducto VARCHAR(50),
Cantidad INT
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

INSERT INTO recepciones VALUES ("HSJF", "IKEA", '2020-03-04', "agfg.pdf", "ikeasupport@gmail.com", "En camino");

INSERT INTO productosrec VALUES ("HSJF", "Mueble", 54);
INSERT INTO productosrec VALUES ("HSJF", "Silla", 34);