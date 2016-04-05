/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.catalina.User;
import static org.apache.tomcat.jni.User.username;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Youssef
 */
@ManagedBean(name = "ABean", eager = true)
@RequestScoped

public class AgentMedicalBean {
    private List<AgentMedical> AgentMedicals;
     private Integer idagent;
     private String passwordagent;
     private String nomagent;
     private String prenomagent;
     private String emailagent;
     private String nomvilleagent;
     private String nompadresseagent;
     private Integer codepostalagent;
     private String telagent;
     private Integer typeagent;
     private double lon;
     private double lat;
     private String type;
     
     private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
     private Set<Article> articles = new HashSet<Article>(0);
     private Set<Profil> profils = new HashSet<Profil>(0);
     
     private Set<Photo> photos = new HashSet<Photo>(0);
     private Set<Offre> offres = new HashSet<Offre>(0);
     
     private String phototitre;
     private String photochemin;
     
     private String offreAgent;
     private List<Offre> AOffres;
     
     
    public String saveagent(){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
		//AgentMedicalDAO userDao = new AgentMedicalDAO();
                
                Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
                Set<Article> articles = new HashSet<Article>(0);
                Set<Profil> profils = new HashSet<Profil>(0);
                
                Set<Photo> photos = new HashSet<Photo>(0);
                Set<Offre> offres = new HashSet<Offre>(0);
                Set<MembreDonnerNote> membreDonnerNotes = new HashSet<MembreDonnerNote>(0);
		AgentMedical agent = new AgentMedical(passwordagent,nomagent,prenomagent,emailagent,nomvilleagent,nompadresseagent,codepostalagent,telagent,typeagent,lon,lat,commentaires,articles, profils);
		
                session.save(agent);
                
                Membre membre=new Membre(nomagent, prenomagent, nomagent, emailagent, passwordagent, null, membreDonnerNotes, commentaires);
                session.save(membre);
                Profil profil=new Profil(agent,nomagent,photos,offres);
		session.save(profil);
                
                Offre offre=new Offre(profil,offreAgent);
                session.save(offre);
                
                Photo photo=new Photo(profil,phototitre,photochemin);
                session.save(photo);
		//produitDao.save(produit);
                session.getTransaction().commit();
		session.close();
		//System.out.println("User successfully saved.");
		return "output";
                            }
    public String modifagent(){
            Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                FacesContext fc = FacesContext.getCurrentInstance();
                String email = (String)fc.getApplication().createValueBinding("#{user.emailagent}").getValue(fc);
                
                String hql = "UPDATE AgentMedical set passwordagent = :a ,lon= :e ,lat= :g "  + "WHERE emailagent = :b";
		
                String hql1="select photochemin from Photo where idprofil=(select idprofil from Profil where idagent=(select idagent from AgentMedical where emailagent=email))" ;
                String hql2="select offrenom from Offre where idprofil=(select idprofil from Profil where idagent=(select idagent from AgentMedical where emailagent=email))" ;
                String hql3 = "UPDATE Offre set offrenom = :f  "  + "WHERE idprofil = idprofil=(select idprofil from Profil where idagent=(select idagent from AgentMedical where emailagent=email))";
                String hql4 = "UPDATE Profil set photochemin = :k "  + "WHERE idprofil= = (select idprofil from Profil where idagent=(select idagent from AgentMedical where emailagent=email))";
                
                Query query = session.createQuery(hql);
                Query query2 = session.createQuery(hql2);
                Query query3 = session.createQuery(hql3);
                Query query4 = session.createQuery(hql4);

                query.setParameter("a", passwordagent);
                
                query.setParameter("e",lon );
                query.setParameter("g",lat);
                query3.setParameter("f",offreAgent );
                query4.setParameter("k",photochemin);
                query.setParameter("b", email);
                query.executeUpdate();
               
		
                
                session.getTransaction().commit();
		session.close();
		return "login";
    }
    public String propagent(){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
		//AgentMedicalDAO userDao = new AgentMedicalDAO();
                
                Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
                Set<Article> articles = new HashSet<Article>(0);
                Set<Profil> profils = new HashSet<Profil>(0);
                
                Set<Photo> photos = new HashSet<Photo>(0);
                Set<Offre> offres = new HashSet<Offre>(0);
                
		AgentMedical agent = new AgentMedical("non disponible",nomagent,prenomagent,"non disponible",nomvilleagent,nompadresseagent,codepostalagent,telagent,typeagent,lon,lat,commentaires,articles, profils);
		
                session.save(agent);
                
                Profil profil=new Profil(agent,nomagent,photos,offres);
		session.save(profil);
                
                Offre offre=new Offre(profil,"non disponible");
                session.save(offre);
                
                Photo photo=new Photo(profil,"non disponible","non disponible");
                session.save(photo);
		//produitDao.save(produit);
                session.getTransaction().commit();
		session.close();
		//System.out.println("User successfully saved.");
		return "output";
                            }
    
     
    public String fagent(){
        Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       AgentMedical agent = new AgentMedical(passwordagent,nomagent,prenomagent,emailagent,nomvilleagent,nompadresseagent,codepostalagent,telagent,typeagent,lon,lat,commentaires,articles, profils); 

       AgentMedicals = session.createQuery("from AgentMedical where nomvilleagent='" + nomvilleagent + "' and typeagent='" + typeagent+"'").list();
       
       session.getTransaction().commit();
       session.close();
        return "resultatrecherche" ; 
    }
    
    @PostConstruct
    public void afficheoffres(){
        Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       AgentMedical agent = new AgentMedical(passwordagent,nomagent,prenomagent,emailagent,nomvilleagent,nompadresseagent,codepostalagent,telagent,typeagent,lon,lat,commentaires,articles, profils); 

       AOffres = session.createQuery("from Offre").list();
       AgentMedicals = session.createQuery("from AgentMedical").list();
       /*List<String> AOffres;
       for(int k=0  ;k<AgentMedicals.size();k++)
       {
           (AgentMedicals.get(k)).setOffreAgent(AOffres.get(k));
       };*/
       session.getTransaction().commit();
       session.close();
        //return "afficheoffres" ; 
    }
    
    public String verifyUser(){
		AgentMedicalDAO agentDAO = new AgentMedicalDAO();
		AgentMedical agent = new AgentMedical(passwordagent,nomagent,prenomagent,emailagent,nomvilleagent,nompadresseagent,codepostalagent,telagent,typeagent,lon,lat,commentaires,articles, profils);
		Integer response = agentDAO.verify(emailagent,passwordagent);
		if (response==2) {
                                    FacesContext context = FacesContext.getCurrentInstance();
                                    context.getExternalContext().getSessionMap().put("user", agent);
                                    return "adminloggedin";
                                  }
                        else if (response==1) {
                           // User user = userService.find(username, password);
                            FacesContext context = FacesContext.getCurrentInstance();
                            context.getExternalContext().getSessionMap().put("user", agent);
                            return "login";
                                
                        }
                else return "welcome";
                }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
        }
    
    
     public Integer getIdagent() {
        return idagent;
    }

    public void setIdagent(Integer idagent) {
        this.idagent = idagent;
    }

    public List<AgentMedical> getAgentMedicals() {
        return AgentMedicals;
    }

    public void setAgentMedicals(List<AgentMedical> AgentMedicals) {
        this.AgentMedicals = AgentMedicals;
    }
    
    public List<Offre> getAOffres() {
        return AOffres;
    }

    public void setAOffres(List<Offre> AOffres) {
        this.AOffres = AOffres;
    }

    

    

    

    public String getPasswordagent() {
        return passwordagent;
    }

    public void setPasswordagent(String passwordagent) {
        this.passwordagent = passwordagent;
    }

    public String getNomagent() {
        return nomagent;
    }

    public void setNomagent(String nomagent) {
        this.nomagent = nomagent;
    }

    public String getPrenomagent() {
        return prenomagent;
    }

    public void setPrenomagent(String prenomagent) {
        this.prenomagent = prenomagent;
    }

    public String getEmailagent() {
        return emailagent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmailagent(String emailagent) {
        this.emailagent = emailagent;
    }

    public String getNomvilleagent() {
        return nomvilleagent;
    }

    public void setNomvilleagent(String nomvilleagent) {
        this.nomvilleagent = nomvilleagent;
    }

    public String getNompadresseagent() {
        return nompadresseagent;
    }

    public void setNompadresseagent(String nompadresseagent) {
        this.nompadresseagent = nompadresseagent;
    }

    public Integer getCodepostalagent() {
        return codepostalagent;
    }

    public void setCodepostalagent(Integer codepostalagent) {
        this.codepostalagent = codepostalagent;
    }

    public String getTelagent() {
        return telagent;
    }

    public void setTelagent(String telagent) {
        this.telagent = telagent;
    }

    public Integer getTypeagent() {
        return typeagent;
    }

    public void setTypeagent(Integer typeagent) {
        this.typeagent = typeagent;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

   

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<Profil> getProfils() {
        return profils;
    }

    public void setProfils(Set<Profil> profils) {
        this.profils = profils;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public String getPhototitre() {
        return phototitre;
    }

    public void setPhototitre(String phototitre) {
        this.phototitre = phototitre;
    }

    public String getPhotochemin() {
        return photochemin;
    }

    public String getOffreAgent() {
        return offreAgent;
    }

    public void setOffreAgent(String offreAgent) {
        this.offreAgent = offreAgent;
    }

    public void setPhotochemin(String photochemin) {
        this.photochemin = photochemin;
    }


    public void setOffres(Set<Offre> offres) {
        this.offres = offres;
    }
     

    public AgentMedicalBean() {
    }
    
    
    
}