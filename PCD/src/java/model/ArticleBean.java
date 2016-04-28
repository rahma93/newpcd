package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

@ManagedBean(name = "ArBean", eager = true)
@RequestScoped

public class ArticleBean {
    private List<Article> Articles;
    private List<AgentMedical> AgentMedicals;
     private Integer idarticle;

   
     private AgentMedical agentMedical;
     private Forum forum;
     private String articlecontent;
     private Date date1;
     private String nomarticle;
     private List<Commentaire> commentaires;
     private List<Forum> forums;
     List<Map.Entry<Article, AgentMedical>> list;
     Map<Article, AgentMedical> map1;
     List<Map.Entry<Article, List<Commentaire>>> list1;
      public List<Forum> getForums() {
        return forums;
    }

    public void setForums(List<Forum> forums) {
        this.forums = forums;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Map.Entry<Article, List<Commentaire>>> getList1() {
        return list1;
    }

    public void setList1(List<Map.Entry<Article, List<Commentaire>>> list1) {
        this.list1 = list1;
    }

    public Map<Article, List<Commentaire>> getMap2() {
        return map2;
    }

    public void setMap2(Map<Article, List<Commentaire>> map2) {
        this.map2 = map2;
    }
     Map<Article, List<Commentaire>> map2;

    public Map<Article, AgentMedical> getMap1() {
        return map1;
    }

    public void setMap1(Map<Article, AgentMedical> map1) {
        this.map1 = map1;
    }

    public List<Map.Entry<Article, AgentMedical>> getList() {
        return list;
    }

    public void setList(List<Map.Entry<Article, AgentMedical>> list) {
        this.list = list;
    }

    
    

    public ArticleBean() {
    }

    public ArticleBean(List<Article> Articles, List<AgentMedical> AgentMedicals, Integer idarticle, AgentMedical agentMedical, Forum forum, String articlecontent, Date date1, String nomarticle) {
        this.Articles = Articles;
        this.AgentMedicals = AgentMedicals;
        this.idarticle = idarticle;
        this.agentMedical = agentMedical;
        this.forum = forum;
        this.articlecontent = articlecontent;
        this.date1 = date1;
        this.nomarticle = nomarticle;
    }

    public List<AgentMedical> getAgentMedicals() {
        return AgentMedicals;
    }

    public void setAgentMedicals(List<AgentMedical> AgentMedicals) {
        this.AgentMedicals = AgentMedicals;
    }

    public String getNomarticle() {
        return nomarticle;
    }

    public void setNomarticle(String nomarticle) {
        this.nomarticle = nomarticle;
    }
    
     
      @PostConstruct
     public void affichearticles(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Articles = session.createQuery("from Article").list(); 
        AgentMedicals = session.createQuery("select agentMedical from Article ").list();
        map1 = new HashMap();
        map2 = new HashMap();
        for(int i=0;i<Articles.size();i++) {
            commentaires=session.createQuery("from Commentaire as comm\n" +
           "where comm.article.idarticle = '"+Articles.get(i).getIdarticle()+"'").list();
            map2.put(Articles.get(i), commentaires);
            map1.put(Articles.get(i), AgentMedicals.get(i));
        }
        list = mapToList(map1);
        list1 = mapToList(map2);
         
       session.getTransaction().commit();
       session.close();
       
      // return Articles;  
    }
    
     
    public String savearticle()
    {       
        Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                FacesContext fc = FacesContext.getCurrentInstance();
                String email = (String)fc.getApplication().createValueBinding("#{user.emailagent}").getValue(fc);
		//AgentMedicalDAO userDao = new AgentMedicalDAO();
		forums = session.createQuery("from Forum").list(); 
                forum =forums.get(0);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
               /* Map<String, Object> sessionMap = externalContext.getSessionMap();
                sessionMap.put("somekey", agent);*/
                //AgentMedical agentMedical, Forum forum, String nomarticle, String articlecontent, Date date1, Set commentaires
                List<AgentMedical> agentMedicals;
                agentMedicals = session.createQuery("from AgentMedical as agent\n" +"where  agent.emailagent = '"+email+"'").list();
		agentMedical = agentMedicals.get(0);
                Article article = new Article(agentMedical,forum,nomarticle,articlecontent,date1,null);
                session.save(article);
                
                
                
                session.getTransaction().commit();
		session.close();
		
		return "blog";
    }
    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> Articles) {
        this.Articles = Articles;
    }

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public AgentMedical getAgentMedical() {
        return agentMedical;
    }

    public void setAgentMedical(AgentMedical agentMedical) {
        this.agentMedical = agentMedical;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public ArticleBean(List<Article> Articles, Integer idarticle, AgentMedical agentMedical, Forum forum, String articlecontent, Date date1) {
        this.Articles = Articles;
        this.idarticle = idarticle;
        this.agentMedical = agentMedical;
        this.forum = forum;
        this.articlecontent = articlecontent;
        this.date1 = date1;
    }
     
    public static <T, S> List<Map.Entry<T, S>> mapToList(Map<T, S> map) {

    if (map == null) {
        return null;
    }

    List<Map.Entry<T, S>> list = new ArrayList<Map.Entry<T, S>>();
    list.addAll(map.entrySet());

    return list;
}
    
}
