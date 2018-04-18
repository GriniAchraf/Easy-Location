package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;

public class SocieteLocationDAOImpl implements SocieteLocationDAO{

	Session session;

	public SocieteLocation getSLByName(String name) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM SocieteLocation S WHERE S.NAME = :name ";	
		@SuppressWarnings("deprecation")
		SocieteLocation sL =  (SocieteLocation) session.createQuery(hql).setParameter("name", name).list().get(0);
		session.close();
		return sL;
	}

	public void updateSL(SocieteLocation societeLocation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		SocieteLocation sL = (SocieteLocation) session.get(SocieteLocation.class, societeLocation.getIdSL());
		sL.setDureeMaxLocation(societeLocation.getDureeMaxLocation());
		sL.setDureeMaxRsrv(societeLocation.getDureeMaxRsrv());
		sL.setDureeMinLocation(societeLocation.getDureeMinLocation());
		sL.setNbreMaxLoc(societeLocation.getNbreMaxLoc());
		sL.setNbreMaxRsrv(societeLocation.getNbreMaxRsrv());
		session.getTransaction().commit();
	    session.close();				
	}

	public void addSL(SocieteLocation societeLocation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(societeLocation);
		session.getTransaction().commit();
	    session.close();			
	}

	@Override
	public void removeSL(int idSL) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		SocieteLocation sL=(SocieteLocation) session.get(SocieteLocation.class, idSL);
		session.delete(sL);
		session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public List<SocieteLocation> getAllSL() {
		String hql="from SocieteLocation";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<SocieteLocation> sLs = session.createQuery(hql).list();
		session.close();
		return sLs;
	}

}
