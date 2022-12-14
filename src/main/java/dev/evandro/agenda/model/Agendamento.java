package dev.evandro.agenda.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_agendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento")
	private Integer idAgendamento;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Column(name = "hora_inicio", nullable = false)
	private LocalTime horaInicio;

	@Column(name = "hora_final", nullable = false)
	private LocalTime horaFinal;

	@ManyToOne
	@JoinColumn(name = "tbl_servico_id_servico")
	@JsonIgnoreProperties("agendamentos")
	private Servico servico;

	@ManyToOne
	@JoinColumn(name = "tbl_profissional_id_profissional")
	@JsonIgnoreProperties("agendamentos")
	private Profissional profissional;

	@ManyToOne
	@JoinColumn(name = "tbl_cliente_id_cliente")
	@JsonIgnoreProperties("agendamentos")
	private Cliente cliente;

	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico serico) {
		this.servico = serico;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}
