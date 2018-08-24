<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Observatorium - Confirmar Email</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/resource/img/observa-favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/observatorium.css">
</head>
<body class="body-cadastro-usuario">

	<div class="titulo-cadastro-usuario">
		<h1>Confirmação de Email</h1>
	</div>
	<div class="container">

		<form class="form-cadastro-usuario" action="confirmar" method="post">
			<div class="erro">${errorMessage}</div>
			<div class="form-group">
				<label for="name">Código de Verificação</label> <input type="text"
					class="form-control" id="cod" aria-describedby="emailHelp"
					placeholder="Código de verificação" name="cod">
			</div>
			<button type="submit" class="btn">Confirmar E-mail</button>
		</form>
	</div>
</body>
</html>