package model;
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
     List<Map.Entry<Article, AgentMedical>> list;
     Map<Article, AgentMedical> map1;

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

    
     private Set commentaires = new HashSet(0);

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
        for(int i=0;i<Articles.size();i++) {
            map1.put(Articles.get(i), AgentMedicals.get(i));
        }
        list = mapToList(map1);
         
       session.getTransaction().commit();
       session.close();
       
      // return Articles;  
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

    public Set getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set commentaires) {
        this.commentaires = commentaires;
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
