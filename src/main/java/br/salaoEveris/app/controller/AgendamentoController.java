package br.salaoEveris.app.controller;

//import java.sql.Timestamp;
//import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoEveris.app.request.AgendamentoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.service.AgendamentoService;

@RestController
@RequestMapping(path = "/agendamentos")
public class AgendamentoController extends BaseController {
	
	private final AgendamentoService _service;
	
	public AgendamentoController(AgendamentoService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody AgendamentoRequest request){
		try {
			BaseResponse response= _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
		
	}
//	@GetMapping(path = "/{dataInicio},{dataFim}")
//	public ResponseEntity<BaseResponse> relatorio(@PathVariable Timestamp dataInicio,@PathVariable Timestamp dataFim){
//		try {
//			ListRelAgendamentoResponse response= _service.relatorio(dataInicio, dataFim);
//			return ResponseEntity.status(response.statusCode).body(response);
//		}
//		catch(Exception e) {
//			return ResponseEntity.status(error.statusCode).body(error);
//		}
//		
//	}
}
