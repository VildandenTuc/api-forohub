CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(300) NOT NULL,
    fechaDeCreacion DATETIME NOT NULL,  -- Usamos DATETIME en lugar de VARCHAR
    status VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);