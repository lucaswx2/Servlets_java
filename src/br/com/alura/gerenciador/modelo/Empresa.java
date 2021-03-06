package br.com.alura.gerenciador.modelo;

import java.util.Date;
import java.util.UUID;

public class Empresa {
	private String id;
	private String nome;
	private Date dataAbertura;
	
	
	public Empresa(String nome,Date data) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.dataAbertura = data;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome + " - " + this.id;
	}

	public void setDataAbertura(Date data) {
		this.dataAbertura=data;
	}
	

}
