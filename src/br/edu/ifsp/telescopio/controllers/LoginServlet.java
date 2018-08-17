package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class LoginServlet extends HttpServlet {
	private Usuario usuario;
	private UsuarioDAOImpl dao;

	public LoginServlet() {
		this.dao = new UsuarioDAOImpl();
		this.usuario = new Usuario();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("login.html");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("usuario.usu_email");
		String pass = request.getParameter("usuario.usu_senha");
		usuario = dao.findByEmail(email);
		if(usuario.getUsu_senha().equals(pass)) {
			RequestDispatcher view = request.getRequestDispatcher("noindex.html");
			view.forward(request, response);
		}
	}
}
