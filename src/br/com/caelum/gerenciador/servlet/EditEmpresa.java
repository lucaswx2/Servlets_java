package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEditEmpresa
 */
@WebServlet("/editEmpresa")
public class EditEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		Empresa empresa = Banco.buscaEmpresa(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEditEmpresa.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String id = request.getParameter("id");
		
		try {
			Banco.atualizaEmpresa(id,nome,data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("listaEmpresas");
	}

}
