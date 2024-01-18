SET search_path TO projet;

-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet;

-- Tables
DROP TABLE IF EXISTS Banque;
DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS Enchere;
DROP TABLE IF EXISTS Produit;
DROP TABLE IF EXISTS Mouvement;

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

-- Créez d'abord la table Enchere sans la clé étrangère Id_produit
CREATE TABLE Enchere(
    IdEnchere       INT             GENERATED BY DEFAULT AS IDENTITY,
    prix DECIMAL(15,2),
    Id_compte INT NOT NULL,
    PRIMARY KEY(IdEnchere),
    FOREIGN KEY(Id_compte) REFERENCES Compte(IdCompte)
);

-- Ensuite, créez la table Produit avec une clé étrangère vers Enchere
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
    Id_compte INT NOT NULL,
    Id_enchere INT NOT NULL,
    PRIMARY KEY(IdProduit),
    FOREIGN KEY(Id_compte) REFERENCES Compte(IdCompte),
    FOREIGN KEY(Id_enchere) REFERENCES Enchere(IdEnchere)
);

-- Maintenant, vous pouvez ajouter la clé étrangère Id_produit à Enchere
ALTER TABLE Enchere
ADD COLUMN Id_produit INT,
ADD FOREIGN KEY (Id_produit) REFERENCES Produit(IdProduit),
ADD UNIQUE (Id_produit);

-- Enfin, créez vos index
CREATE INDEX idx_enchere_id_produit ON Enchere (Id_produit);
CREATE INDEX idx_produit_id_compte ON Produit (Id_compte);
CREATE INDEX idx_produit_id_enchere ON Produit (Id_enchere);


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
