package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.Location;

public class LocationDAOImpl implements LocationDAO {

	Session session;
	
	public void addLocation(Location l) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(l);
		session.getTransaction().commit();
	    session.close();				
	}

	@Override
	public Location getLocationByID(int idLocation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();		
		Location l =  (Location) session.get(Location.class, idLocation);
		session.close();
		return l;
	}

	@Override
	public void updateLocation(Location l) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Location loc = (Location) session.get(Location.class, l.getIdLocation());
		loc.setAmendeDegr(l.getAmendeDegr());
		loc.setDateRetourEffective(l.getDateRetourEffective());
		loc.setDureeEffective(l.getDureeEffective());
		loc.setPrixTotal(l.getPrixTotal());
		session.getTransaction().commit();
	    session.close();		
		
	}

	@Override
	public List<Location> getAllLocations() {
		String hql="from Location";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Location> locations = session.createQuery(hql).list();
		session.close();
		return locations;
	}

	@Override
	public void removeLocation(int idLocation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Location l=(Location) session.get(Location.class, idLocation);
		session.delete(l);
		session.getTransaction().commit();
	    session.close();
		
	}

}
