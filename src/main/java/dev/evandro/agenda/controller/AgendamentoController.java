package dev.evandro.agenda.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.evandro.agenda.dto.AgendamentoDTO;
import dev.evandro.agenda.model.Agendamento;
import dev.evandro.agenda.services.IAgendamentoService;

@RestController
public class AgendamentoController {

//	@Autowired
	private IAgendamentoService service;

	
	public AgendamentoController(IAgendamentoService service) {
		this.service = service;
	}
	
	@GetMapping("/agendamento/search/{id}")
	public ResponseEntity<ArrayList<AgendamentoDTO>> recuperarData(@RequestParam(name="data")String data, @PathVariable Integer id){
		String[] v = data.split("-");
		LocalDate d = LocalDate.of(Integer.valueOf(v[0]), Integer.valueOf(v[1]), Integer.valueOf(v[2]));
		ArrayList<AgendamentoDTO> res = (ArrayList<AgendamentoDTO>)service.consultaAgendaDoProfissional(d, id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/agendamento")
	public ResponseEntity<ArrayList<Agendamento>> recuperarTodos(){
		ArrayList<Agendamento> res = (ArrayList<Agendamento>)service.recuperarTodos();
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/agendamento/{id}")
	public ResponseEntity<Agendamento> recuperarPorId(@PathVariable Integer id){
		Agendamento res = service.recuperarPorId(id);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.notFound().build();
	}
	
//	@GetMapping("/agendamento/search")
//	public ResponseEntity<List<Agendamento>> recuperarPorData(@RequestParam(name="data") String data){
//		LocalDate d = LocalDate.parse(data);
//		List<Agendamento> res= null;
//		if(d != null) {
//			res = service.recuperarPorData(d);
//		}
//		
//		if(res != null) {
//			return ResponseEntity.ok(res);
//		}
//		return ResponseEntity.badRequest().build();
//	}
	
	@PostMapping("/agendamento")
	public ResponseEntity<Agendamento> cadastrarAgendamento(@RequestBody Agendamento novo){
		Agendamento res = service.cadastrarAgendamento(novo);
		
		if(res != null) {
			return ResponseEntity.status(201).body(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
