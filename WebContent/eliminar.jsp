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
	<form class="form-horizontal" action="eliminando.jsp">
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
							placeholder="Posicion del jugador" name="posicion"> <br>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="nav nav-tabs">
					<div align="center">
						<button type="submit" class="btn btn-primary btn-lg btn-success">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							Eliminar <span class="glyphicon glyphicon-remove"
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
