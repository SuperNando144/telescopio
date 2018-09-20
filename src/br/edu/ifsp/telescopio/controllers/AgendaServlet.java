package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.telescopio.Component.TelescopioMail;
import br.edu.ifsp.telescopio.dao.agenda.AgendaDAOImpl;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Agenda;
import br.edu.ifsp.telescopio.models.Usuario;

public class AgendaServlet extends HttpServlet {
	private Agenda agenda;
	private Usuario usuario;
	private AgendaDAOImpl dao;
	private UsuarioDAOImpl daou;
	private TelescopioMail tm;

	public AgendaServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("agenda.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.dao = new AgendaDAOImpl();
		this.agenda = new Agenda();
		this.usuario = new Usuario();
		this.daou = new UsuarioDAOImpl();

		HttpSession session = request.getSession();

		String datas = request.getParameter("age_data");
		String[] data_s = datas.split(Pattern.quote("/"));
		if (datas.isEmpty()) {
			request.setAttribute("errorMessage", "Campo agenda vazio.");
			request.getRequestDispatcher("agenda.jsp").forward(request, response);
		}

		if ((Integer.parseInt(data_s[0]) > 31) || (Integer.parseInt(data_s[0]) < 1)
				|| (Integer.parseInt(data_s[1]) > 12) || (Integer.parseInt(data_s[1]) < 1)
				|| (Integer.parseInt(data_s[2]) > 2100)) {
			request.setAttribute("errorMessage", "Data inválida.");
			request.getRequestDispatcher("agenda.jsp").forward(request, response);
		}

		Date date = new Date();
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sourceFormat.parse(datas);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2 = new Date();
		try {
			date2 = converter(date2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (date.compareTo(date2) == -1) {
			request.setAttribute("errorMessage", "Data inválida.");
			request.getRequestDispatcher("agenda.jsp").forward(request, response);
		}

		dao.conecta();
		if (dao.findByDate(date) == null) {
			dao.fechar();
			agenda.setAge_data(date);
			daou.conecta();
			usuario = daou.findById((Long) session.getAttribute("cod"));
			daou.fechar();
			agenda.setUsu_cod(usuario);
			dao.conecta();
			dao.persist(agenda);
			dao.fechar();
			tm = new TelescopioMail(usuario.getUsu_email());
			tm.lembreteData(datas);
			request.setAttribute("errorMessage", "Agendamento realizado!");
			request.getRequestDispatcher("agenda.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Já existe um agendamento para esse dia.");
			request.getRequestDispatcher("agenda.jsp").forward(request, response);
		}
	}

	public Date converter(Date data) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String datas = fmt.format(data);
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		return sourceFormat.parse(datas);
	}
}
