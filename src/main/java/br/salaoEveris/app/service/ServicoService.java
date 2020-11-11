package br.salaoEveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.salaoEveris.app.model.Servico;
import br.salaoEveris.app.repository.ServicoRepository;
import br.salaoEveris.app.request.ServicoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ListServicoResponse;
import br.salaoEveris.app.response.ServicoResponse;

@Service
public class ServicoService {
	
	final ServicoRepository _repository;
	
	public ServicoService(ServicoRepository repository) {
		_repository = repository;
		
	}
	
	//CRIAR SERVICO
	public BaseResponse criar(ServicoRequest request) {
		
		BaseResponse response = new BaseResponse();
		Servico servico = new Servico();
		response.statusCode = 400;
		
		if(request.getNome() == null || request.getNome() == "") {
			response.message = "Nome do Serviço não Inserido!!";
			return response;
		}
		else if(request.getValor() == null) {
			response.message = "Valor não  Inserido";
			return response;
		}
		
		servico.setNome(request.getNome());
		servico.setValor(request.getValor());
		
		_repository.save(servico);
		
		response.statusCode = 201;
		response.message = "Serviço Criado!!.";
		return response;
		
	}
	
	//OBTER SERVIÇO POR ID
	public ServicoResponse obterServico(Long id) {
		
		Optional<Servico> servico = _repository.findById(id);
		ServicoResponse response = new ServicoResponse();
		
		if(servico.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;	
		}
		
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		response.setId(servico.get().getId());
		
		response.statusCode = 200;
		response.message = "Serviço Obtido com sucesso.";
		
		return response;
	}
	
	// LISTAR SERVIÇOS
	public ListServicoResponse listarServicos() {
		
		List<Servico> lista = _repository.findAll();
		ListServicoResponse response = new ListServicoResponse();
		
		response.setServicos(lista);
		response.message = "Serviços Obtidos com sucesso!!";
		response.statusCode = 200;
		
		return response;
	}
	

}
