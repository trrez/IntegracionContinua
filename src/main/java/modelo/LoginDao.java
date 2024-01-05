package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Conexion;

public class LoginDao {

	public static int validar(String Username, String Password) {
	    Connection con = null;  
	    Conexion cn = new Conexion();

	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String us = "";
	    int valido = 0;
	    String sql = "SELECT * FROM mydb.usuario WHERE Username = ? AND Password = ?";
	    
	    try {
	        con = cn.getConnection();

	        if (con != null) {  
	            ps = con.prepareStatement(sql);
	            ps.setString(1, Username);
	            ps.setString(2, Password);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                us = rs.getString("Username");
	            }

	            if (us.equals(Username)) {  
	                valido = 1;
	            } else {
	                valido = 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  
	    } finally {
	        
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    }

	    return valido;
	}

	}
