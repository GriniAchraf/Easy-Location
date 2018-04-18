package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dauphine.miageIF.projets.easyLocation.dao.SocieteLocationDAOImpl;
import dauphine.miageIF.projets.easyLocation.model.SocieteLocation;


@WebServlet("/getAllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SocieteLocation sl = new SocieteLocationDAOImpl().getAllSL().get(0);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		pw.println(sl.produitsToJson());
	}

}
