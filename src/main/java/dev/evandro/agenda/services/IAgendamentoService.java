package dev.evandro.agenda.services;

import java.util.List;

import dev.evandro.agenda.model.Agendamento;

public interface IAgendamentoService {
	public Agendamento cadastrarHorarioMarcado(Agendamento novo);
	public List<Agendamento> recuperarHorarioMarcado();

}
