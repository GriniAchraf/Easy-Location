package dauphine.miageIF.projets.easyLocation.dao;

import dauphine.miageIF.projets.easyLocation.model.Compte;

public interface CompteDAO {
	
	public void addCompte(Compte c);
	public void updateCompte(Compte c);
	public Compte getCompteByEmail(String email);
	public void removeCompte(String idCompte);
}
