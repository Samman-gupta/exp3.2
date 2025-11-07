CREATE DATABASE IF NOT EXISTS bankdb;
USE bankdb;
CREATE TABLE IF NOT EXISTS account (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);
INSERT INTO account (id, name, balance) VALUES (1, 'Alice', 1000), (2, 'Bob', 500);
