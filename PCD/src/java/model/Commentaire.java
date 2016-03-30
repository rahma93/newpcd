package model;
// Generated 30 mars 2016 10:59:16 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Commentaire generated by hbm2java
 */
@Entity
@Table(name="commentaire"
    ,catalog="pcd"
)
public class Commentaire  implements java.io.Serializable {


     private Integer idcommentaire;
     private AgentMedical agentMedical;
     private Article article;
     private Membre membre;
     private String commentairecontent;

    public Commentaire() {
    }

    public Commentaire(AgentMedical agentMedical, Article article, Membre membre, String commentairecontent) {
       this.agentMedical = agentMedical;
       this.article = article;
       this.membre = membre;
       this.commentairecontent = commentairecontent;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcommentaire", unique=true, nullable=false)
    public Integer getIdcommentaire() {
        return this.idcommentaire;
    }
    
    public void setIdcommentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idagent")
    public AgentMedical getAgentMedical() {
        return this.agentMedical;
    }
    
    public void setAgentMedical(AgentMedical agentMedical) {
        this.agentMedical = agentMedical;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idarticle")
    public Article getArticle() {
        return this.article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idmembre")
    public Membre getMembre() {
        return this.membre;
    }
    
    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    
    @Column(name="commentairecontent")
    public String getCommentairecontent() {
        return this.commentairecontent;
    }
    
    public void setCommentairecontent(String commentairecontent) {
        this.commentairecontent = commentairecontent;
    }




}


