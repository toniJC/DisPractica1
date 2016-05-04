<html>
<head>
<center>
	<img src="extras/img/nfl.png"> <img src="extras/img/foton.jpg">
	<img src="extras/img/nfl.png">
	<hr>
</center>

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Práctica 1 DIS</title>

<link href="extras/css/bootstrap.min.css" rel="stylesheet">
<link href="extras/css/style.css" rel="stylesheet">
<hr>

</head>
<div class="col-md-4"></div>
<div class="col-md-6" style="height: 100%">
	<form class="form-horizontal" action="insertando.jsp">
		<div align="center">
			<div class="col-lg-9">

				<div class="form-group">
					<label class="col-sm-3 control-label"> Nombre </label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="Nombre del Jugador" name="nombre">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label"> Apellido </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="Apellido"
							name="apellido">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label"> Equipo </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="Equipo"
							name="equipo">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label"> Posicion </label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="Posicion del jugador" name="posicion">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Rol </label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="Ofensiva o Defensiva" name="rol">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Número</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="Numero"
							name="numero">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Salario</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" placeholder="Salario"
							name="salario">
					</div>
				</div>
				<br>
			</div>

			<div class="col-md-8">
				<div class="nav nav-tabs">
					<div align="center">
						<button type="submit" class="btn btn-primary btn-lg btn-success">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Añadir <span class="glyphicon glyphicon-pencil"
								aria-hidden="true"></span>
						</button>
						<button type="reset" class="btn btn-primary btn-lg btn-warning">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							Reset <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button>
						<a href="index.jsp" class="btn btn-primary btn-lg btn-danger"
							role="button"> <span class="glyphicon glyphicon-home"
							aria-hidden="true"></span> Inicio <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
</html>
