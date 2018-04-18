package dauphine.miageIF.projets.easyLocation.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "compte_type")
public abstract class Compte {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "COMPTE_ID")
	protected String idCompte;

	@Column(name = "login")
	protected String login;

	@Column(name = "motDePasse")
	protected String motDePasse;

	

	public String getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(String idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", login=" + login
				+ ", motDePasse=" + motDePasse + "]";
	}
	
	public JsonObject compteToJson(){
		JsonObject js=Json.createObjectBuilder()
			.add("identifiant du compte", this.getIdCompte())
			.add("login", this.getLogin())
			.add("mot de passe", this.getMotDePasse())
			.build();
		return js;
	}
	

}
