package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Banque;

public interface IDaoBanque {

	int			inserer( Banque banque );

	void 		modifier( Banque banque );

	void 		supprimer( int idBanque );

	Banque 	retrouver( int idBanque );

	List<Banque> listerTout();
}
