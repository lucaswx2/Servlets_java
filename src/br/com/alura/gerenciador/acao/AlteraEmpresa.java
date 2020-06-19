package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.IAcaoInterface;
import br.com.alura.gerenciador.modelo.Banco;

public class AlteraEmpresa  implements IAcaoInterface{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AlteraEmpresa");
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String id = request.getParameter("id");
		
		try {
			Banco.atualizaEmpresa(id,nome,data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		return "redirect:controlador?acao=ListaEmpresas";
	}

}
