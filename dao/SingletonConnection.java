package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;
	static { /*1er bloc qui s'execute quand une classe est charger en memoire*/
		try {
			Class.forName("com.mysql.jdbc.Driver");//charger le pilote JDBC
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_manager?autoReconnect=true&useSSL=false","root","AkramYOUBI1997");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return connection; /*retourner l'objet connection creer lors de chargement de la classe en memoire */
	}

}
