package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.SCategorie;

public class SCategorieDAOImpl implements SCategorieDAO {

	Session session;

	public void addSCategorie(SCategorie sc) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(sc);
		session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public List<SCategorie> getAllSCategories() {
		String hql="from SCategorie";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<SCategorie> sCategories = session.createQuery(hql).list();
		session.close();
		return sCategories;
	}

	@Override
	public SCategorie getSCategorie(String name) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM SCategorie C WHERE C.name = :name ";
		
		@SuppressWarnings("deprecation")
		SCategorie c = (SCategorie)session.createQuery(hql).setParameter("name", name).list().get(0);
		session.close();
		return c;
	}

	@Override
	public void updateSCategorie(SCategorie sc) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		SCategorie d=(SCategorie) session.get(SCategorie.class,sc.getId());
		d.setProduits(sc.getProduits());
		
		session.getTransaction().commit();
	    session.close();
	}

}
