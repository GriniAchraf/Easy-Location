package dauphine.miageIF.projets.easyLocation.model;


import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.*;



@Entity
@DiscriminatorValue("client")
public class Client extends Compte {

	

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", tel=" + tel
				+ ", adresse=" + adresse + ", listereservation="
				+ listereservation + ", login=" + login + ", motDePasse="
				+ motDePasse + "]";
	}

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "telephone")
	private String tel;

	@Column(name = "adresse")
	private String adresse;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "client")
	private List <Reservation> listereservation;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLIENT_PRODUIT", joinColumns = { @JoinColumn(name = "COMPTE_ID") }, inverseJoinColumns = { @JoinColumn(name = "OBJ_ID") })
	private List <Produit> listePanier;

	public Client() {
		super();
	}

	public Client(String login, String motDePasse, String nom, String prenom,
			String tel, String adresse/* , List<Reservation> listeRserv */) {
        this.login=login;
        this.motDePasse=motDePasse;
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.listereservation=new ArrayList<Reservation>();
		// this.listeRserv = listeRserv;
	}

	

	

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void addToPanier(Produit produit) {
		this.listePanier.add(produit);
	}
	
	public List<Produit> getPanier() {
		return this.listePanier;
	}

	public void supprimCompte() {
	}

	
	public int getNbrRsrv() {
		return 0;
	}

	public int getNbrLoc() {
		return 0;
	}
	
	public JsonObject clientToJson(){
		//client
		JsonObject js=Json.createObjectBuilder()
			.add("nom", this.getNom())
			.add("prenom", this.getPrenom())
			.add("tel", this.getTel())
			.add("adresse", this.getAdresse())
			.build();
		return js;
	}
	
	public JsonObject panierToJson() {
		JsonArrayBuilder arrayBuilder	= Json.createArrayBuilder();
		for(Produit p : this.getPanier()){
			arrayBuilder.add(p.produitToJson());
		}
		JsonObject js=Json.createObjectBuilder().add("Panier", arrayBuilder).build();
		return js;
	}
}
