package dauphine.miageIF.projets.easyLocation.model;


import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;



@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	
	public Admin(String login, String motDePasse){
		  this.login=login;
	        this.motDePasse=motDePasse;
}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
