<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Observatorium - Cadastro de Usuário</title>

<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/turtletickets.css">
</head>
<body class="body-cadastro-usuario">

	<div class="titulo-cadastro-usuario">
		<h1>Cadastro de Usuário</h1>
	</div>
	<div class="container">
		
		<form class="form-cadastro-usuario" action="/cadastro" method="post">
			<div class="erro">${errorMessage}</div>
			<div class="form-group">
				<label for="name">Nome Completo</label> <input type="text"
					class="form-control" id="name" aria-describedby="emailHelp"
					placeholder="Email" name="usuario.usu_name">
			</div>
			<div class="form-group">
				<label for="email">Endereço de Email</label> <input type="email"
					class="form-control" id="email" aria-describedby="emailHelp"
					placeholder="Email" name="usuario.usu_email"><small
					id="emailHelp" class="form-text text-muted">Nós nunca
					compartilharemos o seu email com ninguém.</small>
			</div>

			<div class="form-group">
				<label for="password">Senha</label> <input type="password"
					class="form-control" id="password" placeholder="Senha"
					name="usuario.usu_senha">
			</div>

			<button type="submit" class="btn">Cadastrar-se</button>
		</form>
	</div>
</body>
</html>