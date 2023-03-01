CREATE DATABASE IF NOT EXISTS PruebaScript;

USE PruebaScript;

CREATE OR REPLACE TABLE proveedores(
    CIF CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50) UNIQUE,
    Direccion VARCHAR(100),
    Email VARCHAR(50),
    Tel CHAR(9) UNIQUE
);

CREATE TABLE IF NOT EXISTS ventas(
Codigo CHAR(6),
FechaPrevista DATE,
Cliente VARCHAR(50),
PlazosDePago INT,
PRIMARY KEY (Codigo)
);

CREATE TABLE IF NOT EXISTS productosvent(
Codigo CHAR(6),
Producto VARCHAR(50),
Cantidad VARCHAR(50),
PrecioUnidad VARCHAR(50),
PRIMARY KEY (codigo)
);
            
         
CREATE OR REPLACE TABLE recepciones(
    Referencia VARCHAR(15) PRIMARY KEY,
    Nombre VARCHAR(50),
    FechaPrevista DATE,
    Documento VARCHAR(100),
    Tel CHAR(9),
    Estado VARCHAR(100),
    CONSTRAINT Nombre_fk FOREIGN KEY (Nombre) REFERENCES proveedores (Nombre),
    CONSTRAINT Tel_fk FOREIGN KEY (Tel) REFERENCES proveedores (Tel)
);

CREATE OR REPLACE TABLE devoluciones(
    Referencia VARCHAR(15) PRIMARY KEY,
    Direccion VARCHAR(50),
    Nombre VARCHAR(50),
    FechaPrevista DATE,
    Documento VARCHAR(100),
    Tel CHAR(9),
    Estado VARCHAR(100),
    FOREIGN KEY (Nombre) REFERENCES clientes (Nombre),
    FOREIGN KEY (Tel) REFERENCES clientes (Tel)
);

CREATE OR REPLACE TABLE productosdev(
    Referencia VARCHAR(15),
    Producto VARCHAR(50),
    Cantidad INT,
    CONSTRAINT Referenciadev FOREIGN KEY (Referencia) 
    REFERENCES Devoluciones (Referencia)
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
    FOREIGN KEY (Nombre) REFERENCES clientes (Nombre),
    FOREIGN KEY (Tel) REFERENCES clientes (Tel)
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
    CONSTRAINT Referencia_fk FOREIGN KEY (Referencia) 
    REFERENCES Recepciones (Referencia)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE OR REPLACE TABLE empleados(
    Nombre VARCHAR(50) NOT NULL, 
    PuestoEmpresa VARCHAR(50) NOT NULL, 
    Telefono CHAR(9) NULL, 
    emaillaboral VARCHAR(100) NOT NULL, 
    Departamento VARCHAR(50) NOT NULL, 
    Gerente VARCHAR(50) NOT NULL, 
    Foto VARCHAR(255), 
    DireccionLaboral VARCHAR(100), 
    HorarioLaboral VARCHAR(50), 
    DireccionPersonal VARCHAR(150), 
    NumeroCuentaBancaria CHAR(24),
    DNI CHAR(9), 
    Genero VARCHAR(50), 
    FechaNacimiento DATE
);

CREATE OR REPLACE TABLE imgempleados(
    Foto VARCHAR(255),
    image BLOB (524288000)
);


INSERT INTO proveedores VALUES ('CAD87542G', 'Iago S.L.', 'C/ Calatrava n8', 'iago@safareyes.es', '678542987');

INSERT INTO recepciones VALUES ('HSJF', 'Iago S.L.', '2020-03-04', 'agfg.pdf
