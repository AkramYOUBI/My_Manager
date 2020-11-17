package metier.entities;

import java.io.Serializable;

public class Aeroport implements Serializable{
private String nomAeroport;
	
	
	public Aeroport(String nomAeroport) {
		super();
		this.nomAeroport = nomAeroport;
}


	public Aeroport() {
		
	}


	public String getNomAeroport() {
		return nomAeroport;
	}


	public void setNomAeroport(String nomAeroport) {
		this.nomAeroport = nomAeroport;
	}
	
}