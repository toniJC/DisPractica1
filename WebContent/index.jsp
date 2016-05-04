<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Práctica 1 DIS</title>

<link href="extras/css/bootstrap.min.css" rel="stylesheet">
<link href="extras/css/style.css" rel="stylesheet">

<%@ page import="java.util.Vector"%>
<%@ page import="es.ufv.dis.jugador.bean.*"%>
<%@ page import="es.ufv.dis.jugador.motor.*"%>
<%
	// instanciamos un nuevo motor y recogemos los jugadores. 
	Motor motor = new Motor();
	Vector<Jugador> jugadores = motor.getJugadores();
%>
</head>
<body>
	<div class="container">
		<div class="row">
			<br>
			<center>
				<img src="extras/img/nfl.png"> <img src="extras/img/foton.jpg">
				<img src="extras/img/nfl.png">
			</center>
			<br>
			<div class="col-md-12">
				<div class="col-md-12">
					<div align="center">
						<ul class="list-group">
							<li class="btn btn-default btn-md-4"><a href="consultar.jsp">
									Consulta Jugador </a></li>

							<li class="btn btn-default btn-md-4"><a
								href="consultar2.jsp"> Consulta Equipo </a></li>

							<li class="btn btn-default btn-md-4"><a href="insertar.jsp">
									Nuevo Jugador </a></li>

							<li class="btn btn-default btn-md-4"><a href="modificar.jsp">
									Modificar Jugador </a></li>

							<li class="btn btn-default btn-md-4"><a href="eliminar.jsp">
									Eliminar Jugador </a></li>
						</ul>
					</div>

					<div class="col-md-10 col-md-offset-1">
						<hr>
						<center>
							<h1>Listado de todos los jugadores</h1>
						</center>


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
					</div>
				</div>
			</div>
		</div>
</body>
<div class="container">
	<footer class="footer navbar-fixed" align="center">
		<p>
			Made With <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
			For DIS
		</p>
		<p>Autores:</p>
		<p>Iago Gonzalez Garrido B2B Antonio Junquera Criado</p>
	</footer>
</div>
</html>