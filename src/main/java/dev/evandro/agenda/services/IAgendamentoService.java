package dev.evandro.agenda.services;

import java.util.List;

import dev.evandro.agenda.model.Agendamento;

public interface IAgendamentoService {
	public Agendamento cadastrarAgendamento(Agendamento novo);
	public List<Agendamento> recuperarTodos();

}
