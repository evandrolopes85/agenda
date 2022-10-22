package dev.evandro.agenda.services;

import java.util.List;

import dev.evandro.agenda.model.Profissional;

public interface IProfissionalService {
	public List<Profissional> recuperarTodos();
	public Profissional recuperarProfissionalPorId(Integer id);
	public Profissional cadastrarProfissional(Profissional novo);
	public Profissional atualizarProfissional(Profissional update);
}
