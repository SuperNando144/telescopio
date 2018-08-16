package br.edu.ifsp.telescopio.App;

import br.edu.ifsp.telescopio.conn.ConnectionFactory;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		//Usuario usuario = new Usuario();
		//UsuarioDAOImpl dao = new UsuarioDAOImpl();
		//usuario.setUsu_nome("Fernando");
		//usuario.setUsu_email("fernandok.haddad@gmail.com");
		//usuario.setUsu_senha("12345");
		//usuario.setUsu_tipo("U");
		//dao.persist(usuario);
			ConnectionFactory cf = new ConnectionFactory();
			cf.getConnection();
	}

}
