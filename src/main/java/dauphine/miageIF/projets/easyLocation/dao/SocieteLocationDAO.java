package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;

public interface SocieteLocationDAO {
	public SocieteLocation getSLByName(String name);
	public List<SocieteLocation> getAllSL();
	public void updateSL(SocieteLocation societeLocation);
	public void addSL(SocieteLocation societeLocation);
	public void removeSL(int idSL);
}
