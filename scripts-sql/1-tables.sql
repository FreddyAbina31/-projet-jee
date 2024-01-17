SET search_path TO projet;

-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet;

-- Tables
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS Banque;
DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Produit;
DROP TABLE IF EXISTS Mouvement;
DROP TABLE IF EXISTS Enchere;

CREATE TABLE Compte (
    IdCompte        INT             NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    Pseudo          VARCHAR(25)     NOT NULL,
    MotDePasse      VARCHAR(25)     NOT NULL,
    Email           VARCHAR(100)    NOT NULL,
    PRIMARY KEY (IdCompte)
);
CREATE UNIQUE INDEX idx_compte_pseudo ON compte (Pseudo ASC);

CREATE TABLE Role (
    IdCompte        INT             NOT NULL,
    Role            VARCHAR(20)     NOT NULL,
    CHECK( Role IN ('USAGER','GESTIONNAIRE') ),
    FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte),
    PRIMARY KEY (IdCompte, Role)
);

CREATE TABLE Banque(
    idBanque INT GENERATED BY DEFAULT AS IDENTITY,
    solde DECIMAL(15,2) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    PRIMARY KEY(idBanque)
);

CREATE TABLE Utilisateur(
    IdUtilisateur INT GENERATED BY DEFAULT AS IDENTITY,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(50) NOT NULL,
    Motdepasse VARCHAR(90),
    Credit DECIMAL(15,2),
    id_banque INT NOT NULL,
    PRIMARY KEY(IdUtilisateur),
    UNIQUE(Email),
    FOREIGN KEY(id_banque) REFERENCES Banque(idBanque)
);
CREATE INDEX idx_utilisateur_id_banque ON Utilisateur (id_banque);

CREATE TABLE Produit(
    IdProduit       INT             GENERATED BY DEFAULT AS IDENTITY,
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
    PRIMARY KEY(IdProduit),
    FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(IdUtilisateur)
);
CREATE INDEX idx_produit_id_utilisateur ON Produit (Id_utilisateur);

CREATE TABLE Mouvement(
    IdMouvement     INT             GENERATED BY DEFAULT AS IDENTITY,
    Libelle VARCHAR(70) NOT NULL,
    date_transaction DATE NOT NULL,
    heure_transaction TIME NOT NULL,
    Id_utilisateur INT NOT NULL,
    PRIMARY KEY(IdMouvement),
    FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(IdUtilisateur)
);
CREATE INDEX idx_mouvement_id_utilisateur ON Mouvement (Id_utilisateur);

CREATE TABLE Enchere(
    IdEnchere       INT             GENERATED BY DEFAULT AS IDENTITY,
    prix DECIMAL(15,2),
    Id_produit INT NOT NULL,
    Id_utilisateur INT NOT NULL,
    PRIMARY KEY(IdEnchere),
    UNIQUE(Id_produit),
    FOREIGN KEY(Id_produit) REFERENCES Produit(IdProduit),
    FOREIGN KEY(Id_utilisateur) REFERENCES Utilisateur(IdUtilisateur)
);
CREATE INDEX idx_enchere_id_produit ON Enchere (Id_produit);
