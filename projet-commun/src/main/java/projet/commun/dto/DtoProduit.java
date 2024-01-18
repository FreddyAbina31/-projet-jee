package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoProduit implements Serializable {

	private Integer id;

	private Date dateDebutEnchere;

	private Date dateFinEnchere;

	private String description;

	private String flag;
	
	private boolean vente;

	private Time heureDebutEnchere;

	private Time heureFinEnchere;

	private String nom;

	private String photo;

	private BigDecimal prixMinimal;

	private DtoCompte compte;
	
	private DtoEnchere enchere;	


	public DtoProduit(Integer id, Date dateDebutEnchere, Date dateFinEnchere, String description, String flag, boolean vente,
			Time heureDebutEnchere, Time heureFinEnchere, String nom, String photo, BigDecimal prixMinimal,
			DtoEnchere encheres, DtoCompte compte) {
		super();
		this.id = id;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.description = description;
		this.flag = flag;
		this.heureDebutEnchere = heureDebutEnchere;
		this.heureFinEnchere = heureFinEnchere;
		this.nom = nom;
		this.photo = photo;
		this.prixMinimal = prixMinimal;
		this.enchere = encheres;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Time getHeureDebutEnchere() {
		return heureDebutEnchere;
	}

	public void setHeureDebutEnchere(Time heureDebutEnchere) {
		this.heureDebutEnchere = heureDebutEnchere;
	}

	public Time getHeureFinEnchere() {
		return heureFinEnchere;
	}

	public void setHeureFinEnchere(Time heureFinEnchere) {
		this.heureFinEnchere = heureFinEnchere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPrixMinimal() {
		return prixMinimal;
	}

	public void setPrixMinimal(BigDecimal prixMinimal) {
		this.prixMinimal = prixMinimal;
	}

	public DtoEnchere getEnchere() {
		return enchere;
	}

	public void setEncheres(DtoEnchere encheres) {
		this.enchere = encheres;
	}

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

	public boolean isVente() {
		return vente;
	}

	public void setVente(boolean vente) {
		this.vente = vente;
	}
}
