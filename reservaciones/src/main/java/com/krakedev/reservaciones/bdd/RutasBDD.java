package com.krakedev.reservaciones.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.reservaciones.entidades.Buses;
import com.krakedev.reservaciones.entidades.Ciudades;
import com.krakedev.reservaciones.entidades.Rutas;
import com.krakedev.reservaciones.excepciones.KrakeDevException;
import com.krakedev.reservaciones.utils.ConexionBDD;

public class RutasBDD {
	public ArrayList<Rutas> recuperarTodos() throws KrakeDevException {
		ArrayList<Rutas> rutas = new ArrayList<Rutas>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rutas ruta = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select rut_id,ciudades.ciu_nombre as origen,ciuDest.ciu_nombre as destino , buses.bus_id "
					+ "from rutas,ciudades,ciudades as ciuDest,buses "
					+ "where rutas.ciu_id_origen = ciudades.ciu_id "
					+ "and rutas.ciu_id_destino = ciuDest.ciu_id "
					+ "and rutas.bus_id = buses.bus_id "
					+ "");
			rs = ps.executeQuery();

			while (rs.next()) {
				int rut_id = rs.getInt("rut_id");
				String ciu_origen = rs.getString("origen");
				String ciu_destino = rs.getString("destino");
				String bus_id = rs.getString("bus_id");

				Ciudades ciudad_origen = new Ciudades();
				ciudad_origen.setCiu_nombre(ciu_origen);
				
				Ciudades ciudad_destino = new Ciudades();
				ciudad_destino.setCiu_nombre(ciu_destino);
				
				
				
				Buses bus = new Buses();
				bus.setBus_nombre(bus_id);

			
				Rutas rut = new Rutas();
				rut.setRut_id(rut_id);
				rut.setCiu_id_origen(ciudad_origen);
				rut.setCiu_id_origen(ciudad_destino);
				
				ruta = new Rutas(rut_id, ciudad_origen,ciudad_destino,bus);
				rutas.add(ruta);
			}

		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}

		return rutas;
	}
}
