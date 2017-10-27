package com.mastere.dao;

import java.util.List;

import com.mastere.db.HibernateUtil;
import com.mastere.metier.Test;

public class TestDAO {
	
	public static void Save(Test t){
		HibernateUtil.getSession().saveOrUpdate(t);
	}
	
	public static List<Test> list(){
		return HibernateUtil.getSession().createSQLQuery("select name from user").getResultList();
	}
	
}
