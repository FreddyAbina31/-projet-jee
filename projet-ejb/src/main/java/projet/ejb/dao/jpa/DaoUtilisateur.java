package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUtilisateur implements IDaoUtilisateur {

	// Champs

	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.flush();
		return utilisateur.getId();
	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public void supprimer(int idUtilisateur) {
		em.remove(retrouver(idUtilisateur));
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur retrouver(int idUtilisateur) {
		return em.find(Utilisateur.class, idUtilisateur);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Utilisateur> listerTout() {
		em.clear();
		var jpql = "SELECT u FROM Utilisateur u ORDER BY u.pseudo";
		var query = em.createQuery(jpql, Utilisateur.class);
		return query.getResultList();
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur validerAuthentification(String pseudo, String motDePasse) {
		var jpql = "SELECT u FROM Utilisateur u WHERE u.pseudo=:pseudo AND u.motDePasse = :motDePasse ";
		var query = em.createQuery(jpql, Utilisateur.class);
		query.setParameter("pseudo", pseudo);
		query.setParameter("motDePasse", motDePasse);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitePseudo(String pseudo, int idUtilisateur) {
		var jpql = "SELECT COUNT(u) FROM Utilisateur u WHERE u.pseudo=:pseudo AND u.id <> :idUtilisateur ";
		var query = em.createQuery(jpql, Long.class);
		query.setParameter("pseudo", pseudo);
		query.setParameter("idUtilisateur", idUtilisateur);
		return query.getSingleResult() == 0;
	}

}
