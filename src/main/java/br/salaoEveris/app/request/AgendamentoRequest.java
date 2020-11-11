package br.salaoEveris.app.request;

import java.time.LocalDateTime;
import br.salaoEveris.app.model.Cliente;
import br.salaoEveris.app.model.Servico;

public class AgendamentoRequest {
	
	private LocalDateTime dataHora;
	private Cliente cliente;
	private Servico servico;
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
