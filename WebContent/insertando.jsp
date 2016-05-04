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
<center>
	<img src="extras/img/nfl.png"> <img src="extras/img/foton.jpg">
</center>
</head>
<%
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String equipo = request.getParameter("equipo");
	String posicion = request.getParameter("posicion");
	String numero = request.getParameter("numero");
	String salario = request.getParameter("salario");
	String rol = request.getParameter("rol");

	Motor motor = new Motor();
	motor.motorAniade(nombre, apellido, equipo, posicion, numero, salario, rol);
	motor.motorVuelca();
	Vector<Jugador> jugadores = motor.getJugadores();
%>
<center>
	<h2>Listado de Jugadores:</h2>
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
				for (int i = 0; i < jugadores.size(); i++) {
					Jugador jug = jugadores.elementAt(i);
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
			<a href="insertar.jsp" class="btn btn-primary btn-lg btn-warning"
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