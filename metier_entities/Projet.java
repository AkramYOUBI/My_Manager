package metier.entities;

import java.io.Serializable;

public class Projet implements Serializable{
private String nomProjet;
	
	
	public Projet(String nomProjet) {
		super();
		this.nomProjet = nomProjet;
}


	public Projet() {
		// TODO Auto-generated constructor stub
	}


	public String getNomProjet() {
		return nomProjet;
	}


	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	
}