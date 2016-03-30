package model;
// Generated 30 mars 2016 10:59:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Membre generated by hbm2java
 */
@Entity
@Table(name="membre"
    ,catalog="pcd"
)
public class Membre  implements java.io.Serializable {


     private Integer idmembre;
     private String nommembre;
     private String prenommembre;
     private String pseudomembre;
     private String emailmembre;
     private String passwordmembre;
     private Integer numtelmembre;
     private Set<MembreDonnerNote> membreDonnerNotes = new HashSet<MembreDonnerNote>(0);
     private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);

    public Membre() {
    }

    public Membre(String nommembre, String prenommembre, String pseudomembre, String emailmembre, String passwordmembre, Integer numtelmembre, Set<MembreDonnerNote> membreDonnerNotes, Set<Commentaire> commentaires) {
       this.nommembre = nommembre;
       this.prenommembre = prenommembre;
       this.pseudomembre = pseudomembre;
       this.emailmembre = emailmembre;
       this.passwordmembre = passwordmembre;
       this.numtelmembre = numtelmembre;
       this.membreDonnerNotes = membreDonnerNotes;
       this.commentaires = commentaires;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idmembre", unique=true, nullable=false)
    public Integer getIdmembre() {
        return this.idmembre;
    }
    
    public void setIdmembre(Integer idmembre) {
        this.idmembre = idmembre;
    }

    
    @Column(name="nommembre")
    public String getNommembre() {
        return this.nommembre;
    }
    
    public void setNommembre(String nommembre) {
        this.nommembre = nommembre;
    }

    
    @Column(name="prenommembre")
    public String getPrenommembre() {
        return this.prenommembre;
    }
    
    public void setPrenommembre(String prenommembre) {
        this.prenommembre = prenommembre;
    }

    
    @Column(name="pseudomembre")
    public String getPseudomembre() {
        return this.pseudomembre;
    }
    
    public void setPseudomembre(String pseudomembre) {
        this.pseudomembre = pseudomembre;
    }

    
    @Column(name="emailmembre")
    public String getEmailmembre() {
        return this.emailmembre;
    }
    
    public void setEmailmembre(String emailmembre) {
        this.emailmembre = emailmembre;
    }

    
    @Column(name="passwordmembre")
    public String getPasswordmembre() {
        return this.passwordmembre;
    }
    
    public void setPasswordmembre(String passwordmembre) {
        this.passwordmembre = passwordmembre;
    }

    
    @Column(name="numtelmembre")
    public Integer getNumtelmembre() {
        return this.numtelmembre;
    }
    
    public void setNumtelmembre(Integer numtelmembre) {
        this.numtelmembre = numtelmembre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="membre")
    public Set<MembreDonnerNote> getMembreDonnerNotes() {
        return this.membreDonnerNotes;
    }
    
    public void setMembreDonnerNotes(Set<MembreDonnerNote> membreDonnerNotes) {
        this.membreDonnerNotes = membreDonnerNotes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="membre")
    public Set<Commentaire> getCommentaires() {
        return this.commentaires;
    }
    
    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }




}

