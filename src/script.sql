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
CREATE TABLE Registration(
     registration_id VARCHAR(45) NOT NULL,
    reg_date DATE,
     PRIMARY KEY ( registration_id ),
     FOREIGN KEY (student_id)
     REFERENCES student (studentId)
    ON UPDATE RESTRICT ON DELETE CASCADE,
    FOREIGN KEY (intake_id)
     REFERENCES intake (intake_id)
     ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE Intake(
      intake_id VARCHAR(45) NOT NULL,
      start_date DATE,
      description VARCHAR(45) NOT NULL,
      FOREIGN KEY (course_id)
       REFERENCES course (course_id)
       ON UPDATE RESTRICT ON DELETE CASCADE,
       PRIMARY KEY ( intake_id )
);

CREATE TABLE Subjects(
    subject_id VARCHAR(45) NOT NULL,
    subject_name VARCHAR(45) NOT NULL,
    credit DOUBLE,
    PRIMARY KEY ( subject_id ),
    duration VARCHAR(45) NOT NULL,
    FOREIGN KEY (subject_id)
    REFERENCES subjects (subject_id)
     ON UPDATE RESTRICT ON DELETE CASCADE
);

CRATE TABLE Course(
   course_id VARCHAR(45) NOT NULL,
   course_name VARCHAR(45) NOT NULL,
   cost DOUBLE,
   PRIMARY KEY ( intake_id ),
   duration VARCHAR(45) NOT NULL,
   FOREIGN KEY (teacher_id)
   REFERENCES teacher (teacher_id)
   ON UPDATE RESTRICT ON DELETE CASCADE

);

CREATE TABLE Teacher(
    teacher_id VARCHAR(45) NOT NULL,
    teacher_name VARCHAR(45) NOT NULL,
    contact VARCHAR(45) NOT NULL,
    address text NOT NULL,
    nic VARCHAR(45) NOT NULL,
     PRIMARY KEY ( teacher_id )
);

CREATE TABLE Payment(
    payment_id VARCHAR(45) NOT NULL,
    date DATE,
    cost DOUBLE,
    PRIMARY KEY ( payment_id ),
    FOREIGN KEY (registration_id)
    REFERENCES registration (registration_id)
    ON UPDATE RESTRICT ON DELETE CASCADE
);
