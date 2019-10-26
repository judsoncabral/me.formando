package br.ufrn.imd.meformando.controllers;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.ufrn.imd.meformando.util.TokenAuthenticationService;

@Stateless
@Path("/usuario")
public class UsuarioController {
	@POST
	@Path("/logar")
	public Response logar(@HeaderParam("email") String email, 
			@HeaderParam("senha") String senha) {
		//verifica se existem no banco
		String token = TokenAuthenticationService.addAuthentication(email);
		return Response.status(200).header("token", token).build();
	}
}