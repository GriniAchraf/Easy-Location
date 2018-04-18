package dauphine.miageIF.projets.easyLocation.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "RSRV_ID")
	private String idReserv;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOC_ID")
	private Location location;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OBJ_ID")
	private Produit produit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPTE_ID")
	private Client client;
	
	@Column(name = "DUREE_LOC")
	private int dureeLocation;
	
	@Column(name = "DATE_RSRV")
	private Date dateRsrv;
	
	@Column(name = "DATE_LIM_RETOUR")
	private Date dateLimiteRetour;

	public Reservation(int dureeLocation, Date dateLimiteRetour, Date dateRsrv) {
		super();
		this.dureeLocation = dureeLocation;
		this.dateLimiteRetour = dateLimiteRetour;
		this.dateRsrv = dateRsrv;
	}
	
	public void location() {
	}

	public String getIdReserv() {
		return idReserv;
	}
	
	public void setIdReserv(String idReserv) {
		this.idReserv = idReserv;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Produit getProduit() {
		return produit;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public int getDureeLocation() {
		return dureeLocation;
	}
	
	public void setDureeLocation(int dureeLocation) {
		this.dureeLocation = dureeLocation;
	}
	
	public Date getDateLimiteRetour() {
		return dateLimiteRetour;
	}
	
	public void setDateLimiteRetour(Date dateLimiteRetour) {
		this.dateLimiteRetour = dateLimiteRetour;
	}

	public Date getDateRsrv() {
		return dateRsrv;
	}

	public void setDateRsrv(Date dateRsrv) {
		this.dateRsrv = dateRsrv;
	}
	
	

}
