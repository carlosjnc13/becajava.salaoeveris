package br.salaoEveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.salaoEveris.app.request.ServicoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ListServicoResponse;
import br.salaoEveris.app.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {
	
	private final ServicoService _service;
	
	public ServicoController(ServicoService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ServicoRequest request){
		try {
			BaseResponse response= _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);	
		}
		
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obterServico(@PathVariable Long id){
		try {
			BaseResponse response= _service.obterServico(id);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	
	}
	@GetMapping
	public ResponseEntity<BaseResponse> listarServicos(){
		try {
			ListServicoResponse servicos = _service.listarServicos();
			return ResponseEntity.status(servicos.statusCode).body(servicos);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
			
		}
	}

}
