package dev.evandro.agenda.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_profissional_servico")
public class ProfissionalServico {
	
	@EmbeddedId
	private ProfissionalServicoId profissionalServicoId;
	
	public ProfissionalServicoId getProfissionalServicoId() {
		return profissionalServicoId;
	}

	public void setProfissionalServicoId(ProfissionalServicoId profissionalServicoId) {
		this.profissionalServicoId = profissionalServicoId;
		
	}

	public ProfissionalServico(ProfissionalServicoId profissionalServicoId) {
		super();
		this.profissionalServicoId = profissionalServicoId;
	}

	public ProfissionalServico() {
		super();
	}
}
