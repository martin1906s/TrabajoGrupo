package com.krakedev.reservaciones.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.reservaciones.entidades.Buses;
import com.krakedev.reservaciones.excepciones.KrakeDevException;
import com.krakedev.reservaciones.utils.ConexionBDD;

public class BusesBDD {
	public ArrayList<Buses> recuperarTodos() throws KrakeDevException {
		ArrayList<Buses> buxes = new ArrayList<Buses>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Buses bus = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select bus_id,bus_nombre,bus_cantpasajeros from buses");
			rs = ps.executeQuery();

			while (rs.next()) {
				String busId = rs.getString("bus_id");
				String busNombre = rs.getString("bus_nombre");
				int busCantPasajeros = rs.getInt("bus_cantpasajeros");

				Buses buses = new Buses();
				buses.setBus_id(busId);
				buses.setBus_nombre(busNombre);
				buses.setBus_cantPasajeros(busCantPasajeros);

				bus = new Buses(busId, busNombre, busCantPasajeros);
				buxes.add(bus);
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

		return buxes;
		
	
	}
	
	public void insertarBuses(Buses buses) throws KrakeDevException {

		Connection con = null;

		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con
					.prepareStatement(""
							+ "INSERT INTO buses "
							+ "	(bus_id, bus_nombre, bus_cantpasajeros) "
							+ "	VALUES (?, ?, ?)");
			ps.setString(1, buses.getBus_id());
			ps.setString(2, buses.getBus_nombre());
			ps.setInt(3, buses.getBus_cantPasajeros());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar bus. Detalle: " + e.getMessage());
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}



	