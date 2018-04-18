package dauphine.miageIF.projets.easyLocation.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dauphine.miageIF.projets.easyLocation.dao.CategorieDAOImpl;
import dauphine.miageIF.projets.easyLocation.dao.CompteDAOImpl;
import dauphine.miageIF.projets.easyLocation.dao.InitDataBase;
import dauphine.miageIF.projets.easyLocation.model.Admin;
import dauphine.miageIF.projets.easyLocation.model.Categorie;
import dauphine.miageIF.projets.easyLocation.model.Client;
import dauphine.miageIF.projets.easyLocation.model.Compte;
import dauphine.miageIF.projets.easyLocation.model.Employe;
import dauphine.miageIF.projets.easyLocation.model.Location;
import dauphine.miageIF.projets.easyLocation.model.PointLivraison;
import dauphine.miageIF.projets.easyLocation.model.Produit;
import dauphine.miageIF.projets.easyLocation.model.SCategorie;
import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;

public class Main {

	public static void main(String [] args){
	//Admin a=new Admin("achgrini@gmail.com","123");
	Client cl=new Client("login","motDePasse","nom","preno","1245L","adresse");
	CompteDAOImpl dao=new CompteDAOImpl();
	dao.addCompte(cl);
	/*Employe e=new Employe("login","motDePasse","nom","preno",1245L);
	CompteDAOImpl dao=new CompteDAOImpl();
	Client d=new Client("loginNew","motDePasseNew","nom","preno",1245L,"adresse");
	//dao.addCompte(a);
	dao.addCompte(e);
	dao.addCompte(d);
	//System.out.println(dao.getCompteByEmail("logineNew"));
	/*
	Client d=new Client("loginNew","motDePasseNew","nom","preno",1245L,"adresse");
	d.setIdCompte(c.getIdCompte());
	dao.updateCompte(d);*/
	/*List<Compte> comptes= dao.getAll(Employe.class);
	
	for( Compte p : comptes)
		System.out.println(p.toString());
	*/
	//test la classe produit
	//Produit pr1=new Produit("Yamaha fzs600 fazer",5,40,2500);
	//System.out.println(pr1.produitToJson());
	//test la classe categorie
	Categorie ca=new Categorie("VEHICULES");
	//test la classe client
	System.out.println(cl.clientToJson());
	//test classe location
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	Location lo = new Location(2,sqlDate,5,5);
	System.out.println(lo.locationToJson());
	
	//test classe SCategorie
	SCategorie s1=new SCategorie("Utilitaires");
	SCategorie s2=new SCategorie("Remoque");
	System.out.println(s2.SCategorieToJson());
	ca.addSC(s1);
	ca.addSC(s2);
	System.out.println(ca.categorieToJson());
	//teste les points de livraisons (ajouter getAdresse)
	PointLivraison pl1 = new PointLivraison("Paris 7");
	//pl1.addToStock(pr1);
	System.out.println(pl1.pointLivraisonToJson());
	//teste la societe de location
	SocieteLocation sl=new SocieteLocation("easy location",10, 5, 5, 10, 30);
	sl.addPL(pl1);
	System.out.println(sl.societeLocationToJson());
	
//CategorieDAOImpl dao=new CategorieDAOImpl();
	/*dao.addCategorie(c);
		//InitDataBase db=new InitDataBase();
		//db.initCategories();
		//db.initSL();
		
		//db.initAdmin();
		
		
		/*db.initCategories();*/
		//Admin a=new Admin("achgrini@gmail.com","123");
		/*CompteDAOImpl dao=new CompteDAOImpl();
		//dao.addCompte(a);
		Compte a=dao.getCompteByEmail("achgrini@gmail.com");
		System.out.println(a.getMotDePasse());*/
		//InitDataBase db=new InitDataBase();
		//db.initAdmin();
		//db.initSL();
		//db.initPL();

	}
	
	
	

}
