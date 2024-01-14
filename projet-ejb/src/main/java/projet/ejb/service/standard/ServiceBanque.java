package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoBanque;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceBanque;
import projet.ejb.dao.IDaoBanque;
import projet.ejb.data.Banque;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceBanque implements IServiceBanque {
	
	// Champs
		@Inject
		private IMapperEjb mapper;
		@Inject
		private IDaoBanque daoBanque;

	@Override
	public int inserer(DtoBanque dtoBanque) throws ExceptionValidation {
		verifierValiditeDonnees(dtoBanque);
		int id = daoBanque.inserer(mapper.map(dtoBanque));
		return id;
	}

	@Override
	public void modifier(DtoBanque dtoBanque) throws ExceptionValidation {
		verifierValiditeDonnees(dtoBanque);
		daoBanque.modifier(mapper.map(dtoBanque));
	}

	@Override
	public void supprimer(int idUtilisateur) throws ExceptionValidation {
		daoBanque.supprimer(idUtilisateur);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoBanque retrouver(int idUtilisateur) {
		return mapper.map(daoBanque.retrouver(idUtilisateur));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoBanque> listerTout() {
		List<DtoBanque> liste = new ArrayList<>();
		for (Banque banque : daoBanque.listerTout()) {
			liste.add(mapper.map(banque));
		}
		return liste;
	}
	
	// Méthodes auxiliaires

		private void verifierValiditeDonnees(DtoBanque dtoBanque) throws ExceptionValidation {

			StringBuilder message = new StringBuilder();

			if (dtoBanque.getNom() == null || dtoBanque.getNom().isEmpty()) {
				message.append("\nLe nom est absent.");
			}

			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}


}
