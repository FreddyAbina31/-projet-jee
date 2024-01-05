package projet.jsf.model.standard;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoUtilisateur;
import projet.commun.service.IServiceConnexion;
import projet.jsf.data.Utilisateur;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilisateurActif;
import projet.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Utilisateur			courant;

	@Inject
	private UtilisateurActif		compteActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;
	@Inject
	private IMapper				mapper;


	// Getters 
	
	public Utilisateur getCourant() {
		if ( courant == null ) {
			courant = new Utilisateur();
		}
		return courant;
	}

	
	// Actons
	
	public String connect() {
	    
	    DtoUtilisateur dto = serviceConnexion.sessionUtilisateurOuvrir( courant.getPseudo(), courant.getMotdepasse() );
	    
	    if ( dto != null ){
	    	
//		    try {
//			    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//				( (HttpServletRequest) ec.getRequest() ).login( courant.getPseudo(), courant.getMotDePasse() );
//			} catch (ServletException e) {
//				throw new RuntimeException( e );
//			}

	        mapper.update(compteActif, mapper.map(dto) );
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + compteActif.getPseudo() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	    	return null;
	    }
	}	
}
