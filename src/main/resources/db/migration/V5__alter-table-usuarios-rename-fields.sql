-- V2__rename_fields_in_usuarios_table.sql
ALTER TABLE usuarios
CHANGE COLUMN userName login VARCHAR(255) NOT NULL,
CHANGE COLUMN password clave VARCHAR(255) NOT NULL;
