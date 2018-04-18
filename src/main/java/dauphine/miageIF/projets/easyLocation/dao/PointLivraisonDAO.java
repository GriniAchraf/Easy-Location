package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.PointLivraison;

public interface PointLivraisonDAO {

	public PointLivraison getPLByID(int idPL);
	public List<PointLivraison> getAllPL();
	public void updatePL(PointLivraison pointLivraison);
	public void addPL(PointLivraison pointLivraison);
	public void removePL(int idPL);
}
