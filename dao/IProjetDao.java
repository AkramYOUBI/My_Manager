package dao;

import java.util.List;


import metier.entities.Projet;


public interface IProjetDao {
	public Projet save(Projet p); /*ajouter et enregistrer les equipement et retourn l'equip ajouter*/
	public List<Projet> projets(); /*chercher et affiche une liste d'equipement*/
	public Projet update(Projet p1, Projet p2); /*mise a jours des equipements*/
	public void deleteProjet(String nomProjet); /*supp un equipement*/ 
	public Projet getProjet(String NP);
	
	
}
