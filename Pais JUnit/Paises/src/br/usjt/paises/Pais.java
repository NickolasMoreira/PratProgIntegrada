package br.usjt.paises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.*;

public class Pais {
	
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais(int id, String nome, long populacao, double area) {
		
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
		
	}
 

	
	//       MÉTODOS DAO       //
	
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
	
	// MÉTODO CREATE //	
	
	public void criar() {
		String sqlInsert = "INSERT INTO paises.pais(nome,populacao, area) VALUES(?,?,?)";

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()"; // What is it?

			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); // What is it?
					ResultSet rs = stm2.executeQuery();) { // What is it?
				if (rs.next()) {
					setId(rs.getInt(1));
				}
			} catch (SQLException e) { // What is it?
				e.printStackTrace(); // What is it?
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// MÉTODO READ // 
	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area From paises.pais WHERE id = ?";
		

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(0);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
	}

	// MÉTODO UPDATE //

	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// MÉTODO DELETE // 

	public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id=?";

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// MINOR AREA //

	public void menorArea() {
		String sqlMenor = "SELECT  nome, area FROM pais WHERE area = (select MIN(area) FROM pais)";

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMenor);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setArea(rs.getDouble("area"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
	}

		// LARGEST POPULATION //
	public void maiorPopulacao() {
		String sqlMaior = "SELECT  nome, populacao FROM pais WHERE populacao = (select Max(populacao) FROM pais)";

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMaior);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SELECT 3 COUNTRIES //
	public static Pais[] tresPaises() {

		Pais paises = null;
		Pais[] vetor = new Pais[3];
		int i = 0;

		String sqltres = "SELECT * FROM pais LIMIT 3";

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqltres);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String nome = rs.getString("nome");
					Long populacao = rs.getLong("populacao");
					Double area = rs.getDouble("area");

					paises = new Pais(id, nome, populacao, area);
					vetor[i++] = paises;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return vetor;
	}
	
	

	
	//     FIM MÉTODOS DAO    // 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public String toString() {
		return "[id= " + id + ", nome= " + nome + ", populacao= " + populacao + ", area= " + area + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Pais other = (Pais) obj;

		if (area == 0.0) {
			if (other.area != 0.0)
				return false;
		}

		if (populacao == 0) {
			if (other.populacao != 0)
				return false;
		}

		if (id != other.id)
			return false;

		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;

		return true;
	}

}
