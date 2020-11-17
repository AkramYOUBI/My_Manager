package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Aeroport;
import metier.entities.Projet;


public class ProjetDaoImpl implements IProjetDao {
	

	@Override
	public Projet save(Projet p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO my_manager.projet (nomProjet) VALUES (?)");
			ps.setString(1, p.getNomProjet());
			
			ps.executeUpdate();


			ps.close();
			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Projet> projets() {
		List<Projet> projets = new ArrayList<Projet>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM projet");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {/* objet rela */
				Projet p = new Projet();
				p.setNomProjet(rs.getString("nomProjet"));
				
				projets.add(p);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projets;
	}

	@Override
	public Projet update(Projet pN, Projet pA) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE my_manager.projet SET nomProjet=? WHERE nomProjet=?");
			ps.setString(1, pN.getNomProjet());
			ps.setString(2, pA.getNomProjet());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pN;
	}

	@Override
	public void deleteProjet(String nomProjet) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM my_manager.projet WHERE nomProjet=?");
			ps.setString(1, nomProjet);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public Projet getProjet(String nomProjet) {
		Projet	p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM projet WHERE nomProjet=?");
			ps.setString(1, nomProjet);	
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {/* objet rela */
				p = new Projet(); /* deja déclarer */
				p.setNomProjet(rs.getString("nomProjet"));
				
			}

		} catch (SQLException p1) {
			// TODO Auto-generated catch block
			p1.printStackTrace();
		}
		return p;

	}}


