package dev.evandro.agenda.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.evandro.agenda.dto.AgendamentoDTO;
import dev.evandro.agenda.model.Agendamento;

@Repository
public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer>{

	public List<Agendamento> findByData(LocalDate data);
//	public Agendamento findByIdAgendamento(Integer id);
	
//	
//	@Query("SELECT new "
//			+ "dev.evandro.agenda.dto.ProfissionalServicoDTO(p.profissionalServicoId.profissional.idProfissional, p.profissionalServicoId.servico.idServico) "
//			+ " FROM ProfissionalServico p")
	
	
//	select prof.nome               as 'Nome Profissional', 
//    cliente.nome            as 'Nome Cliente' , 
//	   agendamento.hora_inicio as 'Hora Inicio',
//    agendamento.hora_final  as 'Hora fim',
//    servico.servico         as 'Servico',
//    servico.preco           as 'Preço' 
//from tbl_agendamento as agendamento
//	inner join tbl_profissional as prof    on agendamento.tbl_profissional_id_profissional = prof.id_profissional
// inner join tbl_cliente      as cliente on cliente.id_cliente = agendamento.tbl_cliente_id_cliente
// inner join tbl_servico      as servico on agendamento.tbl_servico_id_servico = servico.id_servico
// where agendamento.data = '2022-04-01' and prof.id_profissional = 2;
	
	@Query("SELECT new "
			+ "dev.evandro.agenda.dto.AgendamentoDTO(p.nome, c.nome, a.data, a.horaInicio, a.horaFinal, s.servico, s.preco) "
			+ " FROM Agendamento a "
			+ " INNER JOIN Profissional p ON a.profissional.idProfissional = p.idProfissional "
			+ " INNER JOIN Cliente c      ON c.idCliente = a.cliente.idCliente "
			+ " INNER JOIN Servico s      ON s.idServico = a.servico.idServico "
			+ " WHERE a.data = :data AND p.idProfissional= :idProfissional")
	public List<AgendamentoDTO> consultaAgendaDoProfissional(@Param("data")LocalDate data, @Param("idProfissional")Integer idProfissional);
	
	
}
