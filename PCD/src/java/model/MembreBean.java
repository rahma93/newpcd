/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author Youssef
 */
@ManagedBean(name = "MBean", eager = true)
@RequestScoped
public class MembreBean {
     private String nommembre;
     private String prenommembre;
     private String pseudomembre;
     private String emailmembre;
     private String passwordmembre;
     private Integer numtelmembre;
     private Set membreDonnerNotes = new HashSet(0);
     private Set commentaires = new HashSet(0);
     
     
     
     
     
     public String savemembre(){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
		//AgentMedicalDAO userDao = new AgentMedicalDAO();
                
                Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
                
                
                Set<MembreDonnerNote> membreDonnerNotes = new HashSet<MembreDonnerNote>(0);
		
                
                Membre membre=new Membre(nommembre, prenommembre, pseudomembre, emailmembre, passwordmembre, numtelmembre, membreDonnerNotes, commentaires);
                session.save(membre);
                
                session.getTransaction().commit();
		session.close();
		
		return "output";
                            }

    public MembreBean() {
    }

    public String getNommembre() {
        return nommembre;
    }

    public void setNommembre(String nommembre) {
        this.nommembre = nommembre;
    }

    public String getPrenommembre() {
        return prenommembre;
    }

    public void setPrenommembre(String prenommembre) {
        this.prenommembre = prenommembre;
    }

    public String getPseudomembre() {
        return pseudomembre;
    }

    public void setPseudomembre(String pseudomembre) {
        this.pseudomembre = pseudomembre;
    }

    public String getEmailmembre() {
        return emailmembre;
    }

    public void setEmailmembre(String emailmembre) {
        this.emailmembre = emailmembre;
    }

    public String getPasswordmembre() {
        return passwordmembre;
    }

    public void setPasswordmembre(String passwordmembre) {
        this.passwordmembre = passwordmembre;
    }

    public Integer getNumtelmembre() {
        return numtelmembre;
    }

    public void setNumtelmembre(Integer numtelmembre) {
        this.numtelmembre = numtelmembre;
    }

    public Set getMembreDonnerNotes() {
        return membreDonnerNotes;
    }

    public void setMembreDonnerNotes(Set membreDonnerNotes) {
        this.membreDonnerNotes = membreDonnerNotes;
    }

    public Set getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set commentaires) {
        this.commentaires = commentaires;
    }
    
     
     
}
