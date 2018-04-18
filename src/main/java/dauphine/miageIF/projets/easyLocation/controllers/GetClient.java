package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dauphine.miageIF.projets.easyLocation.model.Client;
import dauphine.miageIF.projets.easyLocation.model.Compte;

/**
 * Servlet implementation class GetClient
 */
@WebServlet("/GetClient")
public class GetClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Logger log =null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//False because we do not want it to create a new session if it does not exist
		HttpSession session = request.getSession(false);
		Compte client = new Client();
		client =  (Compte) session.getAttribute("client");
		
		PrintWriter pw = response.getWriter();
		
		if(client != null) {
			response.setContentType("application/json");
			pw.print(client.compteToJson());
			
		}
		
		else {
	    	 pw.println("Client inexistant");
	    	 pw.close();
		}
	}

}
