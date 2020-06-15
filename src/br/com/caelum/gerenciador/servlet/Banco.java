package br.com.caelum.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	static List<Empresa> lista = new ArrayList();

	static {
		Banco.lista.add(new Empresa("Alura", new Date()));
		Banco.lista.add(new Empresa("Caelum", new Date()));
	}

	static public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}

	static public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
}
