package br.edu.ifsp.telescopio.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.telescopio.dao.agenda.AgendaDAOImpl;
import br.edu.ifsp.telescopio.models.Agenda;

public class CoordenadasServlet extends HttpServlet {
	private Agenda agenda;
	private AgendaDAOImpl dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher view = request.getRequestDispatcher("coordenadas.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.dao = new AgendaDAOImpl();
		this.agenda = new Agenda();
		HttpSession session = request.getSession();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		long cod = (Long) session.getAttribute("cod");
		Date date = new Date();
		try {
			date = this.converter(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.conecta();
		agenda = dao.findByDate(date);
		dao.fechar();
		if (agenda == null) {
			request.setAttribute("errorMessage", "Não existem agendamentos para essa data.");
			request.getRequestDispatcher("coordenadas.jsp").forward(request, response);
		} else {
			if ((Long) session.getAttribute("cod") != agenda.getUsu_cod().getUsu_cod()) {
				request.setAttribute("errorMessage", "Você não tem permissão para utilizar o telescópio nessa data.");
				request.getRequestDispatcher("coordenadas.jsp").forward(request, response);
			} else {
				Double azimute = Double.parseDouble(request.getParameter("coordenada.azimute"));
				Double declinacao = Double.parseDouble(request.getParameter("coordenada.declinacao"));
				if ((azimute < -180) || (azimute > 180) || (declinacao < 0) || (declinacao > 90)) {
					request.setAttribute("errorMessage", "Coordenadas inválidas.");
					request.getRequestDispatcher("coordenadas.jsp").forward(request, response);
				}

				agenda.setAge_coord_azimute(azimute);
				agenda.setAge_coord_declin(declinacao);
				dao.conecta();
				dao.update(agenda);
				dao.fechar();
				RequestDispatcher view = request.getRequestDispatcher("telescopio.jsp");
				view.forward(request, response);
			}

		}

	}

	public Date converter(Date data) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String datas = fmt.format(data);
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		return sourceFormat.parse(datas);
	}
}
