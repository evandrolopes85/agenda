package dev.evandro.agenda.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import dev.evandro.agenda.dao.ProfissionalDAO;
import dev.evandro.agenda.model.Profissional;

@SpringBootTest
@ActiveProfiles("test")
public class ProfissionalTest {
	
	@InjectMocks
	private ProfissionalServiceImpl service;
	
	@Mock
	private ProfissionalDAO dao;
	
	private Integer idExistente = 1;
	private List<Profissional> listaDeTodosProfissionais;
	private Profissional novoProfissional;
	private Profissional profissionalCriado;
	
	
	@BeforeEach
	public void setup() throws Exception{
		System.out.println("DEBUG --- Iniciando Testes");
		
		novoProfissional = new Profissional();
		novoProfissional.setNome("Evandro");
		novoProfissional.setProfissao("Cabeleireiro");
		
		profissionalCriado = new Profissional();
		profissionalCriado.setIdProfissional(1);
		profissionalCriado.setNome("Evandro");
		profissionalCriado.setProfissao("Cabeleireiro");
		
		listaDeTodosProfissionais = new ArrayList<Profissional>();
		
		Profissional p1, p2;
		p1 = new Profissional();
		p1.setIdProfissional(1);
		p1.setNome("Nete");
		p1.setProfissao("Cabeleireira");
		
		p2 =new Profissional();
		p2.setIdProfissional(2);
		p2.setNome("Luciana");
		p2.setProfissao("Manicure");
		
		listaDeTodosProfissionais.add(p1);
		listaDeTodosProfissionais.add(p2);
		
		Mockito.when(dao.findAll()).thenReturn(listaDeTodosProfissionais);
		Mockito.when(dao.save(novoProfissional)).thenReturn(profissionalCriado);
		Mockito.when(dao.findById(idExistente)).thenReturn(Optional.of(new Profissional()));
	}
	
	
	@Test
	public void deveriaCriarProfissional() {
		assertEquals(service.cadastrarProfissional(novoProfissional), profissionalCriado);
	}
	
	@Test
	public void deveriaRetornarListaDeProfissionais() {
		assertTrue(service.recuperarTodos().size() > 0);
	}
	
	@Test
	public void deveriaRetornarPorId() {
		assertNotNull(service.recuperarProfissionalPorId(idExistente));
	}
}
