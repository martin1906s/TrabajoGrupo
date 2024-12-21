package com.krakedev.reservaciones.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.reservaciones.bdd.RutasBDD;
import com.krakedev.reservaciones.entidades.Rutas;
import com.krakedev.reservaciones.excepciones.KrakeDevException;

@Path("rutas")

public class ServicioRutas {

	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerDocumentos() {
		RutasBDD rutasBDD = new RutasBDD();
		ArrayList<Rutas> rutas = null;
		try {
			rutas = rutasBDD.recuperarTodos();
			return Response.ok(rutas).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
