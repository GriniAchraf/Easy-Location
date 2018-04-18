package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.Categorie;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;

public class CategorieDAOImpl implements CategorieDAO{

	Session session;
	
	
	public CategorieDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		 session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
		    session.close();
	}

	@Override
	public List<Categorie> getAllCategories() {
		String hql="from Categorie";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Categorie> categories = session.createQuery(hql).list();
		session.close();
		return categories;
	}

}
