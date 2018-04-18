package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dauphine.miageIF.projets.easyLocation.dao.ProduitDAO;
import dauphine.miageIF.projets.easyLocation.dao.ProduitDAOImpl;
import dauphine.miageIF.projets.easyLocation.model.Produit;

/**
 * Servlet implementation class GetProduit
 */
@WebServlet("/GetProduit")
public class GetProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		
		ProduitDAO produit = new ProduitDAOImpl();
		Produit prod = new Produit();
		PrintWriter pw = response.getWriter();
		
		/*prod = produit.getProduitByID(idProduit);
		response.setContentType("application/json");
		pw.println(prod.ProduitToJson());*/
	}

}
