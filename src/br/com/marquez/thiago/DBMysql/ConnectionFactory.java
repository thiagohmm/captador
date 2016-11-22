package br.com.marquez.thiago.DBMysql;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	/**
	 *
	 * @author Thiagohmm
	 */
	public class ConnectionFactory {
	  public Connection getConnection() {
			try {
				 DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
				return DriverManager.getConnection("jdbc:mysql://localhost/capcli",
						"root", "");

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	    
//		public static void main(String[] args) throws SQLException {
//			Connection connection = new ConnectionFactory().getConnection();
//			System.out.println("Conexão Aberta");
//			connection.close();
//
//		}
//	}
//	

	}	  

