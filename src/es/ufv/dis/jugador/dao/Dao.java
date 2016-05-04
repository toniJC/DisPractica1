package es.ufv.dis.jugador.dao;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.ufv.dis.jugador.bean.*;

public class Dao {
	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @Descripción:Clase Dao, encargada de la lectura y escritura del XML
	 *                    implementa el patron singleton.
	 */
	private static Dao _dao;
	private Vector<Jugador> jugadores = new Vector<Jugador>();

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @return : _dao, devuelve la instancia del dao si exixte, o bien la crea y
	 *         devuelve si no existe.
	 * @Descripcion: Constructor de la clase, implementa el patron singleton.
	 */
	public static Dao getInstance() {
		if (_dao == null) { // Si no est· el _dao lo crearemos a partir del if
			_dao = new Dao();
			_dao.leeJugadores();
		}
		return _dao; // devuelvo el objeto de la clase
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @return : doc
	 * @Descripcion: Genera el DOM de la app y devuelve el document leido y
	 *               montado
	 */
	public Document generaDOM() {
		Document doc = null;

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();

			Element raiz = doc.createElement("jugadores"); // raiz del XML

			for (int i = 0; i < jugadores.size(); i++) {
				Jugador jugador = jugadores.elementAt(i);
				Element jugadorElement = doc.createElement("jugador"); // Elemento
																		// Principal
																		// del
																		// XML

				Element nombreElement = doc.createElement("nombre");
				nombreElement.setTextContent(jugador.getNombre());

				Element apellidoElement = doc.createElement("apellido");
				apellidoElement.setTextContent(jugador.getApellido());

				Element equipoElement = doc.createElement("equipo");
				equipoElement.setTextContent(jugador.getEquipo());

				Element posicionElement = doc.createElement("posicion");
				posicionElement.setTextContent(jugador.getPosicion());
				posicionElement.setAttribute("numero", String.valueOf(jugador.getNumero()));

				Element salarioElement = doc.createElement("salario");
				salarioElement.setTextContent(String.valueOf(jugador.getSalario()));

				Element rolElement = doc.createElement("rol");
				rolElement.setTextContent(String.valueOf(jugador.getRol()));

				jugadorElement.appendChild(nombreElement);
				jugadorElement.appendChild(apellidoElement);
				jugadorElement.appendChild(equipoElement);
				jugadorElement.appendChild(posicionElement);
				jugadorElement.appendChild(salarioElement);
				jugadorElement.appendChild(rolElement);

				raiz.appendChild(jugadorElement);
			}
			doc.appendChild(raiz);
		} catch (Exception e) {
		}
		return doc;
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            Document doc
	 * @see : Cuidado con la ruta que es absoluta.
	 * @Descripcion: Metodo encargado del guardado del XML
	 */
	public void salvaXML(Document doc) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("/Users/AJC/PracticaDIS/src/es/ufv/dis/xml/Jugadores.xml"));
			Source input = new DOMSource(doc);

			transformer.transform(input, output);
		} catch (Exception e) {
		}
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @Descripcion: Vuelca los datos del vector de jugadores en el XML
	 */
	public void vuelca() {
		Document doc = generaDOM();
		salvaXML(doc);
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @return : jugadores, devuele el vector de los juagdores leidos desde el
	 *         XML Descripcion: Metodo que devulve el vector de jugadores actual
	 *         que contenga la aplicacion.
	 */
	public Vector<Jugador> getJugadores() {
		return jugadores;
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @Descripcion: Lee jugadores de XML y loe vuelca sobre el vector
	 */
	public void leeJugadores() {

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;

		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File("/Users/AJC/PracticaDIS/src/es/ufv/dis/xml/Jugadores.xml"));
			doc.getDocumentElement().normalize();

			Element raiz = doc.getDocumentElement();

			NodeList hijos = raiz.getChildNodes();

			for (int i = 0; i < hijos.getLength(); i++) {
				Node hijo = hijos.item(i);
				if (hijo.getNodeType() == Node.ELEMENT_NODE) {
					Element hijoEl = (Element) hijo;

					Node nombreNodo = hijoEl.getElementsByTagName("nombre").item(0);
					Element nombreElement = (Element) nombreNodo;
					String nombre = nombreElement.getTextContent();

					Node apellidoNodo = hijoEl.getElementsByTagName("apellido").item(0);
					Element apellidoElement = (Element) apellidoNodo;
					String apellido = apellidoElement.getTextContent();

					Node equipoNodo = hijoEl.getElementsByTagName("equipo").item(0);
					Element equipoElement = (Element) equipoNodo;
					String equipo = equipoElement.getTextContent();

					Node posicionNodo = hijoEl.getElementsByTagName("posicion").item(0);
					Element posicionElement = (Element) posicionNodo;
					String posicion = posicionElement.getTextContent();

					String numero = posicionElement.getAttribute("numero");

					Node salarioNodo = hijoEl.getElementsByTagName("salario").item(0);
					Element salarioElement = (Element) salarioNodo;
					String salario = salarioElement.getTextContent();

					Node rolNodo = hijoEl.getElementsByTagName("rol").item(0);
					Element rolElement = (Element) rolNodo;
					String rol = rolElement.getTextContent();

					Jugador jugador = new Jugador(nombre, apellido, 
							equipo, posicion, numero, salario, rol);

					jugadores.addElement(jugador);
				}
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            Jugador jugador, entra el objeto jugador a introducir.
	 * @Descripcion: introduce un nuevo jugador en el vector
	 */
	public void aniadeJugador(Jugador jugador) {
		this.jugadores.addElement(jugador);
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            Jugador jugador, el objeto jugador a modificar nombreO: nombre
	 *            Original del jugador a modificar EquipoO: equipo Original del
	 *            jugador a modificar PosicionO: posición original en la que
	 *            juega ese jugador.
	 * @Descripcion: Recibe un jugador y lo modifica con los datos de entrada
	 */
	public void modificaJugador(Jugador jugador, String nombreO, String equipoO, String posicionO) {
		for (int i = 0; i < this.jugadores.size(); i++) {
			Jugador jugador1 = this.jugadores.elementAt(i);
			if (jugador1.getNombre().equals(nombreO) || jugador1.getPosicion().equals(posicionO)
					|| jugador1.getEquipo().equals(equipoO)) {

				jugador1.setNombre(jugador.getNombre());
				jugador1.setApellido(jugador.getApellido());
				jugador1.setEquipo(jugador.getEquipo());
				jugador1.setPosicion(jugador.getPosicion());
				jugador1.setNumero(jugador.getNumero());
				jugador1.setSalario(jugador.getSalario());
				jugador1.setRol(jugador.getRol());
			}
		}
	}

	/**
	 * @author : Antonio Junquera Criado
	 * @author : Iago Gonzalez Garrido
	 * @version: Práctica1 Master
	 * @param :
	 *            nombre: nombre Original del jugador a modificar Equipo: equipo
	 *            Original del jugador a modificar Posicion: posición original
	 *            en la que juega ese jugador.
	 * @Descripcion: Recibe los datos del jugador a eliminar y lo elimina del
	 *               vector.
	 */
	public void extraeJugador(String nombre, String equipo, String posicion) {
		for (int i = 0; i < this.jugadores.size(); i++) {
			Jugador jugador1 = this.jugadores.elementAt(i);
			if (jugador1.getNombre().equals(nombre) && jugador1.getPosicion().equals(posicion)
					&& jugador1.getEquipo().equals(equipo)) {
				this.jugadores.remove(i);
			}
		}
	}
}