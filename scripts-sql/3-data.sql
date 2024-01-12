SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM Banque;
DELETE FROM Utilisateur;
DELETE FROM Produit;
DELETE FROM Mouvement;
DELETE FROM Enchere;
DELETE FROM Utilisateur_enchere;


-- Insère les données

-- Compte

INSERT INTO Banque (id, solde, nom ) VALUES 
( 1, 200, 'BiguissBaque' );

ALTER TABLE Banque ALTER COLUMN id RESTART WITH 2;


-- Utilisateur

INSERT INTO Utilisateur (id, nom, prenom, email,pseudo, Motdepasse, Role, Credit, id_banque ) VALUES 
( 1, 'geek', 'geek', 'geek@jfox.fr','geek','geek','gestionnaire',200, 1 );

ALTER TABLE Utilisateur ALTER COLUMN id RESTART WITH 2;

 
