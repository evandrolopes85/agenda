package dev.evandro.agenda.dao;

import org.springframework.data.repository.CrudRepository;

import dev.evandro.agenda.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer>{

}
