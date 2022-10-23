package dev.evandro.agenda.services;

import java.util.List;

import dev.evandro.agenda.model.HorarioMarcado;

public interface IHorarioMarcadoService {
	public HorarioMarcado cadastrarHorarioMarcado(HorarioMarcado novo);
	public List<HorarioMarcado> recuperarHorarioMarcado();

}
