package dev.evandro.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.evandro.agenda.dao.ProfissionalDAO;
import dev.evandro.agenda.model.Profissional;

@Controller
public class ProfissionalServiceImpl implements IProfissionalService{

	@Autowired
	private ProfissionalDAO dao;
	
	@Override
	public List<Profissional> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Profissional>)dao.findAll();
	}

	@Override
	public Profissional recuperarProfissionalPorId(Integer id) {
		// TODO Auto-generated method stub
		Profissional res = dao.findById(id).orElse(null);
		if(res != null) {
			return res;
		}
		return null;
	}

	@Override
	public Profissional cadastrarProfissional(Profissional novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public Profissional atualizarProfissional(Profissional update) {
		// TODO Auto-generated method stub
		return dao.save(update);
	}

}
