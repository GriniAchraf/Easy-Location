package dauphine.miageIF.projets.easyLocation.model;


import javax.persistence.*;



@Entity
@DiscriminatorValue("employe")
public class Employe extends Compte {
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "tel")
	private long tel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PL_ID")
	private PointLivraison pointLivraison;
	
	public Employe(String login, String motDePasse, String nom, String prenom, long tel) {
		this.login=login;
        this.motDePasse=motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		}

	public Employe() {
		super();
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

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}


 	public PointLivraison getPointLivraison() {
		return pointLivraison;
		}

	public void setPointLivraison(PointLivraison pointLivraison) {
		this.pointLivraison = pointLivraison;
		}


}
