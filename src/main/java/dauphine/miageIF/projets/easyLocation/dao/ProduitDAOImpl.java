package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.Produit;

public class ProduitDAOImpl implements ProduitDAO {
	
	Session session;

	@Override
	public void addProduit(Produit p) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public List<Produit> getAllProduits() {
		String hql="from Produit";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Produit> produits = session.createQuery(hql).list();
		session.close();
		return produits;
	}

	@Override
	public Produit getProduitByID(String id) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();		
		Produit p =  (Produit) session.get(Produit.class, id);
		session.close();
		return p;
	}
	
	@Override
	public void updateProduit(Produit p) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Produit pd = (Produit) session.get(Produit.class, p.getIdObjet());
		pd.setPL(p.getPL());
		pd.setSC(p.getSC());
		pd.setPrixJrn(p.getPrixJrn());
		pd.setAmendeJrn(p.getAmendeJrn());
		pd.setCautionLocation(p.getCautionLocation());
		pd.setHistorise(p.isHistorise());
		pd.setDescription(p.getDescription());
		session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public void removeProduit(int idProduit) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Produit p=(Produit) session.get(Produit.class, idProduit);
		session.delete(p);
		session.getTransaction().commit();
	    session.close();
		
	}

}
