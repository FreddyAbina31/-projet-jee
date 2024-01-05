package projet.jsf.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Format de date attendu : YYYY-MM-DD")
	private Date dateDebutEnchere;

	@Temporal(TemporalType.DATE)
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Format de date attendu : YYYY-MM-DD")
	private Date dateFinEnchere;

	
	private String description;

	private String flag;

	@Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Format d'heure attendu : HH:MM")
	private Time heureDebutEnchere;

	@Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Format d'heure attendu : HH:MM")
	private Time heureFinEnchere;

	@NotBlank(message = "Le nom du produit doit être renseigné")
	private String nom;

	@NotBlank(message = "Il faut une photo pour le produit")
	private String photo;

	private BigDecimal prixMinimal;

	// bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy = "produit")
	private List<Enchere> encheres;

	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}
	

}
