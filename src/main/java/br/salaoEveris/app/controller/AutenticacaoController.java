package br.salaoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.salaoEveris.app.infrastructure.rest.configuration.security.TokenService;
import br.salaoEveris.app.request.LoginRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.TokenResponse;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController extends BaseController{
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<BaseResponse> autenticar(@RequestBody @Validated LoginRequest request){
		UsernamePasswordAuthenticationToken dadosLogin = request.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			return ResponseEntity.ok(new TokenResponse( tokenService.gerarToken(authentication), "Bearer"));	
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().body(error);
			
		}
			
	}

}
