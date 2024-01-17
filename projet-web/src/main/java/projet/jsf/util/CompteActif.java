package projet.jsf.util;

import static projet.commun.dto.Roles.GESTIONNAIRE;
import static projet.commun.dto.Roles.USAGER;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import projet.jsf.data.Compte;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class CompteActif extends Compte {
	
	public boolean isLoggedIn() {
		return getPseudo() != null;
	}	
	
	public boolean isUsager() {
		return isLoggedIn() && isInRole( USAGER );
	}
	
	public boolean isGestionnaire() {
		return isLoggedIn() && isInRole( GESTIONNAIRE );
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
