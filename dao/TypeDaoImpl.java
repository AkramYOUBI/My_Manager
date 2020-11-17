package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Aeroport;
import metier.entities.Ttype;


public class TypeDaoImpl implements ITypeDao {
	

	@Override
	public Ttype save(Ttype t) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO my_manager.type (type) VALUES (?)");
			ps.setString(1, t.getType());
			
			ps.executeUpdate();


			ps.close();
			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Ttype> types() {
		List<Ttype> types = new ArrayList<Ttype>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM type");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {/* objet rela */
				Ttype t = new Ttype();
				t.setType(rs.getString("type"));
				
				types.add(t);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}

	@Override
	public Ttype update(Ttype tN, Ttype tA) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE my_manager.type SET type=? WHERE type=?");
			ps.setString(1, tN.getType());
			ps.setString(2, tA.getType());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return tN;
	}

	@Override
	public void deleteType(String type) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM my_manager.type WHERE type=?");
			ps.setString(1, type);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public Ttype getType(String type) {
		Ttype	t = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM type WHERE type=?");
			ps.setString(1, type);	
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {/* objet rela */
				t = new Ttype(); /* deja déclarer */
				t.setType(rs.getString("type"));
				
			}

		} catch (SQLException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		return t;
	}
	
	
	

	
	}


