package dev.evandro.agenda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.evandro.agenda.dao.ClienteDAO;
import dev.evandro.agenda.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService{

	
	@Autowired
	private ClienteDAO dao;
	
	@Override
	public ArrayList<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>)dao.findAll();
	}

	@Override
	public Cliente cadastrarCliente(Cliente novo) {
		// TODO Auto-generated method stub
		try {
			Cliente res = dao.save(novo);
			
			if(res != null) {
				return res;
			}
		}catch(Exception ex) {
			System.out.println("DEBUG ---- Erro ao cadastrar cliente");
		}
		return null;
	}

	@Override
	public Cliente recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Cliente atualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if(cliente.getIdCliente() == null) {
			return null;
		}
			
		Cliente update = dao.findById(cliente.getIdCliente()).get();
		
		if(update != null) {
			dao.save(update);
			return update;
		}
		return null;
	}

}
