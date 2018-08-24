<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon"
	href="/resource/img/observa-favicon.ico">
<link rel="stylesheet" type="text/css" href="/resource/css/login.css">

<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<title>Observatorium - Login</title>
</head>
<body>
	<div class="container">
		<div class="info"></div>
	</div>
	<div class="form">
		<img src="/resource/img/logo2.png" height="100px" width="150px">
		<div class="erro">${errorMessage}</div>
		<form action="/login" method="post" class="login-form">
			<input name="usuario.usu_email" type="text" placeholder="usuário" />
			<input name="usuario.usu_senha" type="password" placeholder="senha" />
			<button type="submit" name="buttonLogin">login</button>
		</form>
		<p class="message">
			Não Registrado? <a href="/cadastro">Cadastre-se aqui</a>
		</p>
	</div>
</body>
</html>