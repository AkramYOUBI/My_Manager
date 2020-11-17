package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Projet;

public class Projetmodel {
	
private String nomProjet;
	
private List<Projet> projets=new ArrayList<Projet>();

public String getNomProjet() {
	return nomProjet;
}
public void setNomProjet(String nomProjet) {
	this.nomProjet = nomProjet;
}
public List<Projet> getProjets() {
	return projets;
}
public void setProjets(List<Projet> projets) {
	this.projets = projets;
}
}
