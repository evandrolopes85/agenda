package dev.evandro.agenda.services;

import org.springframework.stereotype.Service;

import dev.evandro.agenda.dao.UsuarioDAO;
import dev.evandro.agenda.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	private UsuarioDAO dao;
	
	public UsuarioServiceImpl(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Usuario login(Usuario user) {
		Usuario login = dao.save(user);
		
		if(login != null) {
			return login;
		}
		
		return null;
	}

}
