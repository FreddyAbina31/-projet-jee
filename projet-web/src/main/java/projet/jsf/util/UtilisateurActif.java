package projet.jsf.util;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import projet.jsf.data.Utilisateur;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class UtilisateurActif extends Utilisateur {
	
	public boolean isLoggedIn() {
		return getPseudo() != null;
	}	
	
	public boolean isUsager() {
		return isLoggedIn() && (getRole()=="USAGER");
	}
	
	public boolean isGestionnaire() {
		return isLoggedIn() && (getRole()=="GESTIONNAIRE");
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
