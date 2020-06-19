package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
@WebFilter("/controlador")
public class MonitoramentoFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String acao =  request.getParameter("acao");
		
		
		long antes = System.currentTimeMillis();
		// pass the request along the filter chain
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo decorrido de " + acao + " foi de:" + (depois - antes) + "ms");
	}

}
