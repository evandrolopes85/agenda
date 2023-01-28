package dev.evandro.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbl_usuario")
	private Integer idUsuario;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	public Usuario(Integer idUsuario, String name, String password) {
		super();
		this.idUsuario = idUsuario;
		this.name = name;
		this.password = password;
	}

	public Usuario() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
