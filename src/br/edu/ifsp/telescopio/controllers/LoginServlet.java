package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.telescopio.Component.UsuarioSession;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;
import br.edu.ifsp.telescopio.util.MD5Converter;

public class LoginServlet extends HttpServlet {
	private Usuario usuario;
	private UsuarioDAOImpl dao;
	
	public LoginServlet() {
		this.dao = new UsuarioDAOImpl();
		this.usuario = new Usuario();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("logado") == "1") {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("usuario.usu_email");
		String pass = MD5Converter.convertToMd5(request.getParameter("usuario.usu_senha"));
		usuario = dao.findByEmail(email);
		
		if((email == null)||(pass == null)) {
			request.setAttribute("errorMessage", "Campo de email/senha vazio.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		if(usuario == null) {
			request.setAttribute("errorMessage", "Cadastro não existente.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(!usuario.getUsu_conf()) {
			request.setAttribute("errorMessage", "Confirme seu cadastro no link enviado no seu email.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(usuario.getUsu_senha().equals(pass)) {
			session.setAttribute("logado", "1");
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Senha incorreta.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
