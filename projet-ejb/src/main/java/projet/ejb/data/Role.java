package projet.ejb.data;

public enum Role {
	usager("usager"), gestionnaire("gestionnaire");
	
	private String name;
	
	private Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
