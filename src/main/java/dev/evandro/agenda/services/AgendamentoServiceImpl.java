package dev.evandro.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.evandro.agenda.dao.AgendamentoDAO;
import dev.evandro.agenda.model.Agendamento;

@Component
public class AgendamentoServiceImpl implements IAgendamentoService{

	@Autowired
	private AgendamentoDAO dao;
	
	@Override
	public Agendamento cadastrarHorarioMarcado(Agendamento novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public List<Agendamento> recuperarHorarioMarcado() {
		// TODO Auto-generated method stub
		return (List<Agendamento>)dao.findAll();
	}

}
