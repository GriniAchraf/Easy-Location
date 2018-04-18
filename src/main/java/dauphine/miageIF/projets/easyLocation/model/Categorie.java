package dauphine.miageIF.projets.easyLocation.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.*;

@Entity
public class Categorie {
	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "CAT_ID")
	   private long id;

	@Column(name = "NAME", nullable = false, unique = true)
	   private String name;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "categorie")
	   private List<SCategorie> scategories = new ArrayList<>();

	public Categorie() {
		super();
	}

	public Categorie(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SCategorie> getScategories() {
		return scategories;
	}
	
	public void addSC(SCategorie s){
		this.scategories.add(s);
		s.setC(this);
	}

	
	public JsonObject categorieToJson(){
		//la liste des sCat
		JsonArrayBuilder arrayBuilder	= Json.createArrayBuilder();
		for(SCategorie sc : this.getScategories()){
			arrayBuilder.add(sc.SCategorieToJson());
		}
		// Cat
		JsonObject js=Json.createObjectBuilder()
			.add("nom", this.getName())
			.add("les sous-cat",arrayBuilder)
			.build();
		return js;
	}
	
	
	
}
