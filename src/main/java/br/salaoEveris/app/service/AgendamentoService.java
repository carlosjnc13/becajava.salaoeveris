package br.salaoEveris.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import br.salaoEveris.app.model.Agendamento;
import br.salaoEveris.app.repository.AgendamentoRepository;
import br.salaoEveris.app.request.AgendamentoRequest;
import br.salaoEveris.app.response.BaseResponse;

@Service
public class AgendamentoService {
	
	final AgendamentoRepository _repository;
	
	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;
		
	}
	
	//CRIAR AGENDAMENTO
	public BaseResponse criar(AgendamentoRequest request) {
		
		BaseResponse response = new BaseResponse();
		Agendamento agendamento = new Agendamento();
		response.statusCode = 400;
		
		if(request.getDataHora() == null) {
			response.message = "Data do Agendamento não inserida.";
			return response;
		}
		else if(request.getCliente() == null) {
			response.message = "Cliente não inserido";
			return response;
		}
		else if(request.getServico() == null) {
			response.message = "Serviço não Inserido";
			return response;
		}
	
		agendamento.setCliente(request.getCliente());
		agendamento.setServico(request.getServico());
		agendamento.setDataHora(request.getDataHora());
		
		_repository.save(agendamento);
		
		response.statusCode = 201;
		response.message = "Agendamento Realizado.";
		return response;
		
	}
//	//OBTER RELATORIO
//	public ListRelAgendamentoResponse relatorio(Timestamp dataInicio,Timestamp dataFim) {
//		
////		Calendar dtInicio = Calendar.getInstance();
////		dtInicio.setTime(dataInicio);
////		
////		Calendar dtFim = Calendar.getInstance();
////		dtFim.setTime(dataFim);
//		
//		String 
//		
//		ListRelAgendamentoResponse relatorio = new ListRelAgendamentoResponse();
//		relatorio.setRelatorio(_repository.findBuscarAgendamentos(dtInicio, dtFim));
//		relatorio.statusCode = 200;
//		relatorio.message = "Estou com sono";
//		
//		
//		return relatorio;
//	}

}
