package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoEnchere;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEnchere;
import projet.ejb.dao.IDaoEnchere;
import projet.ejb.data.Enchere;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEnchere implements IServiceEnchere {

	// Champs
		@Inject
		private IMapperEjb mapper;
		@Inject
		private IDaoEnchere daoEnchere;

		// Actions

		@Override
		public int inserer(DtoEnchere dtoEnchere) throws ExceptionValidation {
			verifierValiditeDonnees(dtoEnchere);
			int id = daoEnchere.inserer(mapper.map(dtoEnchere));
			return id;
		}

		@Override
		public void modifier(DtoEnchere dtoEnchere) throws ExceptionValidation {
			verifierValiditeDonnees(dtoEnchere);
			daoEnchere.modifier(mapper.map(dtoEnchere));
		}

		@Override
		public void supprimer(int idEnchere) throws ExceptionValidation {
			daoEnchere.supprimer(idEnchere);
		}

		@Override
		@TransactionAttribute(NOT_SUPPORTED)
		public DtoEnchere retrouver(int idEnchere) {
			return mapper.map(daoEnchere.retrouver(idEnchere));
		}

		@Override
		@TransactionAttribute(NOT_SUPPORTED)
		public List<DtoEnchere> listerTout() {
			List<DtoEnchere> liste = new ArrayList<>();
			for (Enchere mouvememnt : daoEnchere.listerTout()) {
				liste.add(mapper.map(mouvememnt));
			}
			return liste;
		}
		
		private void verifierValiditeDonnees(DtoEnchere dtoEnchere) throws ExceptionValidation {

			StringBuilder message = new StringBuilder();

			if (dtoEnchere.getPrix() == null) {
				message.append("\nPrix absent.");
			}
			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}
}
