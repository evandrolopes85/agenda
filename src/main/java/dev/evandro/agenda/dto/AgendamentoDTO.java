package dev.evandro.agenda.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoDTO {
	private String nomeProf;
	private String nomeCliente;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private String servico;
	private double preco;

	public AgendamentoDTO() {
		super();
	}

	public AgendamentoDTO(String nomeProf, String nomeCliente, LocalDate data, LocalTime horaInicio,
			LocalTime horaFim, String servico, double preco) {
		super();
		this.nomeProf = nomeProf;
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.servico = servico;
		this.preco = preco;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
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
}
