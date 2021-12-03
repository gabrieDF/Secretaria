package Tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends JFrame{
	

	private int quantidade_itens=6;
	String comando;
	String nome,categoria,status,img,contato;
	int num=0, num_vet[]= new int[quantidade_itens+1];
	
	private Conexao BD = new Conexao();
	private ResultSet resultado, resultado2;
	private PreparedStatement caminho, caminho2;
	
	///////////COMPONENTES GERAIS/////////
	private JButton bt_voltar;
	private JLabel lb_titulo;
	
	///////////PN DE INICIO///////////////
	private JPanel pn_inicio;
	private JLabel lb_fundo;
	private JButton bt_buscar, bt_addi;
	private JComboBox cb_filtragem;
	private String[] acoes= {"Chaves","Câmeras","Projetores","Controles","Apresentador sem fio","Caixas de Som","Materiais Disponíveis","Materiais Ocupados","Professores"};
	////////// FIM DO PN DE INICIO////////////
	
	////////////PN DE AÇÃO///////////////
	private JPanel pn_acao;
	private JCheckBox chb_disponiveis, chb_ocupados;
	private JLabel lb_notresults;
	
	
	/////////////////ITENS///////////////
	private JLabel lb_fundo_itens[] = new JLabel[quantidade_itens+1],lb_titulo_item[] = new JLabel[quantidade_itens+1], lb_disponibilidade[] = new JLabel[quantidade_itens+1], lb_img_item[] = new JLabel[quantidade_itens+1];
	private JButton bt_visualizar[]= new JButton[quantidade_itens+1];
	
	//////////pn de adcionar/////////////////////

	
	/////////////pn mostrar/////////////////////
	private JPanel pn_mostrar;
	private JLabel lb_title, lb_img, lb_status,lb_subtitulo,lb_fundo_mostrar;
	private JButton bt_add, bt_devolver;
	private JComboBox cb_professores;

	
	
	
		
	
	public Inicio() {
		Componentes();
		Eventos();
	}
	
	public void Componentes() {
		
		/////////////////////////// COMPONENTES GERAIS////////////////////////////////
		bt_voltar = new JButton("Voltar");
		bt_voltar.setBounds(10,10,100,40);
		bt_voltar.setForeground(Color.white);
		bt_voltar.setFont(new Font("",Font.BOLD,18));
		bt_voltar.setBackground(Color.BLACK);
		bt_voltar.setVisible(false);
		add(bt_voltar);
		
		lb_titulo = new JLabel("");
		lb_titulo.setBounds(515,15,300,30);
		lb_titulo.setFont(new Font("",Font.BOLD,30));
		lb_titulo.setVisible(false);
		add(lb_titulo);
		
		///////////////////////////PN DE INCIO////////////////////////////////////////
		pn_inicio = new JPanel();
		pn_inicio.setLayout(null);
		pn_inicio.setBounds(0,0,1280,720);
		
		bt_buscar = new JButton("Pesquisar");
		bt_buscar.setBackground(Color.BLACK);
		bt_buscar.setForeground(Color.WHITE);
		bt_buscar.setFont(new Font("",Font.BOLD,25));
		bt_buscar.setBounds(480,500,320,100);
		pn_inicio.add(bt_buscar);
		
		
		cb_filtragem = new JComboBox(acoes);
		cb_filtragem.setBounds(378,312,522,96);
		cb_filtragem.setBackground(Color.BLACK);
		cb_filtragem.setForeground(Color.WHITE);
		cb_filtragem.setFont(new Font("",Font.BOLD,20));
		pn_inicio.add(cb_filtragem);
		

		
		bt_addi = new JButton("ADICIONAR");
		bt_addi.setBackground(Color.BLACK);
		bt_addi.setForeground(Color.WHITE);
		bt_addi.setFont(new Font("",Font.BOLD,17));
		bt_addi.setBounds(1050,610,200,60);
		pn_inicio.add(bt_addi);
		
		lb_fundo = new JLabel(new ImageIcon("images//fundo_white.jpg"));
		lb_fundo.setBounds(0,0,1280,720);
		pn_inicio.add(lb_fundo);
		
		
		getContentPane().add(pn_inicio);
	///////////////////////////FIM DO PN DE INCIO////////////////////////////////////////
		pn_acao = new JPanel();
		pn_acao.setLayout(null);
		pn_acao.setBounds(0,0,1280,720);
		
		chb_ocupados = new JCheckBox("Ocupados");
		chb_ocupados.setBounds(620,65,150,30);
		chb_ocupados.setFont(new Font("", Font.BOLD, 20));
		chb_ocupados.setForeground(Color.RED);
		pn_acao.add(chb_ocupados);
		
		chb_disponiveis = new JCheckBox("Disponiveis");
		chb_disponiveis.setBounds(440,65,140,30);
		chb_disponiveis.setFont(new Font("", Font.BOLD, 20));
		chb_disponiveis.setForeground(Color.GREEN);
		pn_acao.add(chb_disponiveis);
		
		lb_notresults = new JLabel("NENHUM RESULTADO ENCONTRADO");
		lb_notresults.setBounds(200,300,1200,100);
		lb_notresults.setFont(new Font("", Font.BOLD, 50));
		lb_notresults.setForeground(Color.BLACK);
		pn_acao.add(lb_notresults);
		lb_notresults.setVisible(false);
		
		
		int X=40,Y=120, index=0;
		
		
		
			for(int i=0;i<=quantidade_itens;i++) {
				lb_fundo_itens[index] = new JLabel(new ImageIcon("images//fundo_itens.png"));
				lb_fundo_itens[index].setBounds(X,Y,362,431);
				
				
				lb_titulo_item[index] = new JLabel("");
				lb_titulo_item[index].setForeground(Color.BLACK);
				lb_titulo_item[index].setFont(new Font("",Font.BOLD,25));
				lb_titulo_item[index].setBounds(X+100,Y+25,300,30);
				pn_acao.add(lb_titulo_item[index]);

				
				
				lb_img_item[index] = new JLabel();
				lb_img_item[index].setBounds(X+75,Y+100,210,210);
				pn_acao.add(lb_img_item[index]);
				
				
				bt_visualizar[index] = new JButton("Visualizar");
				bt_visualizar[index].setFont(new Font("", Font.BOLD,22));
				bt_visualizar[index].setForeground(Color.BLACK);
				bt_visualizar[index].setBounds(X+67,Y+343,230,60);
				pn_acao.add(bt_visualizar[index]);
				
				lb_disponibilidade[index] = new JLabel("");
				lb_disponibilidade[index].setFont(new Font("", Font.BOLD,22));	
				lb_disponibilidade[index].setBounds(X+125,Y+70,300,30);
				pn_acao.add(lb_disponibilidade[index]);
				pn_acao.add(lb_fundo_itens[index]);
				
				
				
				if(i==0) {
					X=X+410;
					index=index+1;
				}
				else if(i%3==0) {
					X=40;
					Y=Y+450;
					index=index+1;
				}
				else {
					X=X+410;
					index=index+1;
				}
				
			}
			
		
		pn_acao.setVisible(false);
		
		//////////////////////////////////////////////pn_visualizar////////////////////////////////
		pn_mostrar= new JPanel();
		pn_mostrar.setBounds(0,0,1820,720);
		pn_mostrar.setLayout(null);
		
		lb_title = new JLabel("CHAVE | S20"); 
		lb_title.setBounds(350,140,500,30);
		lb_title.setFont(new Font("", Font.BOLD,30));
		pn_mostrar.add(lb_title);
		
		lb_img = new JLabel(new ImageIcon("images//chave20.png"));
		lb_img.setBounds(350,250,230,230);
		pn_mostrar.add(lb_img);
		
		lb_status = new JLabel("Disponivel");
		lb_status.setFont(new Font("", Font.BOLD,30));
		lb_status.setBounds(820,140,500,30);
		pn_mostrar.add(lb_status);
		
		bt_add = new JButton("Atribuir");
		bt_add.setFont(new Font("", Font.BOLD,25));
		bt_add.setBounds(670,420,200,60);
		pn_mostrar.add(bt_add);
		
		bt_devolver = new JButton("Devolver");
		lb_status.setFont(new Font("", Font.BOLD,25));
		pn_mostrar.add(bt_devolver);
		
		cb_professores = new JComboBox(acoes);
		cb_professores.setBounds(600,330,350,50);
		cb_professores.setFont(new Font("", Font.BOLD,25));
		pn_mostrar.add(cb_professores);
		
		lb_subtitulo = new JLabel("Atribuir ao professor");
		lb_subtitulo.setBounds(600,300,350,25);
		lb_subtitulo.setFont(new Font("", Font.BOLD,25));
		pn_mostrar.add(lb_subtitulo);
		
		lb_fundo_mostrar = new JLabel(new ImageIcon("images//fundo_imostrar.png"));
		lb_fundo_mostrar.setBounds(300,100,700,500);
		pn_mostrar.add(lb_fundo_mostrar);
		
		pn_mostrar.setVisible(false);
		
		
		
		
		
	}
	public void Eventos() {
		 bt_buscar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 bt_voltar.setVisible(true);
				 lb_titulo.setVisible(true);
				 
				 if(cb_filtragem.getSelectedIndex()==0) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(515,15,300,30);
					 lb_titulo.setText("CHAVES");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='chaves'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
					 
				 }
				 else if(cb_filtragem.getSelectedIndex()==1) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(515,15,300,30);
					 lb_titulo.setText("CÂMERAS");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='cameras'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==2) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(515,15,300,30);
					 lb_titulo.setText("PROJETORES");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='projetores'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==3) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(515,15,300,30);
					 lb_titulo.setText("CONTROLES");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='controles'";
					 Conecta(comando);					
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==4) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(460,15,320,30);
					 lb_titulo.setText("APRESENTADORES");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='apresentadores'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==5) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(510,15,300,30);
					 lb_titulo.setText("CAIXAS DE SOM");
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE categoria='som'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==6) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(510,15,300,30);
					 lb_titulo.setText("DISPONIVEIS");
					 chb_disponiveis.setVisible(false);
					 chb_ocupados.setVisible(false);
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE status='Disponivel'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==7) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(510,15,300,30);
					 lb_titulo.setText("OCUPADOS");
					 chb_disponiveis.setVisible(false);
					 chb_ocupados.setVisible(false);
					 
					 Apaga();
					 comando="SELECT * FROM materiais WHERE status='Ocupado'";
					 Conecta(comando);
					 ADD();
					 getContentPane().add(pn_acao);
				 }
				 else if(cb_filtragem.getSelectedIndex()==8) {
					 pn_inicio.setVisible(false);
					 pn_acao.setVisible(true);
					 lb_titulo.setBounds(510,15,300,30);
					 lb_titulo.setText("PROFESSORES");
					 chb_disponiveis.setText("Sem POSSE");
					 chb_ocupados.setText("Com POSSE");
					 
					 Apaga();
					 comando="SELECT * FROM professores";
					 Conecta(comando);
					 ADD_professor();
					 getContentPane().add(pn_acao);
				 }
				 
				 
			 }
		 });
		 bt_voltar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 if(pn_mostrar.isVisible()==true) {
					 Apaga();
					 Conecta(comando);
					 lb_titulo.setVisible(true);
					 if(lb_titulo.getText().equals("PROFESSORES")) {
						 ADD_professor();
					 }
					 else {
						 ADD();
					 }
					 pn_mostrar.setVisible(false);
					 pn_acao.setVisible(true);
					 getContentPane().add(pn_acao);
				 }
				 else if(pn_acao.isVisible()) {
					 bt_voltar.setVisible(false);
					 lb_titulo.setVisible(false);
					 Apaga();
					 pn_acao.setVisible(false);
					 
					 if(lb_titulo.getText().equals("OCUPADOS") || lb_titulo.getText().equals("DISPONIVEIS")) {
						 chb_disponiveis.setVisible(true);
						 chb_ocupados.setVisible(true);
					 }
					 else if(lb_titulo.getText().equals("PROFESSORES")) {
						 chb_disponiveis.setText("Disponiveis");
						 chb_ocupados.setText("Ocupados");
						 
					 }
					 
					 
					 pn_inicio.setVisible(true);
					 getContentPane().add(pn_inicio);
				 }
					 
					 
					 
					 
					 
			 }
		 });
		 
		 
		 bt_addi.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 new insercao().setVisible(true);
				 dispose();
			 }
		 });
		 
		 chb_ocupados.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 if(chb_disponiveis.isSelected()==true) {
					 chb_disponiveis.setSelected(false);
				 }
				 
				 if(chb_ocupados.isSelected()!=true) {
					 
					 if(chb_ocupados.getText().equals("Ocupados")){
						 Apaga();
						 Conecta(comando);
						 ADD();
						 
						 
					 }else if(chb_ocupados.getText().equals("Com POSSE")){
						 Apaga();
						 Conecta(comando);
						 ADD_professor();
					 }
					 
					 
				 }else {
					 if(chb_ocupados.getText().equals("Ocupados")){
						 Apaga();
						 Conecta(comando+" && status='Ocupado'");
						 ADD();
						 
						 
					 }else if(chb_ocupados.getText().equals("Com POSSE")){
						 Apaga();
						 Conecta(comando+" WHERE status='Com Posse'");
						 ADD_professor();
						 
					 }
				 }
					 
				
				 
			 }
		 });
		 chb_disponiveis.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(chb_ocupados.isSelected()==true) {
					 chb_ocupados.setSelected(false);
					 }
					 
				if(chb_disponiveis.isSelected()!=true) {
					
					if(chb_disponiveis.getText().equals("Disponiveis")){
						Apaga();
						Conecta(comando);
						ADD();
					}
					else if(chb_disponiveis.getText().equals("Sem POSSE")){
						Apaga();
						Conecta(comando);
						ADD_professor();
					 }
					
				}else {
					if(chb_disponiveis.getText().equals("Disponiveis")){
						Apaga();
						Conecta(comando+" && status='Disponivel'");
						ADD();
					}
					else if(chb_disponiveis.getText().equals("Sem POSSE")){
						Apaga();
						Conecta(comando+" WHERE status='Sem posse'");
						ADD_professor(); 
					 }
				}
					 
				
				 
			 
			 }});
		 
		 for(int i=0;i<=quantidade_itens-1;i++) {
			 
			 System.out.println(num);
			 num_vet[num]=num;
			 System.out.println(num_vet[num]);
			 num=num+1;
			
			 bt_visualizar[i].addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 pn_acao.setVisible(false);
					 lb_titulo.setVisible(false);
					 
					 
					
					 lb_title.setText(lb_titulo_item[num].getText());
					 lb_img.setIcon(lb_img_item[ num].getIcon());
					 lb_status.setText(lb_disponibilidade[num].getText());
					 System.out.println(num);
					
				     pn_mostrar.setVisible(true);
					 getContentPane().add(pn_mostrar);
				 
				 }});
			 
		 }
	}
	
	
	public void ADD() {
		
		
		try {
			if(resultado!=null && quantidade_itens!=0) {
				lb_notresults.setVisible(false);
				int X=40,Y=120, index=0, id_professor;
				
				
				for(int i=0;i<=quantidade_itens-1;i++) {
					
					nome= resultado.getString("nome");
					categoria= resultado.getString("categoria");
					status= resultado.getString("status");
					img = resultado.getString("img");
					id_professor = resultado.getInt("ID_professor");
					
					System.out.println(id_professor);
					
					System.out.println(nome+categoria+status+img+id_professor);
					
					lb_titulo_item[index].setVisible(true);
					lb_img_item[index].setVisible(true);
					bt_visualizar[index].setVisible(true);
					lb_disponibilidade[index].setVisible(true);					
					lb_fundo_itens[index].setVisible(true);
					
					lb_titulo_item[i].setText(nome);
					//lb_titulo_item[index].setBounds(X+100,Y+25,300,30);
					
					
					lb_img_item[index].setIcon(new ImageIcon(img));
		
					lb_disponibilidade[index].setText(status);	
					//lb_disponibilidade[index].setBounds(X+125,Y+70,300,30);
					
					
					if(lb_disponibilidade[index].getText().equals("Disponivel")) {
						
						lb_disponibilidade[index].setForeground(Color.GREEN);
						bt_visualizar[index].setBackground(Color.GREEN);
					}
					else if (lb_disponibilidade[index].getText().equals("Ocupado")) {
						localiza_professor(id_professor);
						lb_disponibilidade[index].setText(lb_disponibilidade[index].getText()+": "+resultado2.getString("nome"));
						lb_disponibilidade[index].setForeground(Color.RED);
						bt_visualizar[index].setBackground(Color.RED);
					}
					else {
						
					}
					
					
					if(i==0) {
						X=X+410;
						index=index+1;
					}
					else if(i%3==0) {
						X=40;
						Y=Y+450;
						index=index+1;
					}
					else {
						X=X+410;
						index=index+1;
					}
			
					resultado.next();
				}
			
				
				}
			else {
				lb_notresults.setVisible(true);
			}

			}catch(SQLException erro) {
				System.out.print(erro.toString());
			}
		
		
		
	}
	public void ADD_professor() {
		
		try {
			if(resultado!=null && quantidade_itens!=0) {
				lb_notresults.setVisible(false);
				int X=40,Y=120, index=0, id;
				
				
				for(int i=0;i<=quantidade_itens-1;i++) {
					
					nome= resultado.getString("nome");
					contato= resultado.getString("contato");
					status= resultado.getString("status");
					img = resultado.getString("img");
					id= resultado.getInt("ID");
					
					
					
					
					System.out.println(nome+status+img);
					
					lb_titulo_item[index].setVisible(true);
					lb_img_item[index].setVisible(true);
					bt_visualizar[index].setVisible(true);
					lb_disponibilidade[index].setVisible(true);					
					lb_fundo_itens[index].setVisible(true);
					
					lb_titulo_item[i].setText(nome);
					//lb_titulo_item[index].setBounds(X+100,Y+25,300,30);
					
					
					lb_img_item[index].setIcon(new ImageIcon(img));
		
					lb_disponibilidade[index].setText(status);	
					lb_disponibilidade[index].setBounds(X+125,Y+70,300,30);
					
					
					if(lb_disponibilidade[index].getText().equals("Sem Posee")) {
						
						lb_disponibilidade[index].setForeground(Color.GREEN);
						bt_visualizar[index].setBackground(Color.GREEN);
					}
					else if (lb_disponibilidade[index].getText().equals("Com Posse")) {
//						localiza_materiais(id);
						lb_disponibilidade[index].setText(lb_disponibilidade[index].getText()+": "+resultado2.getString("nome"));
						lb_disponibilidade[index].setForeground(Color.RED);
						bt_visualizar[index].setBackground(Color.RED);
					}
					else {
						
					}
					
					
					if(i==0) {
						X=X+410;
						index=index+1;
					}
					else if(i%3==0) {
						X=40;
						Y=Y+450;
						index=index+1;
					}
					else {
						X=X+410;
						index=index+1;
					}
			
					resultado.next();
				}
			
				
				}
			else {
				lb_notresults.setVisible(true);
			}

			}catch(SQLException erro) {
				System.out.print(erro.toString());
			}
		
	}
	public void Apaga() {
		for(int i=0;i<=quantidade_itens;i++) {
			lb_fundo_itens[i].setVisible(false);
			
			lb_titulo_item[i].setVisible(false);
			
			lb_img_item[i].setVisible(false);
			
			bt_visualizar[i].setVisible(false);
			
			lb_disponibilidade[i].setVisible(false);

		}
		
	}
	public void Conecta(String query) {
		if(BD.getConnection()) {
			
			try {
				caminho = BD.conexao.prepareStatement(query);
				resultado = caminho.executeQuery();
				
				System.out.print(query);
				resultado.last();
				quantidade_itens = resultado.getRow();
				System.out.print(quantidade_itens);
				resultado.first();
			}
			catch(SQLException erro ){
				JOptionPane.showMessageDialog(null,"ERRO AO CONECTAR: "+erro.toString());
			}
			
		}else {
			System.out.print("Conexão falhou");
		}
		
	}
	public void localiza_professor(int id_professor) {
		if(BD.getConnection()) {
					
					try {
						caminho2 = BD.conexao.prepareStatement("Select * from professores where ID="+id_professor);
						resultado2 = caminho2.executeQuery();
						resultado2.first();
						
						
					}
					catch(SQLException erro ){
						JOptionPane.showMessageDialog(null,"ERRO AO CONECTAR: "+erro.toString());
						
					}
					
				}else {
					System.out.print("Conexão falhou");
					
				}
				
	}
	public void localiza_materiais(int id_professor) {
		if(BD.getConnection()) {
					
					try {
						caminho2 = BD.conexao.prepareStatement("Select * from materiais where ID_professor="+id_professor);
						resultado2 = caminho2.executeQuery();
						resultado2.first();
						
						
					}
					catch(SQLException erro ){
						JOptionPane.showMessageDialog(null,"ERRO AO CONECTAR: "+erro.toString());
						
					}
					
				}else {					System.out.print("Conexão falhou");				}	
 }
	
	public static void main(String Args[]) {
		Inicio frame = new Inicio();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(0,0,1280,720);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}


	