package dev.evandro.agenda.dto;

public class ProfissionalServicoDTO {
	
	private Integer idProfissional;
	
	private Integer idServico;
	

	public Integer getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Integer idProfissional) {
		this.idProfissional = idProfissional;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}


	public ProfissionalServicoDTO(Integer idProfissional, Integer idServico) {
		super();
		this.idProfissional = idProfissional;
		this.idServico = idServico;
	}

	public ProfissionalServicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
