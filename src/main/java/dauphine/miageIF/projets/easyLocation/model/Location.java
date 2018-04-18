package dauphine.miageIF.projets.easyLocation.model;


import java.sql.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Location {
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "LOC_ID")
	private String idLocation;
	
	@Column(name = "DUREE_EFF")
	private int dureeEffective;
	
	@Column(name = "DATE_RETOUR_EFF")
	private Date dateRetourEffective;
	
	@Column(name = "AMENDE_DEGR")
	private int amendeDegr;
	
	@Column(name = "PRIX_TOTAL")
	private int prixTotal;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "location")
	private Reservation reservation;

	public Location(int dureeEffective, Date dateRetourEffective, int amendeDegr, int prixTotal) {
		
		this.dureeEffective = dureeEffective;
		this.dateRetourEffective = dateRetourEffective;
		this.amendeDegr = amendeDegr;
		this.prixTotal = prixTotal;
		}

	public String getIdLocation() {
		return idLocation;
	}
	
	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
	}
	
	public int getDureeEffective() {
		return dureeEffective;
	}
	
	public void setDureeEffective(int dureeEffective) {
		this.dureeEffective = dureeEffective;
	}
	
	public Date getDateRetourEffective() {
		return dateRetourEffective;
	}
	
	public void setDateRetourEffective(Date dateRetourEffective) {
		this.dateRetourEffective = dateRetourEffective;
	}
	
	public int getAmendeDegr() {
		return amendeDegr;
	}
	
	public void setAmendeDegr(int amendeDegr) {
		this.amendeDegr = amendeDegr;
	}
	
	public int getPrixTotal() {
		return prixTotal;
	}
	
	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}
	
	public JsonObject locationToJson(){
		JsonObject js=Json.createObjectBuilder()
			.add("Duree effective", this.getDureeEffective())
			.add("la date de retour effective", this.getDateRetourEffective().toString())
			.add("amende de degradation", this.getAmendeDegr())
			.add("le prix total", this.getPrixTotal())
			.build();
		return js;
	}

}
