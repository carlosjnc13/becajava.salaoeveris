package br.salaoEveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.salaoEveris.app.request.ClienteRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ListClienteResponse;
import br.salaoEveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {
	
	private final ClienteService _service;
	
	//@Autowired
	public ClienteController(ClienteService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ClienteRequest request){
		try {
			BaseResponse response= _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}

	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obterCliente(@PathVariable Long id){
		try {
			BaseResponse response= _service.obterCliente(id);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse> listarClientes(){
		try {
			ListClienteResponse clientes = _service.listarClientes();
			return ResponseEntity.status(clientes.statusCode).body(clientes);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
			
		}
	}
	
}
