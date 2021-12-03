package Tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection conexao = null;
	private final String drive = "com.mysql.jdbc.Driver";
	private final String name_bd ="Materials_Security";
	private final String url = "jdbc:mysql://localhost:3306/"+name_bd;
	private final String user ="root";
	private final String senha ="";
	
public boolean getConnection(){
	
	try{
		Class.forName(drive);
		conexao = DriverManager.getConnection(url,user,senha);
	
		return true;
	}
	catch(ClassNotFoundException erro){
		System.out.print("DEU ERRO NO DRIVE, NÃO FOI ENCONTRADO: "+erro.toString());
		return false;
		
	}
	catch(SQLException erro){
		System.out.print("ERRO NO CAMINHO DO BANCO DE DADOS, ERRO NO ACESSO: "+erro.toString());
		return false;	
	}
}

public void close() {
	try {
		conexao.close();
		System.out.print("Desconectou do bd");
		
	}
	catch(SQLException erro) {
		System.out.print("ERRO AO FECHAR O BD: "+erro.toString());
	}	
}
}


//materiais
/// id primary key auto increment not null
///nome varchar not null
/// categoria  varchar not null
/// disponibilidade varchar not null
/// img  varchar not null
/// posse  varchar not null
//id_professor int not null

/// professores
///// nome  varchar not null
/// contato  varchar not null
////img varchar not null
///// status  varchar not null
///// id primary key auto increment no

