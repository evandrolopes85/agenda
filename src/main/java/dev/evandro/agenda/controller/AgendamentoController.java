package dev.evandro.agenda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.evandro.agenda.model.Agendamento;
import dev.evandro.agenda.services.IAgendamentoService;

@RestController
public class AgendamentoController {

	@Autowired
	private IAgendamentoService service;
	
	@GetMapping("/agendamento")
	public ResponseEntity<ArrayList<Agendamento>> recuperarTodos(){
		ArrayList<Agendamento> res = (ArrayList<Agendamento>)service.recuperarTodos();
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/agendamento")
	public ResponseEntity<Agendamento> cadastrarAgendamento(@RequestBody Agendamento novo){
		Agendamento res = service.cadastrarAgendamento(novo);
		
		if(res != null) {
			return ResponseEntity.status(201).body(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
