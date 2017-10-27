package com.mastere.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.mastere.dao.UserDAO;
import com.mastere.metier.User;

/**
 * Servlet implementation class ServletAuthentication
 */
@WebServlet("/auth/*")
public class ServletAuthentication extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;


    public void login(){
    	if(this.req.getMethod().equals("POST")){
    		User u = UserDAO.getUserByMailPassword(getParam("mail"), getParam("password"));
    		if(u == null){
    			this.displayView(null);
    			return;
    		}else{
    			this.req.getSession().setAttribute("USER", u);
    			String redirect = (String)req.getSession().getAttribute("REDIRECT");
    			if(redirect != null){
    				try {
						this.resp.sendRedirect(redirect);
						return;
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}else
    				redirect("/home");
    		}
    	}
    	this.displayView(null);
    }
    
    public void logout(){
    	this.req.getSession().removeAttribute("USER");
    	redirect("/home");
    }
	
}
