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
	@Column(name = "idbanque")
	private int id;

	private String nom;

	private BigDecimal solde;

	@OneToMany(mappedBy = "banque", cascade = ALL, fetch = FetchType.LAZY, orphanRemoval = true)
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

	public List<Utilisateur> getUtilisateur() {
		return this.utilisateurs;
	}

	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateurs = utilisateur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateur().add(utilisateur);
		utilisateur.setBanque(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateur().remove(utilisateur);
		utilisateur.setBanque(null);

		return utilisateur;
	}

}