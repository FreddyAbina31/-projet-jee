package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;

public interface IServiceMouvement {
<<<<<<< HEAD

	int inserer(DtoMouvement dtoMouvement) throws ExceptionValidation;

//	void modifier(DtoMouvement dtoMouvement) throws ExceptionValidation;

	void supprimer(int idMouvement) throws ExceptionValidation;

	DtoMouvement retrouver(int idMouvement);

	List<DtoMouvement> listerTout();

=======
	int				inserer( DtoMouvement dtoMouvement ) throws ExceptionValidation;

	void			modifier( DtoMouvement dtoMouvement ) throws ExceptionValidation; 

	void			supprimer( int idProduit ) throws ExceptionValidation;

	DtoMouvement 		retrouver( int idProduit ) ;

	List<DtoMouvement>	listerTout() ;
>>>>>>> b51633555e5204a6e21b550745e3d28f3410430f
}
