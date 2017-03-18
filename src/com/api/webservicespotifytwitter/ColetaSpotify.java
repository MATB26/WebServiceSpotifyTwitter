package com.api.webservicespotifytwitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ColetaSpotify")
public class ColetaSpotify {
	@GET
	//@Produces("application/xml")
	public String acessaSpotify(){
		
		return "Deu certo";
	}
}
