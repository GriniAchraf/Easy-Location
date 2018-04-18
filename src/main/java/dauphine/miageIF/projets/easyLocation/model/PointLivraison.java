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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PointLivraison {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID_PL")
	private String idPL;
	
	@Column(name = "ADRESSE")
	private String adresse;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pointLivraison")
	private List<Produit> stock;

	public PointLivraison() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SL")
	private SocieteLocation societeLocation;

	public PointLivraison(String adresse) {
		this.adresse=adresse;
	    this.stock=new ArrayList<Produit>();
	}

	public String getIdPL() {
		return idPL;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setIdPL(String idPL) {
		this.idPL = idPL;
	}
	
	public List<Produit> getStock() {
		return stock;
	}
	
	public void addToStock(Produit stock) {
		this.stock.add(stock);
		stock.setPL(this);
	}
	
	public SocieteLocation getSocieteLocation() {
		return societeLocation;
	}
	
	public void setSocieteLocation(SocieteLocation societeLocation) {
		this.societeLocation = societeLocation;
	}
	
	public JsonObject pointLivraisonToJson(){
		
		//la liste des produits
		JsonArrayBuilder arrayBuilder	= Json.createArrayBuilder();
		for(Produit pr : this.getStock()){
			arrayBuilder.add(pr.produitToJson());
		}
		

		//SC
		JsonObject js=Json.createObjectBuilder()
			.add("adresse", this.getAdresse())
			.add("Liste des produits", arrayBuilder)
			.build();
		return js;
	}
	
}