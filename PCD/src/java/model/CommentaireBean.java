/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static model.ArticleBean.mapToList;
import org.hibernate.Session;

/**
 *
 * @author mainou
 */
@ManagedBean(name = "ComBean", eager = true)
@RequestScoped
public class CommentaireBean {
      private Integer idcommentaire;
     private AgentMedical agentMedical;
     private Article article;
     private Membre membre;
     private String commentairecontent;
     private Date date2;
     
     
     
     @PostConstruct
     public void affichecommentaires(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       
         
       session.getTransaction().commit();
       session.close();
       
      // return Articles;  
    }
    
}
