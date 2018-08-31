package br.edu.ifsp.telescopio.App;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifsp.telescopio.conn.ConnectionFactory;
import br.edu.ifsp.telescopio.conn.FactoryEntityManager;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class App {
	
	public static void main(String[] args) throws ClassNotFoundException {
		/*UsuarioDAOImpl dao = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		dao.conecta();
		usuario = dao.findByEmail("fernandok.haddad@gmail.com");
		System.out.println(usuario);
		dao.fechar();*/
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		dao.conecta();
		System.out.println(dao.findByEmail("fernandok.haddad@gmail.com"));
		dao.fechar();
	}

}
