package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.PointLivraison;

public class PointLivraisonDAOImpl implements PointLivraisonDAO {

	Session session;

	public PointLivraison getPLByID(int idPL) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();		
		PointLivraison pL =  (PointLivraison) session.get(PointLivraison.class, idPL);
		session.close();
		return pL;
	}

	@Override
	public void updatePL(PointLivraison pointLivraison) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		PointLivraison pL = (PointLivraison) session.get(PointLivraison.class, pointLivraison.getIdPL());
		pL.setIdPL(pointLivraison.getIdPL());
		pL.setSocieteLocation(pointLivraison.getSocieteLocation());
		session.getTransaction().commit();
	    session.close();			
	}

	@Override
	public void addPL(PointLivraison pointLivraison) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pointLivraison);
		session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public void removePL(int idPL) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		PointLivraison pL=(PointLivraison) session.get(PointLivraison.class, idPL);
		session.delete(pL);
		session.getTransaction().commit();
	    session.close();			
	}

	@Override
	public List<PointLivraison> getAllPL() {
		String hql="from PointLivraison";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<PointLivraison> pLs = session.createQuery(hql).list();
		session.close();
		return pLs;
	}

}
