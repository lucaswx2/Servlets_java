package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.IAcaoInterface;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/controlador")
public class ControladorFilter implements Filter {


	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		
		String paramAcao = request.getParameter("acao");	
		String acao = "br.com.alura.gerenciador.acao." + paramAcao;
		

		IAcaoInterface obj;
		try {
			obj = (IAcaoInterface) Class.forName(acao).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			throw new ServletException(e);
		}
		
		String nome = obj.executar(request, response);
		

		String[] proximoPasso = nome.split(":");
		if (proximoPasso[0].equals("redirect")) {
			
			response.sendRedirect( proximoPasso[1]);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/" + proximoPasso[1]);
			dispatcher.forward(request, response);
		}
	}



}
