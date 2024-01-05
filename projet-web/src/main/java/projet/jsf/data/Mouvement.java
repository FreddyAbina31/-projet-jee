package projet.jsf.data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

public class Mouvement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Format de date attendu : YYYY-MM-DD")
	private Date dateTransaction;

	@Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Format d'heure attendu : HH:MM")
	private Time heureTransaction;

	private String libelle;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Mouvement() {
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
		Mouvement other = (Mouvement) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
