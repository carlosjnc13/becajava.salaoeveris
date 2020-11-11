package br.salaoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoEveris.app.request.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	
//	@PostMapping
//	public ResponseEntity<?> autenticar(@RequestBody @Validated LoginRequest request){
//		
//		
//		UsernamePasswordAuthenticationToken dadosLogin = new request.converter();
//		
//		authManager.authenticate(dadosLogin);
//		return ResponseEntity.ok().build();		
//	}

}
