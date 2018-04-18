package dauphine.miageIF.projets.easyLocation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dauphine.miageIF.projets.easyLocation.dao.InitDataBase;

@WebServlet("/parametrage")
public class Parametrage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("dataaaaaaaaaaa");
		InitDataBase db=new InitDataBase();
		db.initAdmin();
	}
	

}
