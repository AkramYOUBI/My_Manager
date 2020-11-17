package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Equipement;


public class EquipementModel {
	private String numero_serie;
	private String nom_projet;
	private String nom_aeroport;
	private String id_terminal;
	private String nom_zone;
	private String id_comptoir;
	private String model;
	
	private List<Equipement> equipements=new ArrayList<Equipement>();
	public String getNumero_serie() {
		return numero_serie;
	}
	
	private List<Equipement> equipementsRP=new ArrayList<Equipement>();
	
	
	public List<Equipement> getEquipementsRP() {
		return equipementsRP;
	}
	public void setEquipementsRP(List<Equipement> equipementsRP) {
		this.equipementsRP = equipementsRP;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipement(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	public String getNom_projet() {
		return nom_projet;
	}
	public void setNom_projet(String nom_projet) {
		this.nom_projet = nom_projet;
	}
	public String getNom_aeroport() {
		return nom_aeroport;
	}
	public void setNom_aeroport(String nom_aeroport) {
		this.nom_aeroport = nom_aeroport;
	}
	public String getId_terminal() {
		return id_terminal;
	}
	public void setId_terminal(String id_terminal) {
		this.id_terminal = id_terminal;
	}
	public String getNom_zone() {
		return nom_zone;
	}
	public void setNom_zone(String nom_zone) {
		this.nom_zone = nom_zone;
	}
	public String getId_comptoir() {
		return id_comptoir;
	}
	public void setId_comptoir(String id_comptoir) {
		this.id_comptoir = id_comptoir;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	
	
	
	
	
}
