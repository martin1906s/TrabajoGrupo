DROP TABLE IF EXISTS usuarios;
create table usuarios(
	usu_cedula char(10) NOT NULL,
	usu_correo varchar(20) NOT NULL,
	usu_nombre varchar(100) NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY(usu_cedula)

);


DROP TABLE IF EXISTS ciudades;
create table ciudades(
	ciu_id serial NOT NULL,
	ciu_nombre varchar(20) NOT NULL,
	CONSTRAINT ciudades_pk PRIMARY KEY(ciu_id)

);

DROP TABLE IF EXISTS buses;
create table buses(
	bus_id char(4) NOT NULL,
	bus_nombre varchar(50) NOT NULL,
	bus_cantPasajeros int NOT NULL,
	CONSTRAINT bus_pk PRIMARY KEY(bus_id)

);


DROP TABLE IF EXISTS rutas;
create table rutas(
	rut_id serial NOT NULL,
	bus_id char(4) NOT NULL,
	ciu_id_origen int NOT NULL,
	ciu_id_destino int NOT NULL,
	CONSTRAINT rutas_pk PRIMARY KEY(rut_id),
	CONSTRAINT fk_buses_rutas FOREIGN KEY (bus_id) 
	REFERENCES buses (bus_id),
	CONSTRAINT fk_ciudad_origen FOREIGN KEY (ciu_id_origen) 
	REFERENCES ciudades (ciu_id),
	CONSTRAINT fk_ciudad_destino FOREIGN KEY (ciu_id_destino) 
	REFERENCES ciudades (ciu_id)
);

Alter table rutas ADD
CONSTRAINT fk_buses_rutas FOREIGN KEY (bus_id) 
	REFERENCES buses (bus_id);



DROP TABLE IF EXISTS reservaciones;
create table reservaciones(
	res_id serial NOT NULL,
	usu_cedula char(10) NOT NULL,
	rut_id int NOT NULL,
	CONSTRAINT reservaciones_pk PRIMARY KEY(res_id),
	CONSTRAINT fk_usuario_reservaciones FOREIGN KEY (usu_cedula) 
	REFERENCES usuarios (usu_cedula),
	CONSTRAINT fk_rutas_reservaciones FOREIGN KEY (rut_id) 
	REFERENCES rutas (rut_id)
);

INSERT INTO public.usuarios(
	usu_cedula, usu_correo, usu_nombre)
	VALUES ('1234567891', 'alejomuoss@gmail.com', 'Pasajero 1'),
	('1234567892', 'usuario2@gmail.com', 'Pasajero 2'),
	('1234567893', 'usuario3@gmail.com', 'Pasajero 3');
	select * from usuarios


	INSERT INTO public.ciudades(
	ciu_id, ciu_nombre)
	VALUES (1, 'Ibarra'),
	(2, 'Otavalo'),
	(3, 'Quito');


	INSERT INTO public.buses(
	bus_id, bus_nombre, bus_cantpasajeros)
	VALUES ('1010', 'Anteña', 35),
	('2020', 'Flota Imbabura', 30),
	('3030', 'Coperativa Loja', 30);


	INSERT INTO public.rutas(
	rut_id, ciu_id_origen, ciu_id_destino, bus_id)
	VALUES (1, 1, 2, '1010'),
	(2, 2, 3, '2020'),
	(3, 3, 1, '3030');

	


	INSERT INTO public.reservaciones(
	res_id, usu_cedula, rut_id)
	VALUES (1, 1234567891, 1),
	(2, 1234567892, 2),
	(3, 1234567893, 3);

	
select * from ciudades

	select * from buses

	select * from rutas

	select * from reservaciones
	select * from usuarios
	


select bus_id,bus_nombre,bus_cantpasajeros from buses 


select rut_id,ciudades.ciu_nombre as origen,ciuDest.ciu_nombre as destino , buses.bus_id
from rutas,ciudades,ciudades as ciuDest,buses
where rutas.ciu_id_origen = ciudades.ciu_id
and rutas.ciu_id_destino = ciuDest.ciu_id
and rutas.bus_id = buses.bus_id

