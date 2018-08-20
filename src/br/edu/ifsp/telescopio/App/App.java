package br.edu.ifsp.telescopio.App;

import java.sql.SQLException;

import javax.inject.Inject;

import br.edu.ifsp.telescopio.Component.UsuarioSession;
import br.edu.ifsp.telescopio.conn.ConnectionFactory;
import br.edu.ifsp.telescopio.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.telescopio.models.Usuario;

public class App {
	@Inject
	private UsuarioSession us;
	
	public static void main(String[] args) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		usuario.setUsu_nome("Fernando");
		usuario.setUsu_email("fernandok.haddad@gmail.com");
		usuario.setUsu_senha("12345");
		usuario.setUsu_tipo("U");
		//us.login(usuario);

	}

}
