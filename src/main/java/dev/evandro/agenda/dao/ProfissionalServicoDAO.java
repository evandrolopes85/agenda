package dev.evandro.agenda.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.evandro.agenda.dto.ProfissionalServicoDTO;
import dev.evandro.agenda.model.ProfissionalServico;

public interface ProfissionalServicoDAO extends CrudRepository<ProfissionalServico, Integer>{

	@Query("SELECT new "
			+ "dev.evandro.agenda.dto.ProfissionalServicoDTO(p.profissionalServicoId.profissional.idProfissional, p.profissionalServicoId.servico.idServico) "
			+ " FROM ProfissionalServico p")
	public ArrayList<ProfissionalServicoDTO> getAllProfissionalServico();
}
