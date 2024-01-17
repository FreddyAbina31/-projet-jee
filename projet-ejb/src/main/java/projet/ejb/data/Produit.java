package projet.ejb.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduit")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut_enchere")
	private Date dateDebutEnchere;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin_enchere")
	private Date dateFinEnchere;

	private String description;

	private String flag;

	@Column(name="heure_debut_enchere")
	private Time heureDebutEnchere;

	@Column(name="heure_fin_enchere")
	private Time heureFinEnchere;

	private String nom;

	private String photo;

	@Column(name="prix_minimal")
	private BigDecimal prixMinimal;

	//bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy="produit")
	private List<Enchere> encheres;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Produit() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebutEnchere() {
		return this.dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return this.dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Time getHeureDebutEnchere() {
		return this.heureDebutEnchere;
	}

	public void setHeureDebutEnchere(Time heureDebutEnchere) {
		this.heureDebutEnchere = heureDebutEnchere;
	}

	public Time getHeureFinEnchere() {
		return this.heureFinEnchere;
	}

	public void setHeureFinEnchere(Time heureFinEnchere) {
		this.heureFinEnchere = heureFinEnchere;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPrixMinimal() {
		return this.prixMinimal;
	}

	public void setPrixMinimal(BigDecimal prixMinimal) {
		this.prixMinimal = prixMinimal;
	}

	public List<Enchere> getEncheres() {
		return this.encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Enchere addEnchere(Enchere enchere) {
		getEncheres().add(enchere);
		enchere.setProduit(this);

		return enchere;
	}

	public Enchere removeEnchere(Enchere enchere) {
		getEncheres().remove(enchere);
		enchere.setProduit(null);

		return enchere;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}