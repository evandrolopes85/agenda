package dev.evandro.agenda.services;

import java.util.ArrayList;

import dev.evandro.agenda.model.Cliente;

public interface IClienteService {
	public ArrayList<Cliente> listarTodos();
	public Cliente cadastrarCliente(Cliente novo);
	public Cliente recuperarPorId(Integer id);
	public Cliente atualizarCliente(Cliente cliente);
}
