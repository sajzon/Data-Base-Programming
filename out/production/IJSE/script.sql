DROP DATABASE IF EXISTS IJSE2;
CREATE DATABASE IF NOT EXISTS IJSE2;
SHOW DATABASES;
USE  IJSE2;
#-----------------------------
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
    studentId VARCHAR (45),
    studentName VARCHAR (45) NOT NULL DEFAULT 'Unknown',
    email TEXT,
    contact VARCHAR (20),
    address TEXT,
    nic VARCHAR (45),
    CONSTRAINT PRIMARY KEY (studentId)
    );
SHOW TABLES;
DESCRIBE Student;
#--------------------------------
