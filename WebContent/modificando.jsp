<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Práctica 1 DIS</title>

<link href="extras/css/bootstrap.min.css" rel="stylesheet">
<link href="extras/css/style.css" rel="stylesheet">


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<%@ page import="es.ufv.dis.jugador.bean.*"%>
<%@ page import="es.ufv.dis.jugador.motor.*"%>
<%
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String equipo = request.getParameter("equipo");
	String posicion = request.getParameter("posicion");
	String numero = request.getParameter("numero");
	String salario = request.getParameter("salario");
	String rol = request.getParameter("rol");
	String nombreO = request.getParameter("nombreO");
	String apellidoO = request.getParameter("apellidoO");
	String equipoO = request.getParameter("equipoO");

	Motor motor = new Motor();
	motor.motorModifica(nombre, apellido, equipo, posicion, numero, salario, rol, nombreO, apellidoO, equipoO);
	motor.motorVuelca();

	Motor motorAct = new Motor();
	Vector<Jugador> jugadores = motorAct.getJugadores();
%>
<hr>
</head>
<center>
	<img src="extras/img/nfl.png"> <img src="extras/img/foton.jpg">
	<img src="extras/img/nfl.png">
</center>
<hr>
<ul>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Equipo</th>
				<th>Salario</th>
				<th>Posición</th>
				<th>Rol</th>
				<th>Número</th>
			</tr>
		</thead>
		<tbody>
			<%
				Vector<Jugador> resultadoConsulta = motorAct.motorBusca(jugadores, nombre, equipo, posicion);
				for (int i = 0; i < resultadoConsulta.size(); i++) {
					Jugador jug = resultadoConsulta.elementAt(i);
			%>
			<tr>
				<td><%=jug.getNombre()%></td>
				<td><%=jug.getApellido()%></td>
				<td><%=jug.getEquipo()%></td>
				<td><%=jug.getSalario()%></td>
				<td><%=jug.getPosicion()%></td>
				<td><%=jug.getRol()%></td>
				<td><span class="badge"> <%=jug.getNumero()%></span></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</ul>
<div class="col-md-12">
	<div class="nav nav-tabs">
		<div align="center">
			<a href="modificar.jsp" class="btn btn-primary btn-lg btn-warning"
				role="button"> <span class="glyphicon glyphicon-repeat"
				aria-hidden="true"></span> Otro <span
				class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
			</a> <a href="index.jsp" class="btn btn-primary btn-lg btn-danger"
				role="button"> <span class="glyphicon glyphicon-home"
				aria-hidden="true"></span> Volver <span
				class="glyphicon glyphicon-home" aria-hidden="true"></span>
			</a>
		</div>
	</div>
</div>
</html>