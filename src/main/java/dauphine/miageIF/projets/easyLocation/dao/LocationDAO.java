package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.Location;


public interface LocationDAO {
	public void addLocation(Location l);
	public Location getLocationByID(int idLocation);
	public void updateLocation(Location l);
	public List<Location> getAllLocations();
	public void removeLocation(int idLocation);
}
