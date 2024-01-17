package projet.jsf.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal credit;

	@NotBlank( message="L'adresse e-mail ne peut pas être vide")
	@Email( message="L'adresse e-mail n'est pas valide.")
	private String email;

	@Column(name = "Motdepasse")
	private String motDePasse;

	@NotBlank(message = "Le nom ne peut pas être vide")
	@Size(max=50, message="Valeur trop longue pour le nom : 50 car. maxi" )
	private String nom;

	@NotBlank(message = "Le prenom ne peut pas être vide")
	@Size(max=50, message="Valeur trop longue pour le prenom : 50 car. maxi" )
	private String prenom;

	private String pseudo;
	@NotBlank(message = "Le rôle ne peut pas être vide")
    @Pattern(regexp = "^(usager|gestionnaire)$", message = "Le rôle doit être 'usager' ou 'gestionnaire'")
	private String role;

	//bi-directional many-to-one association to Mouvement
	@OneToMany(mappedBy="utilisateur")
	private List<Mouvement> mouvements;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="utilisateur")
	private List<Produit> produits;

	//bi-directional many-to-one association to Banque
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque;

	//bi-directional many-to-many association to Enchere
	@ManyToMany
	@JoinTable(
		name="utilisateur_enchere"
		, joinColumns={
			@JoinColumn(name="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_enchere")
			}
		)
	private List<Enchere> encheres;

	public Utilisateur() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCredit() {
		return this.credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return this.motDePasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Mouvement> getMouvements() {
		return this.mouvements;
	}

	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public Mouvement addMouvement(Mouvement mouvement) {
		getMouvements().add(mouvement);
		mouvement.setUtilisateur(this);

		return mouvement;
	}

	public Mouvement removeMouvement(Mouvement mouvement) {
		getMouvements().remove(mouvement);
		mouvement.setUtilisateur(null);

		return mouvement;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setUtilisateur(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setUtilisateur(null);

		return produit;
	}

	public Banque getBanque() {
		return this.banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<Enchere> getEncheres() {
		return this.encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}
	
}


