package com.krakedev.reservaciones.entidades;

public class Ciudades {
	private int ciu_id;
	private String ciu_nombre;

	public Ciudades() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudades(int ciu_id, String ciu_nombre) {
		super();
		this.ciu_id = ciu_id;
		this.ciu_nombre = ciu_nombre;
	}

	public int getCiu_id() {
		return ciu_id;
	}

	public void setCiu_id(int ciu_id) {
		this.ciu_id = ciu_id;
	}

	public String getCiu_nombre() {
		return ciu_nombre;
	}

	public void setCiu_nombre(String ciu_nombre) {
		this.ciu_nombre = ciu_nombre;
	}

	@Override
	public String toString() {
		return "Ciudades [ciu_id=" + ciu_id + ", ciu_nombre=" + ciu_nombre + "]";
	}

}
