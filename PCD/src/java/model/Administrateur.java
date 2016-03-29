package model;
// Generated 29 mars 2016 13:18:27 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Administrateur generated by hbm2java
 */
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
   
    public Integer getIdadmin() {
        return this.idadmin;
    }
    
    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }
    public String getNomadmin() {
        return this.nomadmin;
    }
    
    public void setNomadmin(String nomadmin) {
        this.nomadmin = nomadmin;
    }
    public String getPrenomadmin() {
        return this.prenomadmin;
    }
    
    public void setPrenomadmin(String prenomadmin) {
        this.prenomadmin = prenomadmin;
    }
    public String getEmailadmin() {
        return this.emailadmin;
    }
    
    public void setEmailadmin(String emailadmin) {
        this.emailadmin = emailadmin;
    }
    public String getPasswordadmin() {
        return this.passwordadmin;
    }
    
    public void setPasswordadmin(String passwordadmin) {
        this.passwordadmin = passwordadmin;
    }
    public Set<Statistique> getStatistiques() {
        return this.statistiques;
    }
    
    public void setStatistiques(Set<Statistique> statistiques) {
        this.statistiques = statistiques;
    }




}


