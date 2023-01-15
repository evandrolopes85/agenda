package dev.evandro.agenda.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.evandro.agenda.dao.AgendamentoDAO;
import dev.evandro.agenda.dto.AgendamentoDTO;
import dev.evandro.agenda.model.Agendamento;

@Service
public class AgendamentoServiceImpl implements IAgendamentoService{

	@Autowired
	private AgendamentoDAO dao;
	
	@Override
	public Agendamento cadastrarAgendamento(Agendamento novo) {
		// TODO Auto-generated method stub
		//ArrayList<AgendamentoDTO> agDTO = (ArrayList<AgendamentoDTO>) dao.consultaAgendaDoProfissional(novo.getData(), novo.getProfissional().getIdProfissional());
		
		Agendamento res = dao.save(novo);
		
		if(res != null) {
			return res;
		}
		
		return null;
	}

	@Override
	public List<Agendamento> recuperarTodos(){
		// TODO Auto-generated method stub
		return (List<Agendamento>)dao.findAll();
	}

	@Override
	public List<Agendamento> recuperarPorData(LocalDate data) {
		// TODO Auto-generated method stub
		List<Agendamento> res = dao.findByData(data);
		if(res != null) {
			return res;
		}
		
		return null;
	}

	@Override
	public List<AgendamentoDTO> consultaAgendaDoProfissional(LocalDate data, Integer idProfissional) {
		// TODO Auto-generated method stub
//		String[] d = data.split("-");
		List<AgendamentoDTO> res = dao.consultaAgendaDoProfissional(data, idProfissional);
		return res;
	}

	@Override
	public Agendamento recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		Agendamento res = dao.findById(id).orElseGet(null);
		
		return res;
	}

}
