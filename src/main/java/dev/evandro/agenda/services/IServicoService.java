package dev.evandro.agenda.services;

import java.util.List;

import dev.evandro.agenda.model.Servico;

public interface IServicoService {

	public List<Servico> recuperarTodos();
	public Servico recuperarPorId(Integer id);
	public Servico cadastrarServico(Servico novo);
	public Servico atualizarServico(Servico update);
}
