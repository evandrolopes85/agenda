package dev.evandro.agenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Integer idService;

	@Column(name = "servico", length = 100, nullable = false)
	private String servico;

//	@ManyToOne
//	@JoinColumn(name = "id_profissional")
//	@JsonIgnoreProperties("servicos")
//	private Profissional profissional;

	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("servico")
	private List<Agendamento> agendamentos;

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

//	public Profissional getProfissional() {
//		return profissional;
//	}
//
//	public void setProfissional(Profissional profissional) {
//		this.profissional = profissional;
//	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

}
