package com.mastere.controller;

import java.util.ArrayList;
import java.util.List;

import com.mastere.dao.TestDAO;
import com.mastere.db.HibernateUtil;
import com.mastere.metier.Test;

public class ServletHome extends UtilHttpServlet {
	
	public void index(){
		
		List<String> model = new ArrayList<>();
		model.add("Alain");
		model.add("Bob");
		model.add("Richard");
		//this.displayView("index", null);
		this.displayView(TestDAO.list());
	}
	
	public void toto(){
		this.displayView("toto", null);
	}
	
	public void prenom(){
		if(this.req.getMethod().equals("POST")){
			Test t = new Test();
			t.setName(this.getParam("inputPrenom"));
			TestDAO.Save(t);
			
		}
			this.displayView(TestDAO.list());
	}

}
