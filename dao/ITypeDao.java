package dao;

import java.util.List;

import metier.entities.Aeroport;
import metier.entities.Ttype;


public interface ITypeDao {
	public Ttype save(Ttype a); /*ajouter et enregistrer les equipement et retourn l'equip ajouter*/
	public List<Ttype> types(); /*chercher et affiche une liste d'equipement*/
	public Ttype update(Ttype t1, Ttype t2); /*mise a jours des equipements*/
	public void deleteType(String type); /*supp un equipement*/ 
	public Ttype getType(String TT);
	
	
}
