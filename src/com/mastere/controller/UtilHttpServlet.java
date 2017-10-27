package com.mastere.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class UtilHttpServlet extends HttpServlet {
	
	
	protected String action = "";
	protected HttpServletRequest req = null;
	protected HttpServletResponse resp = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		
		if(this.action == null || this.action.equals("/"))
			this.action = "/index";
			
		this.action = this.action.substring(1).toLowerCase();
		try {
			this.getClass().getMethod(this.action, null).invoke(this,null);
		} catch (Exception e) {
			e.printStackTrace();
			this.resp.sendError(404, "L'action demandée n'est pas disponible");
		} 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		this.action = this.action.substring(1).toLowerCase();
		
		/*List<Class> objs = new ArrayList<>();
		String param = this.req.getParameterNames().nextElement();
		while(param != null){
			//objs.add(param.getClass());
			objs.add(String.class);
		}*/

		
		try {
			//this.getClass().getDeclaredMethod(this.action, (Class<?>[]) objs.toArray());
			
			this.getClass().getMethod(this.action, null).invoke(this,null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	protected void displayView(final String viewName, final String controllerName){
		String controller = controllerName == null ? null : controllerName;
		
		if(controller == null){
			controller = this.getClass().getSimpleName();
			controller = controller.substring(controller.lastIndexOf("Servlet") + 7).toLowerCase();
		}
		try {
		final String dir = "/WEB-INF/views/" + controller + "/" + viewName + ".jsp";
			req.getRequestDispatcher(dir).forward(this.req, this.resp);
		} catch (Exception e) {
			try {
				this.resp.sendError(405, "La vue " + viewName + " est introuvable");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	protected void displayView(Object model){
		String controller = this.getClass().getSimpleName();
		controller = controller.substring(controller.lastIndexOf("Servlet") + 7).toLowerCase();
		
		String viewName = this.action;
		
		this.req.setAttribute("model", model);
		try {
			final String dir = "/WEB-INF/views/" + controller + "/" + viewName + ".jsp";
			req.getRequestDispatcher(dir).forward(this.req, this.resp);
		} catch (Exception e) {
			try {
				this.resp.sendError(405, "La vue " + viewName + " est introuvable");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
			
	protected String getParam(final String name){
		return this.req.getParameter(name) != null ? this.req.getParameter(name).toString() : "";
	}
	
	protected Integer getParamAsInt(final String name){
		final String param = getParam(name);
		try{
			return Integer.parseInt(param);
		}catch(Exception e){
			return null;
		}
	}
	
	protected Float getParamAsFloat(final String name){
		final String param = getParam(name);
		try{
			return Float.parseFloat(param);
		}catch(Exception e){
			return null;
		}
	}
	
	protected void redirect(String url){
		url = req.getContextPath() + url;
		try {
			resp.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
