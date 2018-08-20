<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Observatorium</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/turtletickets.css">

<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<script src="/resource/js/jquery-3.2.1.min.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="/resource/js/jquery.mask.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">[PH]</a>
		<ul class="nav navbar-nav">
			<li><a href="<c:url value='/' />"><b>Observatorium</b></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/cadastro"><span
					class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
			<li><a href="/login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>

		</ul>
	</div>
	</nav>
	<div class="row eventoIndex">
		<div class="col-md-12 titulo">
			<h2>Observatorium</h2>
		</div>
		<div class="col-md-4 imagem">[PLACEHOLDER]</div>

		<div class="col-md-8 descricao">
			<p>O Projeto Observatorium é uma proposta nova cujo objetivo é o
				incentivo a alunos do Ensino Médio de escolas públicas por temas
				relacionados a Astronomia e as Ciências Naturais. Por meio de
				sistemas integrados de Arduíno e Raspberry Pi 3 a um telescópio
				real, o usuário estaria no comando dele podendo escolher qual astro
				celestel observar em uma noite limpa.</p>
		</div>

	</div>

	</div>

	<footer class="rodape">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-2">
				<ul>
					<li>Acesso ao sistema</li>
				</ul>
			</div>

			<div class="col-md-2">
				<ul>
					<li>Eventos</li>
				</ul>
			</div>

			<div class="col-md-6"></div>
		</div>
	</div>
	</footer>
</body>
</html>