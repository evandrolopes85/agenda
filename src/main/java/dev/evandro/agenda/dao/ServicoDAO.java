package dev.evandro.agenda.dao;

import org.springframework.data.repository.CrudRepository;

import dev.evandro.agenda.model.Servico;

public interface ServicoDAO extends CrudRepository<Servico, Integer>{

}
