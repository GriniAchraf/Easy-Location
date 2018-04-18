package dauphine.miageIF.projets.easyLocation.dao;

import dauphine.miageIF.projets.easyLocation.model.Produit;
import java.util.List;

public interface ProduitDAO {
	public void addProduit(Produit p);
	public Produit getProduitByID(String id);
	public void updateProduit(Produit p);
	public List<Produit> getAllProduits();
	public void removeProduit(int idProduit);
	
}
