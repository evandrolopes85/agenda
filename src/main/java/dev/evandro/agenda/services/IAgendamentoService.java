package dev.evandro.agenda.services;

import java.time.LocalDate;
import java.util.List;

import dev.evandro.agenda.dto.AgendamentoDTO;
import dev.evandro.agenda.model.Agendamento;

public interface IAgendamentoService {
	public Agendamento cadastrarAgendamento(Agendamento novo);
	public List<Agendamento> recuperarTodos();
	public Agendamento recuperarPorId(Integer id);
	public List<Agendamento> recuperarPorData(LocalDate data);
	public List<AgendamentoDTO> consultaAgendaDoProfissional(LocalDate data, Integer idProfissional);
}
