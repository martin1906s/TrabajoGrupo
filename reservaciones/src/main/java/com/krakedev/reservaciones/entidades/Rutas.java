package com.krakedev.reservaciones.entidades;

public class Rutas {

	private int rut_id;

	private Ciudades ciu_id_origen;

	private Ciudades ciu_id_destino;

	private Buses bus_id;

	public Rutas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rutas(int rut_id, Ciudades ciu_id_origen, Ciudades ciu_id_destino, Buses bus_id) {
		super();
		this.rut_id = rut_id;
		this.ciu_id_origen = ciu_id_origen;
		this.ciu_id_destino = ciu_id_destino;
		this.bus_id = bus_id;
	}

	public int getRut_id() {
		return rut_id;
	}

	public void setRut_id(int rut_id) {
		this.rut_id = rut_id;
	}

	public Ciudades getCiu_id_origen() {
		return ciu_id_origen;
	}

	public void setCiu_id_origen(Ciudades ciu_id_origen) {
		this.ciu_id_origen = ciu_id_origen;
	}

	public Ciudades getCiu_id_destino() {
		return ciu_id_destino;
	}

	public void setCiu_id_destino(Ciudades ciu_id_destino) {
		this.ciu_id_destino = ciu_id_destino;
	}

	public Buses getBus_id() {
		return bus_id;
	}

	public void setBus_id(Buses bus_id) {
		this.bus_id = bus_id;
	}

	@Override
	public String toString() {
		return "Rutas [rut_id=" + rut_id + ", ciu_id_origen=" + ciu_id_origen + ", ciu_id_destino=" + ciu_id_destino
				+ ", bus_id=" + bus_id + "]";
	}

}
