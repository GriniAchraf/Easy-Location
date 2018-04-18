package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dauphine.miageIF.projets.easyLocation.model.Client;

@WebServlet("/GetPanier")
public class GetPanier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		
		PrintWriter pw = response.getWriter();

		if (client != null) {
			response.setContentType("application/json");
			pw.print(client.panierToJson());
		}
		else pw.println("Veuillez vous connecter pour effectuer cette opération.");
		pw.close();
	}
	
}
