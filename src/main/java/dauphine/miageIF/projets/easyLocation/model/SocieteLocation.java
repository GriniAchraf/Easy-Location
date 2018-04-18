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
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class SocieteLocation {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID_SL")
	private String idSL;
	
	@Column(name = "NAME")
	private String nameSL;
	
	public SocieteLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "DUREE_MAX_RSRV")
	private int dureeMaxRsrv;
	
	@Column(name = "NBRE_MAX_LOC")
	private int nbreMaxLoc;
	
	@Column(name = "NBRE_MAX_RSRV")
	private int nbreMaxRsrv;
	
	@Column(name = "DUREE_MIN_LOC")
	private int dureeMinLocation;
	
	@Column(name = "DUREE_MAX_LOC")
	private int dureeMaxLocation;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "societeLocation")
	private List<PointLivraison> listePL ;

public SocieteLocation(String name,int dureeMaxRsrv, int nbreMaxLoc, int nbreMaxRsrv, int dureeMinLocation, int dureeMaxLocation) {
		super();
		this.nameSL=name;
		this.dureeMaxRsrv = dureeMaxRsrv;
		this.nbreMaxLoc = nbreMaxLoc;
		this.nbreMaxRsrv = nbreMaxRsrv;
		this.dureeMinLocation = dureeMinLocation;
		this.dureeMaxLocation = dureeMaxLocation;
		this.listePL=new ArrayList<PointLivraison>();
	}
	public String getNameSl() {
		return nameSL;
	}
	
	public int getDureeMaxRsrv() {
		return dureeMaxRsrv;
	}
	public void setDureeMaxRsrv(int dureeMaxRsrv) {
		this.dureeMaxRsrv = dureeMaxRsrv;
	}
	public int getNbreMaxLoc() {
		return nbreMaxLoc;
	}
	public void setNbreMaxLoc(int nbreMaxLoc) {
		this.nbreMaxLoc = nbreMaxLoc;
	}
	public int getNbreMaxRsrv() {
		return nbreMaxRsrv;
	}
	public void setNbreMaxRsrv(int nbreMaxRsrv) {
		this.nbreMaxRsrv = nbreMaxRsrv;
	}
	public int getDureeMinLocation() {
		return dureeMinLocation;
	}
	public void setDureeMinLocation(int dureeMinLocation) {
		this.dureeMinLocation = dureeMinLocation;
	}
	public int getDureeMaxLocation() {
		return dureeMaxLocation;
	}
	public void setDureeMaxLocation(int dureeMaxLocation) {
		this.dureeMaxLocation = dureeMaxLocation;
	}
	public List<PointLivraison> getListePL() {
		return listePL;
	}
	public void addPL(PointLivraison pointLivraison) {
		this.listePL.add(pointLivraison);
		pointLivraison.setSocieteLocation(this);
	}
	public String getIdSL() {
		return idSL;
	}
	public void setIdSL(String idSL) {
		this.idSL = idSL;
	}
	

	public List<Produit> getAllStocks(){
		List<Produit> liste=new ArrayList<Produit>();
		for (PointLivraison pl:this.listePL)
			for(Produit p:pl.getStock())
				liste.add(p);
		return liste;		
	}
	
	public JsonObject societeLocationToJson(){
		//la liste des produits
		JsonArrayBuilder arrayBuilder	= Json.createArrayBuilder();
		for(Produit pr : this.getAllStocks()){
			arrayBuilder.add(pr.produitToJson());
		}
		
		//la liste des points de livraison
		JsonArrayBuilder array	= Json.createArrayBuilder();
		for(PointLivraison pl : this.getListePL()){
			array.add(pl.pointLivraisonToJson());
		}
		// Cat
		JsonObject js=Json.createObjectBuilder()
			.add("nom", this.getNameSl())
			.add("dureeMaxRsrv", this.getDureeMaxLocation())
			.add("nbreMaxLoc",this.getNbreMaxLoc())
			.add("nbreMaxRsrv",this.getNbreMaxRsrv())
			.add("dureeMinLocation",this.getDureeMinLocation())
			.add("dureeMaxLocation",this.getDureeMaxLocation())
			
			.add("liste des produits",arrayBuilder)
			.add("les points de livraison",array)
			.build();
		return js;
	}
	
	public JsonObject produitsToJson() {
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for(Produit pr : this.getAllStocks()){
			arrayBuilder.add(pr.produitToJson());
		}
		JsonObject js=Json.createObjectBuilder().add("Produits", arrayBuilder).build();
		return js;
	}
	
	
}
