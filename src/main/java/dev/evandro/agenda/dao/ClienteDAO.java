package dev.evandro.agenda.dao;

import org.springframework.data.repository.CrudRepository;

import dev.evandro.agenda.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

}
