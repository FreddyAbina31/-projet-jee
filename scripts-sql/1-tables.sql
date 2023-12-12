SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet;


-- Tables

CREATE TABLE compte (
	IdCompte		INT			 	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
	Pseudo			VARCHAR(25)		NOT NULL,
	MotDePasse		VARCHAR(25) 	NOT NULL,
	Email			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (IdCompte)
);
CREATE UNIQUE INDEX idx_compte_pseudo ON compte (Pseudo ASC);

CREATE TABLE role (
	IdCompte		INT				NOT NULL,
	Role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR') ),	
	FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte),
	PRIMARY KEY (IdCompte, Role)
);

