package com.krakedev.reservaciones.entidades;

public class Buses {

	private String bus_id;
	private String bus_nombre;
	private int bus_cantPasajeros;

	public Buses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buses(String bus_id, String bus_nombre, int bus_cantPasajeros) {
		super();
		this.bus_id = bus_id;
		this.bus_nombre = bus_nombre;
		this.bus_cantPasajeros = bus_cantPasajeros;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getBus_nombre() {
		return bus_nombre;
	}

	public void setBus_nombre(String bus_nombre) {
		this.bus_nombre = bus_nombre;
	}

	public int getBus_cantPasajeros() {
		return bus_cantPasajeros;
	}

	public void setBus_cantPasajeros(int bus_cantPasajeros) {
		this.bus_cantPasajeros = bus_cantPasajeros;
	}

	@Override
	public String toString() {
		return "Buses [bus_id=" + bus_id + ", bus_nombre=" + bus_nombre + ", bus_cantPasajeros=" + bus_cantPasajeros
				+ "]";
	}

}
