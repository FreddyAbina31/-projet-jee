-- Supprime toutes les données
DELETE FROM Banque;
DELETE FROM Utilisateur;
DELETE FROM Role;
DELETE FROM Compte;
DELETE FROM Produit;
DELETE FROM Enchere;
DELETE FROM Mouvement;

-- Ajouter des données à la table Banque
INSERT INTO Banque (solde, nom) VALUES
  (1000.00, 'Banque1'),
  (2000.00, 'Banque2'),
  (3000.00, 'Banque3');
  
-- Ajout des utilisateurs en les reliant aux comptes
INSERT INTO Utilisateur (Nom, Prenom, Email, Motdepasse, Credit, id_banque) VALUES
  ('NomUser1', 'PrenomUser1', 'user1@3il.com', 'user1', 0.0, 1),
  ('NomUser2', 'PrenomUser2', 'user2@3il.com', 'user2', 0.0, 2),
  ('NomGest1', 'PrenomGest1', 'gest1@3il.com', 'gest1', 0.0, 3);

-- Ajouter des données à la table Compte
INSERT INTO Compte (Pseudo, MotDePasse, Email) VALUES
  ('user1', 'user1', 'user1@3il.com'),
  ('user2', 'user2', 'user2@3il.com'),
  ('gest1', 'gest1', 'gest1@3il.com');
  
INSERT INTO Role (IdCompte, Role) VALUES
  (1, 'USAGER'),
  (2, 'USAGER'),
  (3, 'GESTIONNAIRE');

-- Ajouter des données à la table Enchere
INSERT INTO Enchere (prix, Id_compte) VALUES
  (10.00, 1),
  (15.00, 2),
  (20.00, 3),
  (25.00, 1);

-- Ajouter des données à la table Produit en utilisant les identifiants d'enchères générés
INSERT INTO Produit (Nom, Photo, Description, Prix_minimal, date_debut_enchere, date_fin_enchere, heure_debut_enchere, heure_fin_enchere, flag, Id_compte, Id_enchere) VALUES
  ('Produit1', 'produit1.jpg', 'Description du produit 1', 10.00, '2024-01-20', '2024-01-25', '09:00:00', '17:00:00', 'En cours', 1, 1),
  ('Produit2', 'produit2.jpg', 'Description du produit 2', 15.00, '2024-01-22', '2024-01-28', '10:00:00', '18:00:00', 'En cours', 1, 2),
  ('Produit3', 'produit3.jpg', 'Description du produit 3', 20.00, '2024-01-25', '2024-01-30', '11:00:00', '19:00:00', 'En cours', 2, 3),
  ('Produit4', 'produit4.jpg', 'Description du produit 4', 25.00, '2024-01-28', '2024-02-02', '12:00:00', '20:00:00', 'En cours', 2, 4);
