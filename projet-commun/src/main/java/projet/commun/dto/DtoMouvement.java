package projet.commun.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoMouvement implements Serializable {

	private Integer id;

	private Date dateTransaction;

	private Time heureTransaction;

	private String libelle;

	private DtoUtilisateur utilisateur;
	

	public DtoMouvement(Integer id, Date dateTransaction, Time heureTransaction, String libelle,
			DtoUtilisateur utilisateur) {
		super();
		this.id = id;
		this.dateTransaction = dateTransaction;
		this.heureTransaction = heureTransaction;
		this.libelle = libelle;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateTransaction() {
		return this.dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public Time getHeureTransaction() {
		return this.heureTransaction;
	}

	public void setHeureTransaction(Time heureTransaction) {
		this.heureTransaction = heureTransaction;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DtoUtilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
