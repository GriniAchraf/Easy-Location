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


@WebServlet("/addClient")
public class AddClient extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String email = (String) request.getParameter("email");
		String tel = request.getParameter("telephone");
		String pass = (String) request.getParameter("pass");
		String adresse = (String) request.getParameter("adresse");
		
		Client client = new Client(email, pass, nom, prenom, tel, adresse);
		
		CompteDAOImpl dao = new CompteDAOImpl();
		
		PrintWriter pw = response.getWriter();
		
		if (dao.getCompteByEmail(email) == null) {
			dao.addCompte(client);
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			pw.println("Votre compte a été crée avec succès.");
			response.sendRedirect("Accueil.html");
		}
		else pw.println("Vous avez déjà un compte.");
		pw.close();
		
	}

}
