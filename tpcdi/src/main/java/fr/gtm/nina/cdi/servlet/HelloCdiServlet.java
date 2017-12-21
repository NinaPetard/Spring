package fr.gtm.nina.cdi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.nina.cdi.service.ClientService;

/**
 * Servlet implementation class HelloCdiServlet
 */
public class HelloCdiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  @Inject
  ClientService service;
  
    public HelloCdiServlet() {       
    }
    
    public void setClientService(ClientService service) {
    	this.service = service;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		service.creerClient();
		PrintWriter out = response.getWriter();
		
		out.println("Mise en oeuvre CDI ok, Bravo!");
		out.close();
		}



}
