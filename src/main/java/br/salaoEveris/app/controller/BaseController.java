package br.salaoEveris.app.controller;

import br.salaoEveris.app.response.BaseResponse;

public class BaseController {
	
	public BaseResponse error = new BaseResponse();
	
	public BaseController() {
		error.message = "Ocorreu um erro inesperado.";
		error.statusCode = 500;
	}

}
