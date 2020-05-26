package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Conected!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// Obtem conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/paises?user=root&password=aeradogelo&useSSL=false&useTimezone=true&serverTimezone=UTC");
	}

}
