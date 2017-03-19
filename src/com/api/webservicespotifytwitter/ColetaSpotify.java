package com.api.webservicespotifytwitter;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ColetaSpotify")
public class ColetaSpotify {
		
	@GET
	//@Produces("application/xml")
	public String acessaSpotify() throws SQLException, IOException{
		verificaBanco();
		return "Deu certo2";
	}
	
	public void verificaBanco() throws SQLException, IOException{
		AcessoBanco acessoBanco = new AcessoBanco();
		acessoBanco.conectarBanco();;
		if(acessoBanco.estaConectado()){
			System.out.println("Conectou!");
			acessoBanco.listarUsuarios();
			//acessoBanco.inserirUsuario("Igu", "123", "@igu", "1234");
			//acessoBanco.editaUsuario("4", "LastLg", "LastSn", "twitLg", "twitSn");
			acessoBanco.apagarUsuario("4");
			//acessoBanco.desconectarBanco();
		}else{
			System.out.println("Falha ao conectar ao banco.");
		}
	}
	
	
}
