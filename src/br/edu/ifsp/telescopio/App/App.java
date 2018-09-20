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
		Date date = new Date();
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sourceFormat.parse("11/09/2018");
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
		System.out.println(date);
		System.out.println(date2);
		System.out.println(date.compareTo(date2));
		
		}
	
	public static Date converter(Date data) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String datas = fmt.format(data);
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		return sourceFormat.parse(datas);
	}

}
