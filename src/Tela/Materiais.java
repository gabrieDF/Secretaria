package Tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Materiais extends JFrame {
	

	
	
	JPanel contentPane;
	JTextField id, nome, img, status;
	JButton adicionar, voltar;
	JComboBox disciplina, categoria;
	private String[] materias= {"programação", "DS", "Ling. programação","etica", "religiao"};
	private String[] opcoes= {"eletronicos", "manuais"};	
	JLabel logo, n, d, s;
	
	
	public Materiais() {
		Componentes();
		Eventos();
	}
	
	
	public void Componentes() {
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		contentPane.setLayout(null);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon("images//imag.png"));
		logo.setBounds(750, 0, 170, 170);
		contentPane.add(logo);
		
		nome = new JTextField();
		nome.setHorizontalAlignment(SwingConstants.LEADING);
		nome.setBounds(280, 180, 400, 50);
		nome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(nome);
		
		n = new JLabel("Nome do Objeto: ");
		n.setHorizontalAlignment(SwingConstants.CENTER);
		n.setFont(new Font("Times New Roman", Font.BOLD, 20));
		n.setBounds(100, 180, 180, 50);
		contentPane.add(n);
		
		status = new JTextField();
		status.setHorizontalAlignment(SwingConstants.LEADING);
		status.setBounds(280, 320, 400, 50);
		status.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(status);
		
		s = new JLabel("Status do Objeto: ");
		s.setHorizontalAlignment(SwingConstants.CENTER);
		s.setFont(new Font("Times New Roman", Font.BOLD, 20));
		s.setBounds(100, 320, 180, 50);
		contentPane.add(s);
		
		
		disciplina = new JComboBox(opcoes);
		disciplina.setBounds(280, 250, 400, 50);
		disciplina.setBackground(Color.BLACK);
		disciplina.setForeground(Color.WHITE);
		disciplina.setFont(new Font("", Font.BOLD,20));
		contentPane.add(disciplina);
		
		d = new JLabel("Categoria: ");
		d.setHorizontalAlignment(SwingConstants.CENTER);
		d.setFont(new Font("Times New Roman", Font.BOLD, 20));
		d.setBounds(160, 250, 100, 50);
		contentPane.add(d);
		
		
		adicionar = new JButton("Adicionar");
		adicionar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		adicionar.setBounds(350, 400, 280, 50);
		contentPane.add(adicionar);
		
		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						 new Inicio().setVisible(true);
						 dispose();
						 
					 }
				 });
			
		
		voltar.setBackground(Color.BLACK);
		voltar.setForeground(Color.WHITE);
		voltar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		voltar.setBounds(20, 10, 90, 50);
		contentPane.add(voltar);
		
		add(contentPane);
	
	}
	
public void Eventos() {
	
	adicionar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(nome.getText().equals("")) {
				JOptionPane.showMessageDialog(null,  "o campo nome deve ser preenchido", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(status.getText().equals("")) {
				JOptionPane.showMessageDialog(null,  "o campo status deve ser preenchido", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Material adicionado :) ");
			
			}
		}
		
	});
	
		try {
			Connection con;
			Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql//localhost:3306/Materials_security", "root", "");
			st = con.createStatement();
			String sql = ("insert into materiais values('" +nome.getText() +"', '" +status.getText()+"')");
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Cadastro realizado");
			nome.setText("");
			status.setText("");
			nome.requestFocus();
		}catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Driver de conexao nao encontrado");
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na conexao com Banco de Dados");
			
		}
	}
		

		
	

	public static void main(String Args[]) {
		JFrame frame = new Materiais();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1280, 720);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
	}

}


	
