package dev.evandro.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.evandro.agenda.dao.ServicoDAO;
import dev.evandro.agenda.model.Servico;

@Component
public class ServicoServiceImpl implements IServicoService{

	@Autowired
	private ServicoDAO dao;
	
	@Override
	public List<Servico> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Servico>)dao.findAll();
	}

	@Override
	public Servico recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Servico cadastrarServico(Servico novo) {
		// TODO Auto-generated method stub
		if(novo.getIdServico() != null) {
			novo.setIdServico(null);
		}
		if(novo != null) {
			return dao.save(novo);
		}
		
		return null;
	}

	@Override
	public Servico atualizarServico(Servico update) {
		// TODO Auto-generated method stub
		Servico servicoParaAtualizar = dao.findById(update.getIdServico()).get();
		
		if(servicoParaAtualizar != null) {
			return dao.save(servicoParaAtualizar);
		}
		
		return null;
	}

}
