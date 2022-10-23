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

import dev.evandro.agenda.model.Profissional;
import dev.evandro.agenda.services.IProfissionalService;

@RestController
public class ProfissionalController {

	@Autowired
	private IProfissionalService service;
	
	@GetMapping("/profissional")
	public ResponseEntity<List<Profissional>> recuperarTodos(){
		return ResponseEntity.ok(service.recuperarTodos());
	}
	
	@GetMapping("/profissional/{id}")
	public ResponseEntity<Profissional> recuperarPorId(@PathVariable Integer id){
		Profissional res = service.recuperarProfissionalPorId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.status(404).build();
	}
	
	@PostMapping("/profissional")
	public ResponseEntity<Profissional> cadastrarProfissional(@RequestBody Profissional novo){
		novo.setIdProfissional(null);
		Profissional res = service.cadastrarProfissional(novo);
		
		if(res != null) {
			return ResponseEntity.status(201).body(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/profissional")
	public ResponseEntity<Profissional> atualizarProfissional(@RequestBody Profissional update){
		Profissional res = service.recuperarProfissionalPorId(update.getIdProfissional());
		
		if(res != null) {
			return ResponseEntity.status(200).body(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
