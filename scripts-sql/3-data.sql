SET search_path TO projet;


-- Supprime toutes les données*
DELETE FROM Banque;
DELETE FROM Utilisateur;
DELETE FROM Role;
DELETE FROM Compte;


<<<<<<< HEAD
-- Ajouter des données à la table Compte
INSERT INTO Compte (Pseudo, MotDePasse, Email) VALUES
  ('user1', 'user1', 'user1@3il.com'),
  ('user2', 'user2', 'user2@3il.com'),
  ('gest1', 'gest1', 'gest1@3il.com');

-- Ajouter des données à la table Role
INSERT INTO Role (IdCompte, Role) VALUES
  (1, 'USAGER'),
  (2, 'USAGER'),
  (3, 'GESTIONNAIRE');

-- Ajouter des données à la table Banque
INSERT INTO Banque (solde, nom) VALUES
  (1000.00, 'Banque1'),
  (2000.00, 'Banque2'),
  (3000.00, 'Banque3');
=======
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
>>>>>>> 0cb71fd2697a4c3723e2c79989f0b4526f1a631d

-- Ajouter des données à la table Utilisateur
INSERT INTO Utilisateur (Nom, Prenom, Email, Motdepasse, Credit, id_banque) VALUES
  ('toubs', 'toubs', 'toubs@example.com', 'toubs', 500.00, 1),
  ('abina', 'abina', 'abina@example.com', 'abina', 800.00, 2),
  ('admin', 'admin', 'admin@example.com', 'admin', 0.00, 3);

