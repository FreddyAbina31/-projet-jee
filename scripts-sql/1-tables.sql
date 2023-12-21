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
DROP TABLE IF EXISTS Utilisateur_enchere;

CREATE TYPE Role as ENUM('usager', 'gestionnaire');
CREATE TABLE Banque(
   id VARCHAR(50),
   solde DECIMAL(15,2) NOT NULL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);
 
CREATE TABLE Utilisateur(
   Id INT,
   Nom VARCHAR(50),
   Prenom VARCHAR(50),
   Email VARCHAR(50) NOT NULL,
   Pseudo VARCHAR(50) NOT NULL,
   Motdepasse VARCHAR(90),
   Role Role NOT NULL,
   Credit DECIMAL(15,2),
   id_banque VARCHAR(50) NOT NULL,
   PRIMARY KEY(Id),
   UNIQUE(Email),
   FOREIGN KEY(id_banque) REFERENCES Banque(id)
);
 
CREATE TABLE Produit(
   Id INT,
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
   Id INT,
   Libelle VARCHAR(70) NOT NULL,
   date_transaction DATE NOT NULL,
   heure_transaction TIME NOT NULL,
   Id_utilisateur INT NOT NULL,
   PRIMARY KEY(Id),
   FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(Id)
);
 
CREATE TABLE Enchere(
   id VARCHAR(50),
   prix DECIMAL(15,2),
   Id_produit INT NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(Id_produit),
   FOREIGN KEY(Id_produit) REFERENCES Produit(Id)
);
 
CREATE TABLE Utilisateur_enchere(
   Id INT,
   id_enchere VARCHAR(50),
   PRIMARY KEY(Id, id_enchere),
   FOREIGN KEY(Id) REFERENCES Utilisateur(Id),
   FOREIGN KEY(id_enchere) REFERENCES Enchere(id)
);