package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Aeroport;

public class Aeromodel {
	
	
private String nomAeroport;
	
private List<Aeroport> aeroports=new ArrayList<Aeroport>();

public String getNomAeroport() {
	return nomAeroport;
}
public void setNomAeroport(String nomAeroport) {
	this.nomAeroport = nomAeroport;
}
public List<Aeroport> getAeroports() {
	return aeroports;
}
public void setAeroports(List<Aeroport> aeroports) {
	this.aeroports = aeroports;
}
}
