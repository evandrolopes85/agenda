package dev.evandro.agenda.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProfissionalServicoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "tbl_profissional_id_profissional")
	private Profissional profissional;
	
	@ManyToOne
	@JoinColumn(name = "tbl_servico_id_servico")
	private Servico servico;
	
	
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ProfissionalServicoId(Profissional profissional, Servico servico) {
		super();
		this.profissional = profissional;
		this.servico = servico;
	}

	public ProfissionalServicoId() {
		super();
	}
}
