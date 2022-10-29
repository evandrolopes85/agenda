package dev.evandro.agenda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.evandro.agenda.model.Cliente;
import dev.evandro.agenda.services.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping("/cliente")
	public ResponseEntity<ArrayList<Cliente>> recuperarTodos(){
		ArrayList<Cliente> clientes = service.listarTodos();
		
		if(clientes.size() >= 0) {
			return ResponseEntity.status(200).body(clientes);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> recuperarPorId(@PathVariable Integer id){
		Cliente res = service.recuperarPorId(id);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		if(cliente.getIdCliente() != null) {
			cliente.setIdCliente(null);
		}
		
		Cliente novo = service.cadastrarCliente(cliente);
		
		if(novo != null) {
			return ResponseEntity.status(201).body(novo);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/cliente")
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
		if(cliente.getIdCliente() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente atualizado = service.recuperarPorId(cliente.getIdCliente());
		
		if(atualizado != null) {
			atualizado.setNome(cliente.getNome());
			atualizado.setTelefone(cliente.getTelefone());
			
			service.atualizarCliente(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
