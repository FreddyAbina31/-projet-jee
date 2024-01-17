package projet.jsf.data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Mouvement implements Serializable{
	
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Format de date attendu : YYYY-MM-DD")
	private Date dateTransaction;

	@Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Format d'heure attendu : HH:MM")
	private Time heureTransaction;

	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(min=10, message = "Valeur trop courte pour le libellé : 10 car. min" )
	private String libelle;

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
