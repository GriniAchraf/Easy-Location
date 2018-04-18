package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dauphine.miageIF.projets.easyLocation.model.Categorie;
import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;

/**
 * Servlet implementation class GetSL
 */
@WebServlet("/GetSL")
public class GetSL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SocieteLocation sl = new SocieteLocation();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		pw.print(sl.societeLocationToJson());
	}
}
