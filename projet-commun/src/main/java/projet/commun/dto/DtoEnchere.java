package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoEnchere implements Serializable{

	private int id;

	private BigDecimal prix;
	
	private DtoProduit produit;

	private DtoCompte compte;


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

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}


}
