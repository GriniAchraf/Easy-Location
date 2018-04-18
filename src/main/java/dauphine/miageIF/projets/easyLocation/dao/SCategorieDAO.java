package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.SCategorie;

public interface SCategorieDAO {
	public void addSCategorie(SCategorie sc);
	public SCategorie getSCategorie(String name);
	public void updateSCategorie(SCategorie sc);
	public List<SCategorie> getAllSCategories();
}
