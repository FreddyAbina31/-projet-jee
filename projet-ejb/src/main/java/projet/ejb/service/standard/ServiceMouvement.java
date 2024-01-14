package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceMouvement;
import projet.ejb.dao.IDaoMouvement;
import projet.ejb.data.Mouvement;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceMouvement implements IServiceMouvement {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoMouvement daoMouvement;

	// Actions

	@Override
	public int inserer(DtoMouvement dtoMouvement) throws ExceptionValidation {
		verifierValiditeDonnees(dtoMouvement);
		int id = daoMouvement.inserer(mapper.map(dtoMouvement));
		return id;
	}

//	@Override
//	public void modifier(DtoMouvement dtoMouvement) throws ExceptionValidation {
//		verifierValiditeDonnees(dtoMouvement);
//		daoMouvement.modifier(mapper.map(dtoMouvement));
//	}

	@Override
	public void supprimer(int idMouvement) throws ExceptionValidation {
		daoMouvement.supprimer(idMouvement);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoMouvement retrouver(int idUtilisateur) {
		return mapper.map(daoMouvement.retrouver(idUtilisateur));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoMouvement> listerTout() {
		List<DtoMouvement> liste = new ArrayList<>();
		for (Mouvement mouvememnt : daoMouvement.listerTout()) {
			liste.add(mapper.map(mouvememnt));
		}
		return liste;
	}
	
	private void verifierValiditeDonnees(DtoMouvement dtoMouvement) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoMouvement.getLibelle() == null || dtoMouvement.getLibelle().isEmpty()) {
			message.append("\nLibellé absent.");
		}else if(dtoMouvement.getLibelle().length() < 5) {
			message.append("\nLibellé trop court");
		}
		
		if(dtoMouvement.getDateTransaction() ==  null) {
			message.append("\nLa date de transaction est absente.");
		}else if(dtoMouvement.getDateTransaction().after(new Date())) {
			message.append("\nMauvaise date.");
		} 
		
		if(dtoMouvement.getHeureTransaction() == null) {
			message.append("\nL'heure de transaction est absente.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
