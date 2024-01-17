package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoBanque;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEnchere;
import projet.commun.dto.DtoMouvement;
import projet.commun.dto.DtoProduit;
import projet.commun.dto.DtoUtilisateur;
import projet.jsf.data.Banque;
import projet.jsf.data.Compte;
import projet.jsf.data.Enchere;
import projet.jsf.data.Mouvement;
import projet.jsf.data.Produit;
import projet.jsf.data.Utilisateur;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// Compte
	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	// Banque

	Banque map(DtoBanque source);

	DtoBanque map(Banque source);

	Banque duplicate(Banque source);

	Banque update(@MappingTarget Banque target, Banque source);

	// Enchere

	Enchere map(DtoEnchere source);

	DtoEnchere map(Enchere source);

	Enchere duplicate(Enchere source);

	Enchere update(@MappingTarget Enchere target, Enchere source);

	// Mouvement

	Mouvement map(DtoMouvement source);

	DtoMouvement map(Mouvement source);

	Mouvement duplicate(Mouvement source);

	Mouvement update(@MappingTarget Mouvement target, Mouvement source);

	// Produit

	Produit map(DtoProduit source);

	DtoProduit map(Produit source);

	Produit duplicate(Produit source);

	Produit update(@MappingTarget Produit target, Produit source);

	// Utilisateur

	Utilisateur map(DtoUtilisateur source);

	@Mapping(source = "motdepasse", target = "motDePasse")
	DtoUtilisateur map(Utilisateur source);

	Utilisateur duplicate(Utilisateur source);

	Utilisateur update(@MappingTarget Utilisateur target, Utilisateur source);

}
