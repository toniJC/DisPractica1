<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Práctica 1 DIS</title>
</head>
<link href="extras/css/bootstrap.min.css" rel="stylesheet">
<link href="extras/css/style.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<%@ page import="es.ufv.dis.jugador.bean.*"%>
<%@ page import="es.ufv.dis.jugador.motor.*"%>


<%
	String equipo = request.getParameter("equipo");
	Motor motor = new Motor();
	Vector<Jugador> jugadores = motor.getJugadores();
%>
<hr>
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
				<th>Número</th>
			</tr>
		</thead>
		<tbody>
			<%
				Vector<Jugador> resultadoConsulta = motor.motorBusca2(jugadores, equipo);
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
			<a href="consultar.jsp" class="btn btn-primary btn-lg btn-success"
				role="button"> <span class="glyphicon glyphicon-fast-backward"
				aria-hidden="true"></span> Atrás Jugador <span
				class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span>
			</a> <a href="consultar2.jsp" class="btn btn-primary btn-lg btn-warning"
				role="button"> <span class="glyphicon glyphicon-backward"
				aria-hidden="true"></span> Atrás Equipo <span
				class="glyphicon glyphicon-backward" aria-hidden="true"></span>
			</a> <a href="index.jsp" class="btn btn-primary btn-lg btn-danger"
				role="button"> <span class="glyphicon glyphicon-home"
				aria-hidden="true"></span> Inicio <span
				class="glyphicon glyphicon-home" aria-hidden="true"></span>
			</a>
		</div>
	</div>
</div>
</html>