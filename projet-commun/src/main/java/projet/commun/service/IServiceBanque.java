package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoBanque;
import projet.commun.exception.ExceptionValidation;

public interface IServiceBanque {

	int				inserer( DtoBanque dtoBanque ) throws ExceptionValidation;

	void			modifier( DtoBanque dtoBanque ) throws ExceptionValidation; 

	void			supprimer( int idBanque) throws ExceptionValidation;

	DtoBanque 		retrouver( int idBanque) ;

	List<DtoBanque>	listerTout() ;
}
