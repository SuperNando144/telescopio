<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
	href="/resource/css/observatorium.css">

<link rel="shortcut icon" type="image/x-icon"
	href="/resource/img/observa-favicon.ico">
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<script src="/resource/js/jquery-3.2.1.min.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="/resource/js/jquery.mask.min.js"></script>
<script src="/resource/js/observatorium.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><img src="/resource/img/logo.png"
			height="56px"></a>
		<ul class="nav navbar-nav">
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${tipo == 'U'}">
				<li><a href="/agenda">Agenda</a></li>
				<li><a href="/coordenadas">Acessar Telescópio</a></li>
				<li><a href="/logout">Logout</a></li>
			</c:if>
			<c:if test="${tipo == 'A'}">
				<li><a href="/agenda">Agenda</a></li>
				<li><a href="/telescopio">Telescópio</a></li>
				<li><a href="/cadastro">Cadastrar Usuário</a></li>
				<li><a href="/logout">Logout</a></li>
			</c:if>
			<c:if test="${tipo == null}">
				<li><a href="/cadastro"><span
						class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
		</ul>
	</div>
	</nav>
	<div class="row eventoIndex">
		<div class="col-md-12 titulo">
			<center>
				<img src="/resource/img/logo.png" height="56px"></a>
			</center>
		</div>

		<div class="col-md-12 descricao">
			<p>O Projeto Observatorium é uma proposta nova desenvolvida como
				um trabalho de conclusão de curso do aluno Fernando Keller Haddad do
				Instituto Federal de Ciência, Tecnologia e Educação do Câmpus
				Campinas e que apresenta um sistema de controle e posicionamento de
				um telescópio óptico. Por meio de tal sistema nossos usuários
				estarão no controle desse telescópio podendo escolher qual astro
				observar durante o período noturno. Este projeto tem foco na área de
				ensino, podendo ser utilizado em aulas normais e de campo, assim
				estimulando o interesse dos alunos de tais instituições temas
				relacionados a Astronomia e as Ciências Naturais.</p>
			<center>
				<img src="/resource/img/foto-telescopio.png" width="300px"
					height="200px"> <br />
				<p>Esse sitema funcionada utilizando-se de uma integração entre
					placas de Arduíno, esta que fará todo o posicionamento do
					telescópio, e Raspberry Pi 3, esta que fará a transmissão das
					coordenadas para o telescópio, conectadas a um telescópio óptico,
					transmitindo em tempo real as imagens capturadas por este
					telescópio.</p>
				<i><h5>Que as estrelas do céu iluminem sua noite!</h5></i>
			</center>
		</div>

	</div>

	</div>

	<footer class="rodape">
	<div class="container-fluid">
		<div class="row">

			<div class="col-md-12">
				<i>Observatorium (2018) - Todos os direitos reservados.</i>
			</div>
		</div>
	</footer>
</body>
</html>