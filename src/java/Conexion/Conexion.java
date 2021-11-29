package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Fernando oñate
 */
public class Conexion {
    
       public Connection conectar() {
		Connection con = null;		
                
		String usuario = "root";
                
                //modifican el password
                String password = "";
                
		String url = "jdbc:mysql://localhost:3306/db_ejemplojpa?user=" + usuario
				+ "&password=" + password;
		try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
                }catch(ClassNotFoundException e){
                     e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
}