package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoBanque;
import projet.commun.dto.DtoEnchere;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoProduit;
import projet.commun.dto.DtoUtilisateur;
import projet.ejb.data.Banque;
import projet.ejb.data.Enchere;
import projet.ejb.data.Mouvement;
import projet.ejb.data.Produit;
import projet.ejb.data.Utilisateur;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
    Utilisateur map(DtoUtilisateur source);

    @Mapping(source = "motdepasse", target = "motDePasse")
    DtoUtilisateur map(Utilisateur source);
	
	//Banque
	
	DtoBanque map(Banque source);

	Banque map(DtoBanque dtoBanque);

	Mouvement map(DtoMouvement dtoMouvement);

	DtoMouvement map(Mouvement mouvement);

	Enchere map(DtoEnchere dtoEnchere);

	DtoEnchere map(Enchere retrouver);

	Produit map(DtoProduit dtoProduit);

	DtoProduit map(Produit produit);
	
}
