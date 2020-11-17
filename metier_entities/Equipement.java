package metier.entities;

import java.io.Serializable;

public class Equipement implements Serializable{ /*les entitées sont generalement serializable  */
	private String numero_serie;
	private String assets_tag;
	private String node_name;
	private String model;
	private String type;
	private String nom_projet;
	private String nom_aeroport;
	private String id_terminal;
	private String nom_zone;
	private String id_comptoir;
	private String etat;
	private String emplacement;
	private String commentaire;
	
	
	public Equipement(String numero_serie, String assets_tag, String node_name, String model, String type, String nom_projet, String nom_aeroport, String emplacement,
			String id_terminal, String nom_zone, String id_comptoir, String etat, String commentaire) {
		super();
		this.numero_serie = numero_serie;
		this.assets_tag = assets_tag;
		this.node_name= node_name;
		this.model= model;
		this.type = type;
		this.nom_projet = nom_projet;
		this.nom_aeroport = nom_aeroport;
		this.emplacement = emplacement;
		this.id_terminal = id_terminal;
		this.nom_zone = nom_zone;
		this.id_comptoir = id_comptoir;
		this.etat = etat;
		this.emplacement= emplacement;
		this.commentaire= commentaire;
		
	}


	public String getNode_name() {
		return node_name;
	}


	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}


	public void setAssets_tag(String assets_tag) {
		this.assets_tag = assets_tag;
	}


	public String getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getNumero_serie() {
		return numero_serie;
	}


	public String getAssets_tag() {
		return assets_tag;
	}


	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
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
	
	

	public String getEtat() {
		return etat;
	}





	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	





	public Equipement() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "Equipement [numero_serie=" + numero_serie + ", assets_tag=" + assets_tag + ", node_name="+node_name+", model="+model+", type=" + type
				+ ", nom_projet=" + nom_projet + ", nom_aeroport=" + nom_aeroport + ", emplacement=" + emplacement + ", id_terminal=" + id_terminal
				+ ", nom_zone=" + nom_zone + ", id_comptoir=" + id_comptoir + ", etat=" + etat + ", commentaire=" + commentaire + "]";
	}


	

}
