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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Administrateur generated by hbm2java
 */
@Entity
@Table(name="administrateur"
    ,catalog="pcd"
)
public class Administrateur  implements java.io.Serializable {


     private Integer idadmin;
     private String nomadmin;
     private String prenomadmin;
     private String emailadmin;
     private String passwordadmin;
     private Set<Statistique> statistiques = new HashSet<Statistique>(0);

    public Administrateur() {
    }

    public Administrateur(String nomadmin, String prenomadmin, String emailadmin, String passwordadmin, Set<Statistique> statistiques) {
       this.nomadmin = nomadmin;
       this.prenomadmin = prenomadmin;
       this.emailadmin = emailadmin;
       this.passwordadmin = passwordadmin;
       this.statistiques = statistiques;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idadmin", unique=true, nullable=false)
    public Integer getIdadmin() {
        return this.idadmin;
    }
    
    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    
    @Column(name="nomadmin")
    public String getNomadmin() {
        return this.nomadmin;
    }
    
    public void setNomadmin(String nomadmin) {
        this.nomadmin = nomadmin;
    }

    
    @Column(name="prenomadmin")
    public String getPrenomadmin() {
        return this.prenomadmin;
    }
    
    public void setPrenomadmin(String prenomadmin) {
        this.prenomadmin = prenomadmin;
    }

    
    @Column(name="emailadmin")
    public String getEmailadmin() {
        return this.emailadmin;
    }
    
    public void setEmailadmin(String emailadmin) {
        this.emailadmin = emailadmin;
    }

    
    @Column(name="passwordadmin")
    public String getPasswordadmin() {
        return this.passwordadmin;
    }
    
    public void setPasswordadmin(String passwordadmin) {
        this.passwordadmin = passwordadmin;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="admi_avoir_stat", catalog="pcd", joinColumns = { 
        @JoinColumn(name="idadmin", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idstat", nullable=false, updatable=false) })
    public Set<Statistique> getStatistiques() {
        return this.statistiques;
    }
    
    public void setStatistiques(Set<Statistique> statistiques) {
        this.statistiques = statistiques;
    }




}


