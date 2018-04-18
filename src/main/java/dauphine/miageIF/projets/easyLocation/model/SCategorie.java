package dauphine.miageIF.projets.easyLocation.model;


import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class SCategorie {

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "SCAT_ID")
	   private long id;

	@Column(name = "NAME", nullable = false, unique = true)
	   private String name;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "scategorie")
	   private List<Produit> produits = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAT_ID")
	private Categorie categorie;

	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SCategorie() {
		super();
	}

public void addProduit(Produit p){
	produits.add(p);
	p.setSC(this);
}
	public SCategorie(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Categorie getC() {
		return categorie;
	}


	public void setC(Categorie c) {
		this.categorie = c;
	}
	
	public JsonObject SCategorieToJson(){
		
		//la liste des produits
		JsonArrayBuilder arrayBuilder	= Json.createArrayBuilder();
		for(Produit pr : this.getProduits()){
			arrayBuilder.add(pr.produitToJson());
		}
		

		//SC
		JsonObject js=Json.createObjectBuilder()
			.add("Nom", this.getName())
			.add("Liste des produits", arrayBuilder)
			.build();
		return js;
	}
	
	
}
