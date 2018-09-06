package br.edu.ifsp.telescopio.App;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifsp.telescopio.conn.ConnectionFactory;
import br.edu.ifsp.telescopio.conn.FactoryEntityManager;
import br.edu.ifsp.telescopio.dao.agenda.AgendaDAOImpl;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		AgendaDAOImpl dao = new AgendaDAOImpl();
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String datas = fmt.format(date);
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sourceFormat.parse(datas));
		
		}

}
