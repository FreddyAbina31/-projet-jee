SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM Banque;
DELETE FROM Utilisateur;
<<<<<<< HEAD


-- Insère les données
=======
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

>>>>>>> b51633555e5204a6e21b550745e3d28f3410430f
 
-- Données pour la table Banque
INSERT INTO Banque (solde, nom) VALUES
(1000.00, 'BNP Paribas'),
(500.00, 'Crédit Agricole');

-- Données pour la table Utilisateur
INSERT INTO Utilisateur (Nom, Prenom, Email, Pseudo, Motdepasse, Role, Credit, id_banque) VALUES
('admin', 'admin', 'jean.dupont@gmail.com', 'admin', 'admin', 'gestionnaire', 200.00, 1),
('toubs', 'toubs', 'toubs@yahoo.fr', 'toubs', 'azerty', 'usager', 100.00, 2);

ALTER TABLE Utilisateur ALTER COLUMN id RESTART WITH 3;
