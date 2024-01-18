package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoProduit;
import projet.ejb.data.Produit;

@Stateless
@Local
public class DaoProduit implements IDaoProduit{
	
	// Champs

	@PersistenceContext
	private EntityManager	em;

	@TransactionAttribute( MANDATORY )
	@Override
	public int inserer(Produit produit) {
		produit.getEnchere().setProduit(produit);
		em.persist(produit);
		em.flush();
		return produit.getId();
	}

	@TransactionAttribute( MANDATORY )
	@Override
	public void modifier(Produit produit) {
		em.merge( produit );
	}

	@TransactionAttribute( MANDATORY )
	@Override
	public void supprimer(int idProduit) {
		em.remove( retrouver(idProduit) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Produit retrouver(int idProduit) {
		return em.find( Produit.class, idProduit );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Produit> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Produit p";
		var query = em.createQuery( jpql, Produit.class );
		return query.getResultList();
	}
	
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Produit> listerUtilisateur(int idCompte) {
		em.clear();
		var jpql = "SELECT p FROM Produit p WHERE p.compte = :id";
		var query = em.createQuery( jpql, Produit.class );
		query.setParameter("id", idCompte);
		return query.getResultList();
	}

}
