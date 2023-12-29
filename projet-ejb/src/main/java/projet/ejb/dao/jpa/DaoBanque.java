package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoBanque;
import projet.ejb.data.Banque;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoBanque implements IDaoBanque {

	// Champs

	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Banque banque) {
		em.persist(banque);
		em.flush();
		return banque.getId();
	}

	@Override
	public void modifier(Banque banque) {
		em.merge(banque);
	}

	@Override
	public void supprimer(int idBanque) {
		em.remove(retrouver(idBanque));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public Banque retrouver(int idBanque) {
		return em.find(Banque.class, idBanque);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<Banque> listerTout() {
		em.clear();
		var jpql = "SELECT b FROM Banque b ORDER BY b.nom";
		var query = em.createQuery(jpql, Banque.class);
		return query.getResultList();
	}

}
