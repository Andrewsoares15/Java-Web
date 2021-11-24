package br.com.model;
//CONEXÃO COM O BANCO DE DADOS

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // classe que permite que a gente execute comandos sql dentro do java 
import java.sql.ResultSet; // usado para guardar os valores dentro em um objeto
import java.util.ArrayList;

import br.com.connection.ConnectionFactory;

//import br.com.connection.ConnectionFactory;

public class DAO {
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://127.0.0.1:3306/dbagencia?useTimezone=true&serverTimezone=UTC";
//	private String user = "root";
//	private String password = "andrew123";
	// MÉTODO DE CONEXÃO
	private Connection conexao = new ConnectionFactory().recuperarConexao();
//	private Connection conectar() {
//		return conexao;
//	}

	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO contatos (nome,fone,email) VALUES(?,?,?)";
		try {
			PreparedStatement pst = this.conexao.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listar() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try{
			PreparedStatement pst = this.conexao.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo sera realizado enquanto houver contatos
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o array list
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			
			return contatos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	public void selectContato(JavaBeans contato) {
		String select = "select * from contatos where idcon = ?";
		try {
			PreparedStatement pst = this.conexao.prepareStatement(select);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			
		}
			catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			}
		}
	//editar o contato
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?, fone=?, email=? where idcon =?";
		try {
			PreparedStatement pst = this.conexao.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon = ?";
		try {
			PreparedStatement pst = this.conexao.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate(); 
			
			} catch (Exception e) {
			System.out.println(e);
		}
	}
}

