package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String dataAberturaParam = request.getParameter("data");

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dataAbertura = format.parse(dataAberturaParam);
			Empresa empresa = new Empresa(nome, dataAbertura);
			Banco.adiciona(empresa);

			request.setAttribute("empresa", empresa);

			RequestDispatcher dispatcher = request.getRequestDispatcher("NovaEmpresaCriada.jsp");

			dispatcher.forward(request, response);

		} catch (ParseException e) {
			throw new ServletException(e);
		}

	}

}
