package br.salaoEveris.app.request;

import java.time.LocalDateTime;
import java.util.Calendar;

import br.salaoEveris.app.model.Cliente;
import br.salaoEveris.app.model.Servico;

public class AgendamentoRequest {
	
	private Calendar dataHora;
	private Cliente cliente;
	private Servico servico;
	
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
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
