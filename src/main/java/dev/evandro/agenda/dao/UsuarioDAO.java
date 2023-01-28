package dev.evandro.agenda.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.evandro.agenda.model.Usuario;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

}
