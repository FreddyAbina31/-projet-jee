package projet.ejb.data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the banque database table.
 * 
 */
@Entity
@Table(name = "banque")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	private BigDecimal solde;

	// bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy = "banque", cascade = ALL, orphanRemoval = true)
	private List<Utilisateur> utilisateurs;

	public Banque() {
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

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setBanque(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setBanque(null);

		return utilisateur;
	}

}