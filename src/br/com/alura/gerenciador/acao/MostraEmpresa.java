package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.IAcaoInterface;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa  implements IAcaoInterface{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MostraEmpresa");
		String id = request.getParameter("id");

		Empresa empresa = Banco.buscaEmpresa(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditEmpresa.jsp";

		
	}

}
