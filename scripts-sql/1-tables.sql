SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet;


-- Tables

DROP TABLE IF EXISTS Banque;
DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Produit;
DROP TABLE IF EXISTS Mouvement;
DROP TABLE IF EXISTS Enchere;


	

CREATE TABLE Banque(
   id INT GENERATED BY DEFAULT AS IDENTITY,
   solde DECIMAL(15,2) NOT NULL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);
 
CREATE TABLE Utilisateur(
   Id INT GENERATED BY DEFAULT AS IDENTITY,
   Nom VARCHAR(50),
   Prenom VARCHAR(50),
   Email VARCHAR(50) NOT NULL,
   Pseudo VARCHAR(50) NOT NULL,
   Motdepasse VARCHAR(90),
   Role VARCHAR(20) NOT NULL,
   Credit DECIMAL(15,2),
   id_banque INT NOT NULL,
   PRIMARY KEY(Id),
   UNIQUE(Email),
   FOREIGN KEY(id_banque) REFERENCES Banque(id)
);
 
CREATE TABLE Produit(
   Id INT GENERATED BY DEFAULT AS IDENTITY,
   Nom VARCHAR(50) NOT NULL,
   Photo VARCHAR(50),
   Description VARCHAR(70),
   Prix_minimal DECIMAL(15,2) NOT NULL,
   date_debut_enchere DATE NOT NULL,
   date_fin_enchere DATE NOT NULL,
   heure_debut_enchere TIME NOT NULL,
   heure_fin_enchere TIME NOT NULL,
   flag VARCHAR(50) NOT NULL,
   Id_utilisateur INT NOT NULL,
   PRIMARY KEY(Id),
   FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(Id)
);
 
CREATE TABLE Mouvement(
   Id INT GENERATED BY DEFAULT AS IDENTITY,
   Libelle VARCHAR(70) NOT NULL,
   date_transaction DATE NOT NULL,
   heure_transaction TIME NOT NULL,
   Id_utilisateur INT NOT NULL,
   PRIMARY KEY(Id),
   FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(Id)
);
 
CREATE TABLE Enchere(
   id INT  GENERATED BY DEFAULT AS IDENTITY,
   prix DECIMAL(15,2),
   Id_produit INT NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(Id_produit),
   FOREIGN KEY(Id_produit) REFERENCES Produit(Id)
);