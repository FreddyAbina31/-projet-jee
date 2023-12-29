package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoBanque;
import projet.commun.dto.DtoUtilisateur;
import projet.ejb.data.Banque;
import projet.ejb.data.Utilisateur;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	@Mapping(source = "id", target = "id")
    @Mapping(source = "credit", target = "credit")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "motDePasse", target = "motdepasse")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "pseudo", target = "pseudo")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "banque", target = "banque")
    Utilisateur map(DtoUtilisateur source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "credit", target = "credit")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "motdepasse", target = "motDePasse")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "pseudo", target = "pseudo")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "banque", target = "banque")
    DtoUtilisateur map(Utilisateur source);
	
	//Banque
	
	DtoBanque map(Banque source);
	
}
