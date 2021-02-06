package br.com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Empresa() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
}
