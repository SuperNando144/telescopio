package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;
import java.util.Random;

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
	private Random rand;

	public CadastroServlet() {
		this.dao = new UsuarioDAOImpl();
		this.usuario = new Usuario();
		this.rand = new Random();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cadastrarUsuario.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("usuario.usu_name");
		String email = request.getParameter("usuario.usu_email");
		String pass = request.getParameter("usuario.usu_senha");
		
		if((name.isEmpty()) || (email.isEmpty()) || (pass.isEmpty())) {
			request.setAttribute("errorMessage", "Um dos campos está vazio.");
			request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);
		}
		
		
		if(dao.findByEmail(email)==null) {
			tm = new TelescopioMail(email);
			usuario.setUsu_nome(name);
			usuario.setUsu_email(email);
			usuario.setUsu_senha(pass);
			usuario.setUsu_conf(false);
			usuario.setUsu_tipo("U");
			usuario.setUsu_ver_num(rand.nextInt(100000) + 100000);
			dao.persist(usuario);
			usuario = dao.findByEmail(email);
			
			tm.enviaEmailConfirmando(usuario.getUsu_ver_num());
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Já existe um cadastro com esse email.");
			request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);
		}
	}
}
