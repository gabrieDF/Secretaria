package Tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Salvar {
	
	public static void main(String[] args) {
		try {
			Connection con;
			Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql//localhost:3306/Materials_security", "root", "");
			st = con.createStatement();
			String sql = "insert into materiais values('1', 'chave', 'manual', 'disponivel', 'bom')";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Cadastro realizado");
		}catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Driver de conexao nao encontrado");
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na conexao com Banco de Dados");
			
		}
	}

}
