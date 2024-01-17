package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable {

	private Integer id;

	private BigDecimal credit;

	private String email;

	private String motDePasse;

	private String nom;

	private String prenom;

	private List<DtoMouvement> mouvements;

	private List<DtoProduit> produits;

	private DtoBanque banque;

	private List<DtoEnchere> encheres;

	public DtoUtilisateur(Integer id, BigDecimal credit, String email, String motDePasse, String nom, String prenom, List<DtoMouvement> mouvements, List<DtoProduit> produits, DtoBanque banque,
			List<DtoEnchere> encheres) {
		super();
		this.id = id;
		this.credit = credit;
		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mouvements = mouvements;
		this.produits = produits;
		this.banque = banque;
		this.encheres = encheres;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<DtoMouvement> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<DtoMouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public List<DtoProduit> getProduits() {
		return produits;
	}

	public void setProduits(List<DtoProduit> produits) {
		this.produits = produits;
	}

	public DtoBanque getBanque() {
		return banque;
	}

	public void setBanque(DtoBanque banque) {
		this.banque = banque;
	}

	public List<DtoEnchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<DtoEnchere> encheres) {
		this.encheres = encheres;
	}

}
