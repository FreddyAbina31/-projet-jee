package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoEnchere implements Serializable{

	private int id;

	private BigDecimal prix;
	
	private DtoProduit produit;

	private DtoUtilisateur utilisateur;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public DtoProduit getProduit() {
		return this.produit;
	}

	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}

	public DtoUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


}
