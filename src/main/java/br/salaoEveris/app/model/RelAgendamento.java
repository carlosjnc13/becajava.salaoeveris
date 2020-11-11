package br.salaoEveris.app.model;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Temporal;

public class RelAgendamento {
	
	private Long id;
	private String nomeCliente;
	private String nomeServico;
	private Calendar dataHora;
	private double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public Calendar getData() {
		return dataHora;
	}
	public void setData(Calendar data) {
		this.dataHora = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
