package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.IAcaoInterface;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements IAcaoInterface {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("NovaEmpresa");

		String nome = request.getParameter("nome");
		String dataAberturaParam = request.getParameter("data");

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dataAbertura = format.parse(dataAberturaParam);
			Empresa empresa = new Empresa(nome, dataAbertura);
			Banco.adiciona(empresa);

			request.setAttribute("empresa", empresa);
			
			return "redirect:controlador?acao=ListaEmpresas";


		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}

}
