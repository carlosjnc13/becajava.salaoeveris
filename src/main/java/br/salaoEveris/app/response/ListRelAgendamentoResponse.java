package br.salaoEveris.app.response;

import java.util.List;

import br.salaoEveris.app.model.RelAgendamento;

public class ListRelAgendamentoResponse extends BaseResponse {
	
	private List<RelAgendamento> relatorio;

	public List<RelAgendamento> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(List<RelAgendamento> relatorio) {
		this.relatorio = relatorio;
	}
	
	

}
