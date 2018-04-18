package dauphine.miageIF.projets.easyLocation.model;


import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "OBJ_ID")
	private String idObjet;
	
	@Column(name="TITRE")
	private String titre; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PL")
	private PointLivraison pointLivraison;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCAT_ID")
	private SCategorie scategorie;
	
	@Column(name = "AMENDE_JRN")
	private int amendeJrn;
	
	@Column(name = "PRIX_JRN")
	private int prixJrn;
	
	@Column(name = "CAUTION_LOC")
	private int cautionLocation;
	
	@Column(name = "HISTORISE")
	private boolean historise;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToMany(mappedBy = "listePanier")
	private List<Client> clients;
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "produit")
	private Reservation reservation;
	
	public Produit( String titre,int amendeJrn, int prixJrn, int cautionLocation,String description) {
		super();
		this.titre=titre;
		this.amendeJrn = amendeJrn;
		this.prixJrn = prixJrn;
		this.cautionLocation = cautionLocation;
		this.historise = false;
		this.description=description;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Produit() {
		super();
	}
	
	public String getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(String idObjet) {
		this.idObjet = idObjet;
	}

	public PointLivraison getPL() {
		return pointLivraison;
	}
	
	public void setPL(PointLivraison pointLivraison) {
		this.pointLivraison = pointLivraison;
	}
	
	public int getAmendeJrn() {
		return amendeJrn;
	}
	
	public void setAmendeJrn(int amendeJrn) {
		this.amendeJrn = amendeJrn;
	}
	
	public int getPrixJrn() {
		return prixJrn;
	}
	
	public void setPrixJrn(int prixJrn) {
		this.prixJrn = prixJrn;
	}
	
	public int getCautionLocation() {
		return cautionLocation;
	}
	
	public void setCautionLocation(int cautionLocation) {
		this.cautionLocation = cautionLocation;
	}

	public SCategorie getSC() {
		return scategorie;
	}

	public void setSC(SCategorie scategorie) {
		this.scategorie = scategorie;
	}


	public boolean isHistorise() {
		return historise;
	}

	public void setHistorise(boolean historise) {
		this.historise = historise;
	}
	
	public JsonObject produitToJson(){
		//Produit
		JsonObject js=Json.createObjectBuilder()
				.add("idObjet", this.getIdObjet())
			.add("Titre", this.getTitre())
			.add("amende", this.getAmendeJrn())
			.add("prix", this.getPrixJrn())
			.add("caution", this.getCautionLocation())
			.add("description", this.getDescription())
			.build();
		return js;
	}

}
