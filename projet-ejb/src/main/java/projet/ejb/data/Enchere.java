package projet.ejb.data;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the enchere database table.
 * 
 */
@Entity
@Table(name = "enchere")
public class Enchere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenchere")
	private int id;

	private BigDecimal prix;
	
	@OneToOne
    @JoinColumn(name = "id_produit", unique = true)
    private Produit produit;
	
	//bi-directional many-to-many association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;

	public Enchere() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}