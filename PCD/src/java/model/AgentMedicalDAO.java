/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Youssef
 */
public class AgentMedicalDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
	public void save(AgentMedical agent){
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit();
		session.close();
	}
        
    public Integer verify (String email,String pswd){
		String hql = "select nommembre from Membre where emailmembre='" + email + "' and passwordmembre='" + pswd+"'";
		Query query = session.createQuery(hql);
		List<Integer> results = query.list();
		Integer existence = 0;
                if (!results.isEmpty() ) {
        	   existence = 1;
                }
                if (email.equals("admin1@pcd.com")&&pswd.equals("admin1")) existence=2;
                if (email.equals("admin2@pcd.com")&&pswd.equals("admin2")) existence=2;
                
                return existence;
	}   
    
    public String verifypswd (String email){
		String hql = "select passwordmembre from Membre where emailmembre='" + email + "'";
		Query query = session.createQuery(hql);
                List<Membre> membres;
                membres = session.createQuery("from Membre where emailmembre='" + email + "'").list();
       
                return (membres.get(0)).getPasswordmembre();
	}
    
}
