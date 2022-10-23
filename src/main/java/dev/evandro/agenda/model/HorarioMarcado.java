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
@Table(name = "tbl_horario_marcado")
public class HorarioMarcado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario_marcado")
	private Integer idHorarioMarcado;
	
	@Column(name="data",nullable = false)
	private LocalDate data;
	
	@Column(name="hora_inicio", nullable=false)
	private LocalTime horaInicio;
	
	@Column(name="hora_final", nullable=false)
	private LocalTime horaFinal;
	
//	@ManyToOne
//	@JoinColumn(name="tbl_servico_id_servico")
//	@JsonIgnoreProperties("horariosMarcado")
//	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "tbl_profissional_id_profissional")
	@JsonIgnoreProperties("horariosMarcado")
	private Profissional profissional;

	public Integer getIdHorarioMarcado() {
		return idHorarioMarcado;
	}

	public void setIdHorarioMarcado(Integer idHorarioMarcado) {
		this.idHorarioMarcado = idHorarioMarcado;
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

//	public Servico getServico() {
//		return servico;
//	}
//
//	public void setServico(Servico serico) {
//		this.servico = serico;
//	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	
}
