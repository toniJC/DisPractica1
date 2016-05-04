package es.ufv.dis.jugador.motor;

import java.util.Vector;

import es.ufv.dis.jugador.bean.*;
import es.ufv.dis.jugador.dao.*;

public class Motor {

	private Vector<Jugador> respuesta = new Vector<Jugador>();

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @see : dao.leeJugadores();
	 * @return : devuelve el metodo del dao de leerJugadores
	 * @Descripcion:Recoger todos los jugadores desde el XML
	 */
	public Vector<Jugador> getJugadores() {
		Dao dao = new Dao();
		dao.leeJugadores();
		return dao.getJugadores();
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @see : dao.escribir();
	 * @Descripcion: Vuelca el vector de jugadores en el XML
	 */
	public void motorVuelca() {
		Dao dao = Dao.getInstance();
		dao.vuelca();
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            Vector jugadores: Vector de objetos Jugador String nombre:
	 *            nombre del jugador por el que vamos a buscar String equipo :
	 *            equipo del jugador que queremos buscar String posicion:
	 *            posicion del jugador que queremos buscar
	 * @return : respuesta, Devuelve el vector de resultados de la consulta.
	 * @Descripcion: el metodo recibe los datos del jugador a buscar y el vector
	 *               de jugadores y devuelve el resultado de la "query"
	 */
	public Vector<Jugador> motorBusca(Vector<Jugador> jugadores, String nombre, String equipo, String posicion) {
		for (int i = 0; i < jugadores.size(); i++) {
			Jugador jugador = jugadores.elementAt(i);
			 if (jugador.getNombre().contains(nombre) &&
					 jugador.getEquipo().contains(equipo)
					 && jugador.getPosicion().contains(posicion)){
				respuesta.addElement(jugador);
			}
		}
		return respuesta;
	}
	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            Vector jugadores: Vector de objetos Jugador String nombre:
	 *            equipo del jugador que queremos buscar String posicion:
	 * @return : respuesta, Devuelve el vector de resultados de la consulta.
	 * @Descripcion: el metodo recibe los datos del jugador a buscar y el vector
	 *               de jugadores y devuelve el resultado de la "query"
	 */
	public Vector<Jugador> motorBusca2(Vector<Jugador> jugadores,String equipo){
		for (int i = 0; i < jugadores.size(); i++) {
			Jugador jugador = jugadores.elementAt(i);
			 if (jugador.getEquipo().contains(equipo)) {

				respuesta.addElement(jugador);
			}
		}
		return respuesta;
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @see : dao.nuevoJugador();
	 * @param: String
	 *             nombre: nombre del jugador a insertar String apellido:
	 *             apellido del jugador a insertar String equipo: equipo al que
	 *             pertenece String posicion: posicion que juega String numero:
	 *             numero que lleva String salario: su salario String rol: si es
	 *             de ataque o defensa
	 * @return : null
	 * @Descripcion: inserta un nuevo jugador.
	 */
	public Void motorAniade(String nombre, String apellido, String equipo, String posicion, String numero,
			String salario, String rol) {

		Jugador jugador = new Jugador(nombre, apellido, equipo, posicion, numero, salario, rol);
		Dao dao = Dao.getInstance();
		dao.aniadeJugador(jugador);
		return null;
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @see : dao.modificarJugador();
	 * @param: String
	 *             nombre: nuevo nombre del jugador a modificar String apellido:
	 *             apellido del jugador a modificar String equipo: nuevo equipo
	 *             al que pertenece String posicion: posicion original que juega
	 *             String numero: numero que lleva String salario: su salario
	 *             String rol: si es de ataque o defensa String nombreO: nombre
	 *             original del jugador String apellidoO: apellido original del
	 *             jugador String equipoO: quipo original del jugador
	 * @return : null
	 * @Descripcion: Modifica los datos de un jugador.
	 */
	public Void motorModifica(String nombre, String apellido, String equipo, String posicion, String numero,
			String salario, String rol, String nombreO, String apellidoO, String equipoO) {

		Jugador jugador = new Jugador(nombre, apellido, equipo, posicion, numero, salario, rol);
		Dao dao = Dao.getInstance();
		dao.modificaJugador(jugador, nombreO, apellidoO, equipoO);
		return null;
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @see : dao.eliminarJugador();
	 * @param: String
	 *             nombre: el nombre del jugador a eliminar String equipo:
	 *             equipo del jugador a eliminar String posicion: posicion de la
	 *             que juega el jugador a eliminar
	 * @return : null
	 * @Descripcion: Elimina un jugador.
	 */
	public Void motorBorra(String nombre, String equipo, String posicion) {
		Dao dao = Dao.getInstance();
		dao.extraeJugador(nombre, equipo, posicion);
		return null;
	}

}
