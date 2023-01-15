package dev.evandro.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.evandro.agenda.model.Servico;
import dev.evandro.agenda.services.IServicoService;

@RestController
public class ServicoController {

	@Autowired
	private IServicoService service;
	
	@GetMapping("/servico")
	public ResponseEntity<List<Servico>> recuperarTodos(){
		List<Servico> res = service.recuperarTodos();
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.status(404).build();
	}
	
	@GetMapping("/servico/{id}")
	public ResponseEntity<Servico> recuperarPorId(@PathVariable Integer id){
		Servico res = service.recuperarPorId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/servico")
	public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico novo){
		Servico res = service.cadastrarServico(novo);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/servico")
	public ResponseEntity<Servico> atualizarServico(@RequestBody Servico update){
		Servico res = service.recuperarPorId(update.getIdServico());
		
		res.setServico(update.getServico());
		res.setPreco(update.getPreco());
		
		if(res != null) {
			return ResponseEntity.ok(service.atualizarServico(res));
		}
		
		return ResponseEntity.badRequest().build();
	}
}
