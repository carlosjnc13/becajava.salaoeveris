package br.salaoEveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.salaoEveris.app.model.Cliente;
import br.salaoEveris.app.repository.ClienteRepository;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ClienteResponse;
import br.salaoEveris.app.response.ListClienteResponse;
import br.salaoEveris.app.request.*;

@Service
public class ClienteService{
	
	final ClienteRepository _repository;
	
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}
	
	
	//CRIAR CLIENTE
	public BaseResponse criar(ClienteRequest request) {
		
		BaseResponse response = new BaseResponse();
		Cliente cliente = new Cliente();
		response.statusCode = 400;
		
		if(request.getEndereco() == null) {
			response.message = "Endereço não Inserido";
			return response;
		}
		else if(request.getCpf() == null) {
			response.message = "CPF não Inserido";
			return response;
		}
		else if(request.getNome() == null) {
			response.message = "Nome não Inserido";
			return response;
		}
		else if(request.getTelefone() == null) {
			response.message = "Telefone não Inserido";
			return response;
		}
	
		cliente.setCpf(request.getCpf());
		cliente.setEndereco(request.getEndereco());
		cliente.setNome(request.getNome());
		cliente.setTelefone(request.getTelefone());
		
		_repository.save(cliente);
		
		response.statusCode = 201;
		response.message = "Conta Criada.";
		return response;
	
	}
	
	//OBTER CLIENTE POR ID	
	public ClienteResponse obterCliente(Long id) {
		
		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse  response = new ClienteResponse();
		
		if(cliente.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;	
		}
		response.setEndereco(cliente.get().getEndereco());
		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setTelefone(cliente.get().getTelefone());
		
		response.statusCode = 200;
		response.message = "Cliente Obtido com sucesso.";
		
		return response;
	}
	
	//LISTAR CLIENTES
	public ListClienteResponse listarClientes() {
		
		List<Cliente> lista = _repository.findAll();
		List<ClienteResponse> listaResposta =new ArrayList<ClienteResponse>();
		ListClienteResponse response = new ListClienteResponse();
		
		for(Cliente c: lista) {
			ClienteResponse cliente = new ClienteResponse();
			cliente.setEndereco(c.getEndereco());
			cliente.setId(c.getId());
			cliente.setNome(c.getNome());
			cliente.setTelefone(c.getTelefone());
			
			listaResposta.add(cliente);
		}
		
		response.setClientes(listaResposta);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";
		
		return response;
	}

}
