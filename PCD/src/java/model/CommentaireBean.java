/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
     private Integer idarticle;
     private Map<Integer, String> map = new HashMap();

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    

    public Integer getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public AgentMedical getAgentMedical() {
        return agentMedical;
    }

    public void setAgentMedical(AgentMedical agentMedical) {
        this.agentMedical = agentMedical;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public String getCommentairecontent() {
        return commentairecontent;
    }

    public void setCommentairecontent(String commentairecontent) {
        this.commentairecontent = commentairecontent;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }
    
     
     
     
     
     public String savecommentaires(Integer idarticle){
         Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                FacesContext fc = FacesContext.getCurrentInstance();
                String email = (String)fc.getApplication().createValueBinding("#{user.emailagent}").getValue(fc);
		String text = map.get(idarticle);
		
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
               
                List<AgentMedical> agentMedicals;
                agentMedicals = session.createQuery("from AgentMedical as agent\n" +"where  agent.emailagent = '"+email+"'").list();
		agentMedical = agentMedicals.get(0);
                List<Article> articles;
                article = (Article)session.createQuery("from Article as article where article.idarticle = '"+idarticle+"'").uniqueResult();
                
                Commentaire commentaire = new Commentaire(agentMedical,article,null,text, date1);
                session.save(commentaire);
                
                
                
                session.getTransaction().commit();
		session.close();
		
		return "blog";
       
      
    }
    
}
