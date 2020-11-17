package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Equipement;

public class EquipementDaoImpl implements IEquipementDao {
	

	@Override
	public Equipement save(Equipement e) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO my_manager.equipement (numero_serie, assets_tag, node_name, model, type, nom_projet, nom_aeroport, emplacement, id_terminal, nom_zone, id_comptoir, etat, commentaire) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getNumero_serie());
			ps.setString(2, e.getAssets_tag());
			ps.setString(3, e.getNode_name());
			ps.setString(4, e.getModel());
			ps.setString(5, e.getType());
			ps.setString(6, e.getNom_projet());
			ps.setString(7, e.getNom_aeroport());
			ps.setString(8, e.getEmplacement());
			ps.setString(9, e.getId_terminal());
			ps.setString(10, e.getNom_zone());
			ps.setString(11, e.getId_comptoir());
			ps.setString(12, e.getEtat());
			ps.setString(13, e.getCommentaire());
			ps.executeUpdate();
			/*
			 * PreparedStatement
			 * ps2=connection.prepareStatement("SELECT numero_serie FROM mym.equipement ");
			 * ResultSet rs=ps2.executeQuery(); if(rs.next()) {
			 * e.setNumero_serie(rs.getInt("numero_serie"));
			 * 
			 * } /*pour recuperer le id ou numero serie
			 */
			ps.close();
			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Equipement> equipementsParNS(String ns) {
		List<Equipement> equipements = new ArrayList<Equipement>();
		Connection connection = SingletonConnection.getConnection();
		try { //gerer les exceptions
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM equipement WHERE (numero_serie LIKE ?) OR (assets_tag LIKE ?)");
			ps.setString(1, ns);
			ps.setString(2, ns);
			ResultSet rs = ps.executeQuery();
			//recuperation des resultats de resultset (tableau dans b.d)
			while (rs.next()) {
				Equipement e = new Equipement();
				e.setNumero_serie(rs.getString("numero_serie"));
				e.setAssets_tag(rs.getString("assets_tag"));
				e.setNode_name(rs.getString("node_name"));
				e.setModel(rs.getString("model"));
				e.setType(rs.getString("type"));
				e.setNom_projet(rs.getString("nom_projet"));
				e.setNom_aeroport(rs.getString("nom_aeroport"));
				e.setEmplacement(rs.getString("emplacement"));
				e.setId_terminal(rs.getString("id_terminal"));
				e.setNom_zone(rs.getString("nom_zone"));
				e.setId_comptoir(rs.getString("id_comptoir"));
				e.setEtat(rs.getString("etat"));
				e.setCommentaire(rs.getString("commentaire"));
				equipements.add(e);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipements;
	}

	@Override
	public Equipement getEquipement(String numero_serie) {
		Equipement e = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM equipement WHERE (numero_serie=?) OR (assets_tag=?)");
			ps.setString(1, numero_serie);
			ps.setString(2, numero_serie);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {/* objet rela */
				e = new Equipement(); /* deja déclarer */
				e.setNumero_serie(rs.getString("numero_serie"));
				e.setAssets_tag(rs.getString("assets_tag"));
				e.setNode_name(rs.getString("node_name"));
				e.setModel(rs.getString("model"));
				e.setType(rs.getString("type"));
				e.setNom_projet(rs.getString("nom_projet"));
				e.setNom_aeroport(rs.getString("nom_aeroport"));
				e.setEmplacement(rs.getString("emplacement"));
				e.setId_terminal(rs.getString("id_terminal"));
				e.setNom_zone(rs.getString("nom_zone"));
				e.setId_comptoir(rs.getString("id_comptoir"));
				e.setEtat(rs.getString("etat"));
				e.setCommentaire(rs.getString("commentaire"));
			}

		} catch (SQLException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		return e;

	}

	@Override
	public Equipement update(Equipement e) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE my_manager.equipement SET assets_tag=?, node_name=?, model=?, type=?, nom_projet=?, nom_aeroport=?, emplacement=?, id_terminal=?, nom_zone=?, id_comptoir=?, etat=?, commentaire=? WHERE numero_serie=?");
			ps.setString(1, e.getAssets_tag());
			ps.setString(2, e.getNode_name());
			ps.setString(3, e.getModel());
			ps.setString(4, e.getType());
			ps.setString(5, e.getNom_projet());
			ps.setString(6, e.getNom_aeroport());
			ps.setString(7, e.getEmplacement());
			ps.setString(8, e.getId_terminal());
			ps.setString(9, e.getNom_zone());
			ps.setString(10, e.getId_comptoir());
			ps.setString(11, e.getEtat());
			ps.setString(12, e.getCommentaire());
			ps.setString(13, e.getNumero_serie());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public void deleteEquipement(String numero_serie) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM my_manager.equipement WHERE numero_serie=?");
			ps.setString(1, numero_serie);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
	@Override
	public List<Equipement> equipementsParRP(String nom_aeroport, String nom_projet, String id_terminal, String nom_zone, String id_comptoir, String model) {
		List<Equipement> equipements = new ArrayList<Equipement>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM equipement WHERE (nom_aeroport LIKE ? OR ? = \"\") and (nom_projet LIKE ? OR ? = \"\") and (id_terminal LIKE ? OR ? = \"\") and (nom_zone LIKE ? OR ? = \"\") and (id_comptoir LIKE ? OR ? = \"\") and (model LIKE ? OR ? = \"\")");
			System.out.println(""+nom_aeroport);
			ps.setString(1, nom_aeroport);
			ps.setString(2, nom_aeroport);
			ps.setString(3, nom_projet);
			ps.setString(4, nom_projet);
			ps.setString(5, id_terminal);
			ps.setString(6, id_terminal);
			ps.setString(7, nom_zone);
			ps.setString(8, nom_zone);
			ps.setString(9, id_comptoir);
			ps.setString(10, id_comptoir);
			ps.setString(11, model);
			ps.setString(12, model);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {/* objet rela */
				Equipement e = new Equipement();
				e.setNumero_serie(rs.getString("numero_serie"));
				e.setAssets_tag(rs.getString("assets_tag"));
				e.setNode_name(rs.getString("node_name"));
				e.setModel(rs.getString("model"));
				e.setType(rs.getString("type"));
				e.setNom_projet(rs.getString("nom_projet"));
				e.setNom_aeroport(rs.getString("nom_aeroport"));
				e.setEmplacement(rs.getString("emplacement"));
				e.setId_terminal(rs.getString("id_terminal"));
				e.setNom_zone(rs.getString("nom_zone"));
				e.setId_comptoir(rs.getString("id_comptoir"));
				e.setEtat(rs.getString("etat"));
				e.setCommentaire(rs.getString("commentaire"));
				equipements.add(e);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipements;
	}
	
	
	@Override
	public Equipement getEquipementRP(String nom_aeroport, String nom_projet, String id_terminal, String nom_zone, String id_comptoir, String model) {
		Equipement e = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM equipement WHERE (nom_aeroport LIKE ?) OR (nom_projet LIKE ?) OR (id_terminal LIKE ?) OR (nom_zone LIKE ?) OR (id_comptoir LIKE ?) OR (model LIKE ?)");
			ps.setString(1, nom_aeroport);
			ps.setString(2, nom_projet);
			ps.setString(3, id_terminal);
			ps.setString(4, nom_zone);
			ps.setString(5, id_comptoir);
			ps.setString(6, model);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {/* objet rela */
				e = new Equipement(); /* deja déclarer */
				e.setNumero_serie(rs.getString("numero_serie"));
				e.setAssets_tag(rs.getString("assets_tag"));
				e.setNode_name(rs.getString("node_name"));
				e.setModel(rs.getString("model"));
				e.setType(rs.getString("type"));
				e.setNom_projet(rs.getString("nom_projet"));
				e.setNom_aeroport(rs.getString("nom_aeroport"));
				e.setEmplacement(rs.getString("emplacement"));
				e.setId_terminal(rs.getString("id_terminal"));
				e.setNom_zone(rs.getString("nom_zone"));
				e.setId_comptoir(rs.getString("id_comptoir"));
				e.setEtat(rs.getString("etat"));
				e.setCommentaire(rs.getString("commentaire"));
			}

		} catch (SQLException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		return e;

	}

	
	}


