package com.krakedev.reservaciones.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.reservaciones.excepciones.KrakeDevException;

public class ConexionBDD {

	public static Connection obtenerConexion() throws KrakeDevException {

		Context ctx = null;
		DataSource ds = null;
		Connection con = null;

		try {
			ctx = new InitialContext();
			// JNDI
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionReservaciones");
			con = ds.getConnection();
			
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			//Relanzo la excepcion 
			throw new KrakeDevException("Error de Conexión");
		}

		return con;

	}
}
