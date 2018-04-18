package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.Categorie;




public interface CategorieDAO {
	public void addCategorie(Categorie c);
	public List<Categorie> getAllCategories();

}
