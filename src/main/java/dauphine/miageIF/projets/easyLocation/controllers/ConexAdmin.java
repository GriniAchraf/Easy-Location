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
import dauphine.miageIF.projets.easyLocation.model.Compte;

@WebServlet("/loginAdmin")
public class ConexAdmin extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String login = request.getParameter("email");
	    String mdp = request.getParameter("pass");
	    System.out.println(login);
	    
	    Compte admin = new CompteDAOImpl().getCompteByEmail(login);
	    
		PrintWriter pw = response.getWriter();
	   
	    if(admin != null) {
	    		if(admin.getMotDePasse().equals(mdp)){
	    			HttpSession session = request.getSession();
		        session.setAttribute("admin", admin); 
				pw.println("Connexion admin réussie.");
		        response.sendRedirect("Accueil.html");
		        }
	    		else pw.println("Mot de passe incorrect.");
	    		}
	    else pw.println("Login inexistant.");
	}
}
