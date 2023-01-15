package dev.evandro.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Integer idServico;

	@Column(name = "servico", length = 100, nullable = false)
	private String servico;
	
	@Column(name="preco", nullable=false)
	private double preco;

//	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("servico")
//	private List<Agendamento> agendamentos;

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

//	public List<Agendamento> getAgendamentos() {
//		return agendamentos;
//	}
//
//	public void setAgendamentos(List<Agendamento> agendamentos) {
//		this.agendamentos = agendamentos;
//	}

}
