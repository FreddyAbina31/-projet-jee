package projet.ejb.data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal credit;

	private String email;

	@Column(name = "motdepasse")
	private String motDePasse;

	private String nom;

	private String prenom;
	
	@OneToMany(mappedBy = "utilisateur", cascade = ALL, orphanRemoval = true)
    private List<Mouvement> mouvements;

    @OneToMany(mappedBy = "utilisateur", cascade = ALL, orphanRemoval = true)
    private List<Produit> produits;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    @ManyToMany
    @JoinTable(
            name = "utilisateur_enchere",
            joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_enchere"))
    private List<Enchere> encheres;

	public Utilisateur() {
	}

	public Utilisateur(Integer id, BigDecimal credit, String email, String motDePasse, String nom, String prenom,
			String pseudo, Banque banque) {
		super();
		this.id = id;
		this.credit = credit;
		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
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

}