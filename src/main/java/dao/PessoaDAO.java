package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.PgConnection;
import model.Pessoa;

public class PessoaDAO implements CRUD {
	
	private static Connection connection = PgConnection.createConnection();
	private static String sql;
	
	public static void create(Pessoa pessoa) {
		 sql = "INSERT INTO prv_pessoa VALUES (default ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 

			 preparedStatement.setString(1, pessoa.getNome());
			 preparedStatement.setString(2, pessoa.getSexo());
			 preparedStatement.setString(3, pessoa.getEmail());
			 preparedStatement.setString(4, pessoa.getCelular());
			 preparedStatement.setString(5, pessoa.getSenha());
			 preparedStatement.setDate(6, pessoa.getData_cadastro());
			 preparedStatement.setString(7, pessoa.getCep());
			 preparedStatement.setString(8, pessoa.getEndereco());
			 preparedStatement.setString(9, pessoa.getBairro());
			 preparedStatement.setString(10, pessoa.getCidade());
			 preparedStatement.setString(11, pessoa.getUf().toUpperCase());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct insert on database");
			  
		 } catch(SQLException e) {
			 System.out.println("--incorrect insert on database. " + e.getMessage());
		 }
	}
	
	public static void delete(int pessoaId) {
		sql = "DELETE FROM prv_pessoa WHERE pes_id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, pessoaId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on usuario");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on pessoa. " + e.getMessage());
		}
	}
	
	public static List<Pessoa> find(String pesquisa){
		
		sql = String.format("SELECT * FROM prv_pessoa WHERE pes_email LIKE '%s%%' "
				, pesquisa, pesquisa, pesquisa, pesquisa);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(resultSet.getInt("pes_id"));
				pessoa.setNome(resultSet.getString("pes_nome"));
				pessoa.setSexo(resultSet.getString("pes_sexo"));
				pessoa.setEmail(resultSet.getString("pes_email"));
				pessoa.setCelular(resultSet.getString("pes_celular"));
				pessoa.setSenha(resultSet.getString("pes_senha"));
				pessoa.setData_cadastro(resultSet.getDate("pes_data_cadastro"));
				pessoa.setCep(resultSet.getString("pes_cep"));
				pessoa.setEndereco(resultSet.getString("pes_endereco"));
				pessoa.setBairro(resultSet.getString("pes_bairro"));
				pessoa.setCidade(resultSet.getString("pes_cidade"));
				pessoa.setUf(resultSet.getString("pes_uf"));
				pessoa.setAdmin(resultSet.getString("pes_admin"));
				
				pessoas.add(pessoa);
			}
			
			System.out.println("--correct find pessoas");
			return pessoas;
			
		} catch(SQLException e) {
			System.out.println("--incorrect find pessoas. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Pessoa findByPk(int pessoaId) {
		sql = String.format("SELECT * FROM prv_pessoa WHERE pes_id = %d ", pessoaId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Pessoa pessoa = new Pessoa();
			
			while (resultSet.next()) {
				pessoa.setId(resultSet.getInt("pes_id"));
				pessoa.setNome(resultSet.getString("pes_nome"));
				pessoa.setSexo(resultSet.getString("pes_sexo"));
				pessoa.setEmail(resultSet.getString("pes_email"));
				pessoa.setCelular(resultSet.getString("pes_celular"));
				pessoa.setSenha(resultSet.getString("pes_senha"));
				pessoa.setData_cadastro(resultSet.getDate("pes_data_cadastro"));
				pessoa.setCep(resultSet.getString("pes_cep"));
				pessoa.setEndereco(resultSet.getString("pes_endereco"));
				pessoa.setBairro(resultSet.getString("pes_bairro"));
				pessoa.setCidade(resultSet.getString("pes_cidade"));
				pessoa.setUf(resultSet.getString("pes_uf"));
			}
			
			System.out.println("--correct find by pk pessoa");
			return pessoa;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk pessoa. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Pessoa pessoa) {
		sql = "UPDATE prv_pessoa SET pes_nome=?, pes_sexo=?, pes_email=?, pes_celular=?, pes_senha=?,"+ 
				" pes_cep=?, pes_endereco=?, pes_bairro=?, pes_cidade=?, pes_uf=? WHERE pes_id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, pessoa.getNome());
			 preparedStatement.setString(2, pessoa.getSexo());
			 preparedStatement.setString(3, pessoa.getEmail());
			 preparedStatement.setString(4, pessoa.getCelular());
			 preparedStatement.setString(5, pessoa.getSenha());
			 preparedStatement.setString(6, pessoa.getCep());
			 preparedStatement.setString(7, pessoa.getEndereco());
			 preparedStatement.setString(8, pessoa.getBairro());
			 preparedStatement.setString(9, pessoa.getCidade());
			 preparedStatement.setString(10, pessoa.getUf().toUpperCase());
			 preparedStatement.setInt(11, pessoa.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
}
