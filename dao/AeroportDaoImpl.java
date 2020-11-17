package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Aeroport;
import metier.entities.Equipement;


public class AeroportDaoImpl implements IAeroportDao {
	

	@Override
	public Aeroport save(Aeroport a) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO my_manager.aeroport(nomAeroport) VALUES (?)");
			ps.setString(1, a.getNomAeroport());
			
			ps.executeUpdate();


			ps.close();
			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Aeroport> aeroports() {
		List<Aeroport> aeroports = new ArrayList<Aeroport>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM aeroport");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {/* objet rela */
				Aeroport a = new Aeroport();
				a.setNomAeroport(rs.getString("nomAeroport"));
				
				aeroports.add(a);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aeroports;
	}

	@Override
	public Aeroport update(Aeroport aN, Aeroport aA) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE my_manager.aeroport SET nomAeroport=? WHERE nomAeroport=?");
			ps.setString(1, aN.getNomAeroport());
			ps.setString(2, aA.getNomAeroport());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return aN;
	}

	@Override
	public void deleteAeroport(String nomAeroport) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM my_manager.aeroport WHERE nomAeroport=?");
			ps.setString(1, nomAeroport);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public Aeroport getAeroport(String nomAeroport) {
		Aeroport	a = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM aeroport WHERE nomAeroport=?");
			ps.setString(1, nomAeroport);	
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {/* objet rela */
				a = new Aeroport(); /* deja déclarer */
				a.setNomAeroport(rs.getString("nomAeroport"));
				
			}

		} catch (SQLException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		return a;

	}
	
	
	

	
	}


