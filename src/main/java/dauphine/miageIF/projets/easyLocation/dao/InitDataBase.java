package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.Admin;
import dauphine.miageIF.projets.easyLocation.model.Categorie;
import dauphine.miageIF.projets.easyLocation.model.Compte;
import dauphine.miageIF.projets.easyLocation.model.PointLivraison;
import dauphine.miageIF.projets.easyLocation.model.Produit;
import dauphine.miageIF.projets.easyLocation.model.SCategorie;
import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;

public class InitDataBase {

	public InitDataBase() {
		
	}
	public void initAdmin(){
		CompteDAOImpl dao=new CompteDAOImpl();
		List<Compte> admins=dao.getAll(Admin.class);
		if(admins.size()==0)
			dao.addCompte(new Admin("admin","dauphine2018"));
	}
	
	public void initCategories(){
		CategorieDAOImpl dao=new CategorieDAOImpl();
		List<Categorie> categories=dao.getAllCategories();
			
		if(categories.size()==0)
		{
		Categorie c1=new Categorie("VEHICULES");
		SCategorie s1=new SCategorie("Utilitaires");
		SCategorie s2=new SCategorie("Remorque");
		SCategorie s3=new SCategorie("Accessoires Auto");
		SCategorie s4=new SCategorie("Moto et scooter");
		SCategorie s5=new SCategorie("Voitures de luxe");
		c1.addSC(s1);c1.addSC(s2);c1.addSC(s3);c1.addSC(s4);c1.addSC(s5);
		dao.addCategorie(c1);
		
		Categorie c2=new Categorie("BRICO");
		SCategorie s6=new SCategorie("Outils");
		SCategorie s7=new SCategorie("Matériel rénovation");		SCategorie s8=new SCategorie("Jardinage");
		SCategorie s9=new SCategorie("Matériel entretien");
		c2.addSC(s6);c2.addSC(s7);c2.addSC(s8);c2.addSC(s9);
		dao.addCategorie(c2);
		
		Categorie c3=new Categorie("EVENEMENT");
		SCategorie a1=new SCategorie("Location mobilier");
		SCategorie a2=new SCategorie("Location réception");
		SCategorie a3=new SCategorie("Cuisine");
		SCategorie a4=new SCategorie("Animation");
		c3.addSC(a1);c3.addSC(a2);c3.addSC(a3);c3.addSC(a4);
		dao.addCategorie(c3);
		
		Categorie c4=new Categorie("HIGH TECH");
		SCategorie b1=new SCategorie("Photo");
		SCategorie b2=new SCategorie("Informatique");
		SCategorie b3=new SCategorie("Matériel video");
		SCategorie b4=new SCategorie("Matériel audio");
		c4.addSC(b1);c4.addSC(b2);c4.addSC(b3);c4.addSC(b4);
		dao.addCategorie(c4);
		
		Categorie c5=new Categorie("LOISIRS");
		SCategorie d1=new SCategorie("Sport individuel");
		SCategorie d2=new SCategorie("Sport de glisse");
		SCategorie d3=new SCategorie("Vélo");
		SCategorie d4=new SCategorie("Montagne");
		c5.addSC(d1);c5.addSC(d2);c5.addSC(d3);c5.addSC(d4);
		dao.addCategorie(c5);
		
		Categorie c6=new Categorie("LUXE");
		SCategorie f1=new SCategorie("Voiture de luxe");
		SCategorie f2=new SCategorie("Robe de soirée");
		SCategorie f3=new SCategorie("Costume");
		SCategorie f4=new SCategorie("Accessoires");
		c6.addSC(f1);c6.addSC(f2);c6.addSC(f3);c6.addSC(f4);
		dao.addCategorie(c6);
		
		Categorie c7=new Categorie("MAISON");
		SCategorie e1=new SCategorie("Electroménager");
		SCategorie e2=new SCategorie("Matériel médical");
		SCategorie e3=new SCategorie("Mobilier d'intérieur");
		c7.addSC(e1);c7.addSC(e2);c7.addSC(e3);
		dao.addCategorie(c7);
		
		
		Categorie c8=new Categorie("VACANCES");
		SCategorie g1=new SCategorie("Camping-Car");
		SCategorie g2=new SCategorie("Camping");
		SCategorie g3=new SCategorie("Villa");
		SCategorie g4=new SCategorie("Appartement");
		c8.addSC(g1);c8.addSC(g2);c8.addSC(g3);c8.addSC(g4);
		dao.addCategorie(c8);
		}
	}
	
	/*public void initSL() {
		SocieteLocationDAOImpl slDao = new SocieteLocationDAOImpl();
		List<SocieteLocation> sls = slDao.getAllSL();
		if(sls.size()==0)
		{
			SocieteLocation sl=new SocieteLocation("easy location",10, 5, 5, 10, 30);
			PointLivraison pl1 = new PointLivraison("Paris 1");
			Produit pr1=new Produit("Yamaha fzs600 fazer",5,40,2500);
			SCategorieDAOImpl sdao=new SCategorieDAOImpl();
			SCategorie scat=sdao.getSCategorie("Moto et scooter");
		      scat.addProduit(pr1);
		      
			pl1.addToStock(pr1);
			
			
			
			PointLivraison pl2 = new PointLivraison("Paris 7");
			PointLivraison pl3 = new PointLivraison("Paris 8");
			PointLivraison pl4 = new PointLivraison("Paris 10");
			PointLivraison pl5 = new PointLivraison("Paris 16");
			PointLivraison pl6 = new PointLivraison("Saint-Denis 93");
			PointLivraison pl7 = new PointLivraison("Val De Marne 94");
			PointLivraison pl8 = new PointLivraison("Essonne 91");

			
			sl.addPL(pl1); sl.addPL(pl2);
			sl.addPL(pl3); sl.addPL(pl4);
			sl.addPL(pl5); sl.addPL(pl6);
			sl.addPL(pl7); sl.addPL(pl8);
			slDao.addSL(sl);
		}
	}*/

	
		
}
