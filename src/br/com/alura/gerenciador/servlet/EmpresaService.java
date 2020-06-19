package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresaService
 */
@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    		String accept = req.getHeader("Accept");
    		
    		List<Empresa> empresas = Banco.getEmpresas();
    		System.out.println(accept);
    		
    		if(accept.contains("xml")) {
    			XStream xstream = new XStream();
    			String xml = xstream.toXML(empresas);
    			resp.setContentType("xml");
    			resp.getWriter().print(xml);
    		}else if(accept.contains("json")) {
    			Gson gson = new Gson();
    			String json = gson.toJson(empresas);
    			resp.setContentType("json");
    			resp.getWriter().print(json);
    		}
    		
    		
    		
    	}

}
