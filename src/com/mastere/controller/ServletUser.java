package com.mastere.controller;

import javax.servlet.annotation.WebServlet;

import com.mastere.dao.UserDAO;
import com.mastere.metier.User;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet(name="ServletUser",urlPatterns="/user/*")
public class ServletUser extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;

	public void create(){
		if(this.req.getMethod().equals("POST")){
			User u = new User();
			u.setName(this.getParam("name"));
			u.setFirstname(this.getParam("firstname"));
			u.setMail(this.getParam("mail"));
			u.setPassword(this.getParam("password"));
			UserDAO.Save(u);
			this.displayView(null);
		}else
			this.displayView(null);
	}

}
