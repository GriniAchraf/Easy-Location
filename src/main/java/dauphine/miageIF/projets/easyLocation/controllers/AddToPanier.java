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
import dauphine.miageIF.projets.easyLocation.dao.ProduitDAOImpl;
import dauphine.miageIF.projets.easyLocation.model.Client;
import dauphine.miageIF.projets.easyLocation.model.Produit;


@WebServlet("/AddToPanier")
public class AddToPanier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idObjet = (String) request.getParameter("idObjet");
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		
		PrintWriter pw = response.getWriter();

		if (client != null) {
			ProduitDAOImpl produitDao = new ProduitDAOImpl();
			Produit produit = produitDao.getProduitByID(idObjet);
			client.addToPanier(produit);
			CompteDAOImpl compteDao = new CompteDAOImpl();
			compteDao.updateCompte(client);
			pw.println("Le produit a été ajouté à votre panier.");
			response.sendRedirect("panier.html");
		}
		else pw.println("Veuillez vous connecter pour effectuer cette opération.");
		pw.close();

	}
}