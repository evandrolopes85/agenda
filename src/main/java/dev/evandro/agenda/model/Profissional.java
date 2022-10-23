package dev.evandro.agenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_profissional")
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profissional")
	private Integer idProfissional;
	
	@Column(name = "nome", nullable= false, length=100)
	private String nome;
	
	@Column(name = "profissao", length=100, nullable=false)
	private String profissao;

	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("profissional")
	private List<Servico> servicos;
	
	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("profissional")
	private List<HorarioMarcado> horariosMarcado;
	
	public Integer getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Integer idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<HorarioMarcado> getHorariosMarcado() {
		return horariosMarcado;
	}

	public void setHorariosMarcado(List<HorarioMarcado> horariosMarcado) {
		this.horariosMarcado = horariosMarcado;
	}
	
}
