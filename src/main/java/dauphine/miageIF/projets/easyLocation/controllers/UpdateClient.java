package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dauphine.miageIF.projets.easyLocation.dao.CompteDAOImpl;
import dauphine.miageIF.projets.easyLocation.model.Client;


@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String pass = (String) request.getParameter("pass");
		String adresse = (String) request.getParameter("adresse");
		System.out.println(email + pass + adresse);
		}
*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String pass = (String) request.getParameter("pass");
		String adresse = (String) request.getParameter("adresse");
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
				
		client.setLogin(email);		
		client.setAdresse(adresse);
		client.setMotDePasse(pass);
		
		CompteDAOImpl dao = new CompteDAOImpl();
		dao.updateCompte(client);
		
		//Mettre a jour la variable session
		session.setAttribute("client", client);

		PrintWriter pw = response.getWriter();
		pw.println("Compte modifié avec succès.");
		pw.close();
	}

}
