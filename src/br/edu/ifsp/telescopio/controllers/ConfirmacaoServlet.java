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

public class ConfirmacaoServlet extends HttpServlet {
	private Usuario usuario;
	private UsuarioDAOImpl dao;
	private TelescopioMail tm;

	public ConfirmacaoServlet() {
		this.dao = new UsuarioDAOImpl();
		this.usuario = new Usuario();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("confirma.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cod = request.getParameter("cod");

		if (cod.isEmpty()) {
			request.setAttribute("errorMessage", "Um dos campos está vazio.");
			request.getRequestDispatcher("confirma.jsp").forward(request, response);
		}

		usuario = dao.findByCod(Double.valueOf(cod));
		
		if (usuario.getUsu_conf()) {
			request.setAttribute("errorMessage", "Esse código expirou.");
			request.getRequestDispatcher("confirma.jsp").forward(request, response);			
		}

		if (usuario != null) {
			usuario.setUsu_conf(true);
			dao.update(usuario);
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Esse código é inválido.");
			request.getRequestDispatcher("confirma.jsp").forward(request, response);
		}
	}
}
