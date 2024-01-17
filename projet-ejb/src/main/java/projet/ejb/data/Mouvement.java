package projet.ejb.data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the mouvement database table.
 * 
 */
@Entity
@Table(name = "mouvement")
public class Mouvement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmouvement")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_transaction")
	private Date dateTransaction;

	@Column(name="heure_transaction")
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

}