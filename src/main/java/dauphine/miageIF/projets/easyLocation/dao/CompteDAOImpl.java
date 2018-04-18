package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;













import dauphine.miageIF.projets.easyLocation.model.Admin;
import dauphine.miageIF.projets.easyLocation.model.Client;
import dauphine.miageIF.projets.easyLocation.model.Compte;
import dauphine.miageIF.projets.easyLocation.model.Employe;
import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;

public class CompteDAOImpl implements CompteDAO{
	
	Session session;
	public CompteDAOImpl(){
		
	}

	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	    session.close();

	    
	   
	}

	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Compte d=(Compte) session.get(Compte.class,c.getIdCompte());
		d.setLogin(c.getLogin());
		d.setMotDePasse(c.getMotDePasse());
		session.getTransaction().commit();
	    session.close();
	}

	@Override
	public Compte getCompteByEmail(String email) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM Compte C WHERE C.login = :login ";
		
		@SuppressWarnings("deprecation")
		List<Compte> liste=session.createQuery(hql).setParameter("login", email).list();
		if(liste.size()!=0)
		 return (Compte)liste.get(0);
		session.close();
		return null;
	}

	@Override
	public void removeCompte(String idCompte) {
		// TODO Auto-generated method stub
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Compte c=(Compte) session.get(Compte.class,idCompte);
		session.delete(c);
		session.getTransaction().commit();
	    session.close();
	}
	public List<Compte> getAll(Object o){
		
		String hql="from Compte where compte_type=";
		if(o.equals(Client.class))
			hql+="'client'";
		if(o.equals(Admin.class))
			hql+="'admin'";
		if(o.equals(Employe.class))
			hql+="'employe'";
		
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Compte> comptes = session.createQuery(hql).list();
		session.close();
		return comptes;
			
	}
	@Override
    protected void finalize() throws Throwable {
        try{
            HibernateUtils.shutdown();
            //release resources, perform cleanup ;
        }catch(Throwable t){
            throw t;
        }finally{
            System.out.println("Calling finalize of Super Class");
            super.finalize();
        }
      
    }



}
