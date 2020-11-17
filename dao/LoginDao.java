package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginBean;
import metier.entities.User;

public class LoginDao {

    public User validate(LoginBean loginBean) throws ClassNotFoundException {
       
        User util=new User();
        
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/my_manager?useSSL=false", "root", "AkramYOUBI1997");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

          
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()) {
            	util.setUsername(rs.getString("username"));
            	if (rs.getString("fct").equals("admin")) {
            	util.setFct(rs.getString("fct"));
            	
            	}
            	util.setStatus(true);
            }
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return util;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}