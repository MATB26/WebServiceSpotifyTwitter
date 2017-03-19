package com.api.webservicespotifytwitter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AcessoBanco {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectarBanco() throws SQLException {
		String servidor = "jdbc:mysql://127.0.0.1:3306/banco_tpsm";
		String usuario = "root";
		String senha = "root";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = (Connection) DriverManager.getConnection(servidor, usuario, senha);
			this.statement = (Statement) this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean estaConectado(){
		if(this.connection != null){
			return true;
		}else{
			return false;
		}
	}
	
	public void listarUsuarios() {
		try{
			String query = "select * from usr_usuario";
			this.resultset = this.statement.executeQuery(query);
			System.out.println("----\n");
			while(this.resultset.next()){
				System.out.println("ID: "+ this.resultset.getString("Usr_Id"));
			}
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void inserirUsuario(String LastLg, String LastSn, String twitLg, String twitSn) {
		try{
			String query = "insert into usr_usuario "
					+ "(Usr_Last_lg, Usr_Last_sh, Usr_Twit_lg, Usr_Twit_sh) "
					+ "values('" + LastLg + "','" + LastSn + "','" + twitLg + "','" + twitSn + "');";
			this.statement.executeUpdate(query);
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void editaUsuario(String id, String LastLg, String LastSn, String twitLg, String twitSn) {
		try{
			String query = "update usr_usuario set "
					+ "Usr_Last_lg = '" + LastLg + "', Usr_Last_sh = '" + LastSn + "', Usr_Twit_lg = '" + twitLg + "', Usr_Twit_sh = '" + twitSn + "' "
					+ "where usr_id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void apagarUsuario(String id) {
		try{
			String query = "delete from usr_usuario where usr_id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void desconectarBanco() {
		try{
			this.connection.close();
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}