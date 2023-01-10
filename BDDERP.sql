CREATE DATABASE if NOT EXISTS ERP;

USE ERP;

CREATE OR REPLACE TABLE recepciones(
Referencia VARCHAR(15) PRIMARY KEY,
Proveedor VARCHAR(50),
FechaPrevista DATE,
Documento VARCHAR(100),
NombreProducto VARCHAR(50),
Cantidad INT
);

