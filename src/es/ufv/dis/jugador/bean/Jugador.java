package es.ufv.dis.jugador.bean;

/**
 * @author : Antonio Junquera Criado
 * @author : Iago Gonzalez Garrido
 * @version: Práctica1 Master Descripción:Definicion de los atributos de la
 *           clase jugador.
 */
public class Jugador{

	private String nombre;
	private String apellido;
	private String equipo;
	private String posicion;
	private String numero;
	private String salario;
	private String rol;

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master Constructor vacío de la clase, genera un nuevo
	 *           objeto jugador vacio
	 */
	public Jugador() {
		super();
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master Constructor de la clase, genera un nuevo
	 *           objeto jugador con sus datos correspondientes
	 */
	public Jugador(String nombre, String apellido, String equipo, String posicion, String numero, String salario,
			String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.equipo = equipo;
		this.posicion = posicion;
		this.numero = numero;
		this.salario = salario;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEquipo() {
		return equipo;
	}

	public String getPosicion() {
		return posicion;
	}

	public String getNumero() {
		return numero;
	}

	public String getSalario() {
		return salario;
	}

	public String getRol() {
		return rol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}