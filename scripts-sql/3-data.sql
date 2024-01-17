SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM Banque;
DELETE FROM Utilisateur;


-- Insère les données

DELETE FROM Produit;
DELETE FROM Mouvement;
DELETE FROM Enchere;
DELETE FROM Utilisateur_enchere;


-- Insère les données







 
-- Données pour la table Banque
INSERT INTO Banque (solde, nom) VALUES
(1000.00, 'BNP Paribas'),
(500.00, 'Crédit Agricole'),
(100.00, 'BiguissBaque' );
ALTER TABLE Banque ALTER COLUMN id RESTART WITH 4;

-- Données pour la table Utilisateur
INSERT INTO Utilisateur (Nom, Prenom, Email, Pseudo, Motdepasse, Role, Credit, id_banque) VALUES
('admin', 'admin', 'jean.dupont@gmail.com', 'admin', 'admin', 'gestionnaire', 200.00, 1),
('toubs', 'toubs', 'toubs@yahoo.fr', 'toubs', 'azerty', 'usager', 100.00, 2);

ALTER TABLE Utilisateur ALTER COLUMN id RESTART WITH 3;
