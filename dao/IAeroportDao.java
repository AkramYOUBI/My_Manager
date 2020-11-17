package dao;

import java.util.List;

import metier.entities.Aeroport;
import metier.entities.Equipement;


public interface IAeroportDao {
	public Aeroport save(Aeroport a); /*ajouter et enregistrer les equipement et retourn l'equip ajouter*/
	public List<Aeroport> aeroports(); /*chercher et affiche une liste d'equipement*/
	public Aeroport update(Aeroport a1, Aeroport a2); /*mise a jours des equipements*/
	public void deleteAeroport(String nomAeroport); /*supp un equipement*/ 
	public Aeroport getAeroport(String NA);
	
	
	
}
