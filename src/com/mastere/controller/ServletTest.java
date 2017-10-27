package com.mastere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String action = req.getPathInfo();
		
		if(action == null){
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
			return;
		}
		
		switch (action) {
		case "/google":
			resp.sendRedirect("http://www.google.fr");
			break;

		case "/bonjour":
			req.getRequestDispatcher("/WEB-INF/views/test/bonjour.jsp").forward(req, resp);
			break;
			
		case "/formulaire":
			req.setAttribute("title", "formulaire");
			req.getRequestDispatcher("/WEB-INF/views/test/formulaire.jsp").forward(req, resp);
			break;
			
		default:
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getPathInfo();
		
		if(action == null){
			resp.sendError(404, "L'action demandée n'est pas prise en charge.");
			return;
		}
		
		if(action.equals("/formulaire")){
			final String prenom = req.getParameter("inputPrenom");
			final String nom = req.getParameter("inputNom");
			final String chaine = "Bonjour " + prenom + " " + nom;
			
			req.setAttribute("maChaine", chaine);
			
			req.getRequestDispatcher("/WEB-INF/views/test/resultat.jsp").forward(req, resp);
			return;
		}
		resp.sendError(404, "L'action demandée n'est pas prise en charge.");
	}

	
}
