package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Utilisateur;

public interface IDaoUtilisateur {

	int			inserer( Utilisateur utilisateur );

	void 		modifier( Utilisateur utilisateur );

	void 		supprimer( int idUtilisateur );

	Utilisateur 		retrouver( int idUtilisateur );

	List<Utilisateur> listerTout();
}
