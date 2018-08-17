package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.telescopio.Component.TelescopioMail;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class CadastroServlet extends HttpServlet {
	private Usuario usuario;
	private UsuarioDAOImpl dao;
	private TelescopioMail tm;

	public CadastroServlet() {
		this.dao = new UsuarioDAOImpl();
		this.usuario = new Usuario();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cadastrarUsuario.html");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("usuario.usu_name");
		String email = request.getParameter("usuario.usu_email");
		String pass = request.getParameter("usuario.usu_senha");
		tm = new TelescopioMail(email);
		usuario.setUsu_nome(name);
		usuario.setUsu_email(email);
		usuario.setUsu_senha(pass);
		usuario.setUsu_conf(false);
		usuario.setUsu_tipo("U");
		dao.persist(usuario);
		tm.enviaEmailConfirmando();
		RequestDispatcher view = request.getRequestDispatcher("noindex.html");
		view.forward(request, response);
	}
}
