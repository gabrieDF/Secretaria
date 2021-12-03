package Tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class insercao extends JFrame {
	
	JPanel contentPane;
	JTextField campo;
	JButton adicionar, objeto, pessoa;
	JLabel logo, titulo,p,o;
	
	
	public insercao() {
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
		
		titulo = new JLabel("ADICIONAR");
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(300,10, 300,200);
		contentPane.add(titulo);
		
		objeto = new JButton();
		objeto.setIcon(new ImageIcon("images//chaave.png"));
		objeto.setBounds(200,250,150,150);
		contentPane.add(objeto);
		
		pessoa = new JButton();
		pessoa.setIcon(new ImageIcon("images//pessooa.png"));
		pessoa.setBounds(500,250,150,150);
		contentPane.add(pessoa);
		
		p = new JLabel("Pessoas");
		p.setFont(new Font("Times New Roman", Font.BOLD, 20));
		p.setHorizontalAlignment(SwingConstants.CENTER);
		p.setBounds(500, 180, 100, 100);
		contentPane.add(p);
		
		o = new JLabel("Objetos");
		o.setFont(new Font("Times New Roman", Font.BOLD, 20));
		o.setHorizontalAlignment(SwingConstants.CENTER);
		o.setBounds(200, 180, 100, 100);
		contentPane.add(o);
		
		add(contentPane);
		
		
		
		
	}
	
	public void Eventos() {
		 pessoa.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 new Adicionar().setVisible(true);
				 dispose();
				 
			 }
		 });
		 
		 objeto.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 new Materiais().setVisible(true);
				 dispose();
				 
			 }
		 });
		
	}
	
	public static void main(String Args[]) {
		JFrame frame = new insercao();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 900, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
	}

}
