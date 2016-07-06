package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

/**
 * @author ARCE - Davi Mustafa
 * @date 06/07/2016
 */
public class Projeto {
	
	private String nome;
	private Long id;
	private Integer anoDeInicio;
	
	public Projeto() {}

	public Projeto(Long id, String nome, Integer anoDeInicio) {
		super();
		this.nome = nome;
		this.id = id;
		this.anoDeInicio = anoDeInicio;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoDeInicio() {
		return anoDeInicio;
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}
}
