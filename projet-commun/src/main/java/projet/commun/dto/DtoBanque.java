package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class DtoBanque implements Serializable{

	private int id;

	private String nom;

	private BigDecimal solde;

	private List<DtoUtilisateur> utilisateurs;

	public DtoBanque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getSolde() {
		return this.solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public List<DtoUtilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<DtoUtilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public DtoUtilisateur addUtilisateur(DtoUtilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setBanque(this);

		return utilisateur;
	}

	public DtoUtilisateur removeUtilisateur(DtoUtilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setBanque(null);

		return utilisateur;
	}
}
