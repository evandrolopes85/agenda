package dev.evandro.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.evandro.agenda.dao.HorarioMarcadoDAO;
import dev.evandro.agenda.model.HorarioMarcado;

@Component
public class HorarioMarcadoServiceImpl implements IHorarioMarcadoService{

	@Autowired
	private HorarioMarcadoDAO dao;
	
	@Override
	public HorarioMarcado cadastrarHorarioMarcado(HorarioMarcado novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public List<HorarioMarcado> recuperarHorarioMarcado() {
		// TODO Auto-generated method stub
		return (List<HorarioMarcado>)dao.findAll();
	}

}
