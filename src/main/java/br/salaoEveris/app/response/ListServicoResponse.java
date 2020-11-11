package br.salaoEveris.app.response;

import java.util.List;

import br.salaoEveris.app.model.Servico;

public class ListServicoResponse extends BaseResponse{
	
	private List<Servico> servicos;

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servico) {
		this.servicos = servico;
	}

}
