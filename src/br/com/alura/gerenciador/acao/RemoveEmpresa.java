package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.IAcaoInterface;
import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements IAcaoInterface {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("RemoveEmpresa");
		String id = request.getParameter("id");

		Banco.removeEmpresa(id);

		return "redirect:controlador?acao=ListaEmpresas";
	}

}
