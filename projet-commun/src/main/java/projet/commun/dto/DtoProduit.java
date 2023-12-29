package projet.commun.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class DtoProduit {

	private Integer id;

	private Date dateDebutEnchere;

	private Date dateFinEnchere;

	private String description;

	private String flag;

	private Time heureDebutEnchere;

	private Time heureFinEnchere;

	private String nom;

	private String photo;

	private BigDecimal prixMinimal;

	private List<DtoEnchere> encheres;

	private DtoUtilisateur utilisateur;
	
	


	public DtoProduit(Integer id, Date dateDebutEnchere, Date dateFinEnchere, String description, String flag,
			Time heureDebutEnchere, Time heureFinEnchere, String nom, String photo, BigDecimal prixMinimal,
			List<DtoEnchere> encheres, DtoUtilisateur utilisateur) {
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
		this.encheres = encheres;
		this.utilisateur = utilisateur;
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

	public List<DtoEnchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<DtoEnchere> encheres) {
		this.encheres = encheres;
	}

	public DtoUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
