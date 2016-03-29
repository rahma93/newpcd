package model;
// Generated 29 mars 2016 13:18:27 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Statistique generated by hbm2java
 */
public class Statistique  implements java.io.Serializable {


     private Integer idstat;
     private Set<Administrateur> administrateurs = new HashSet<Administrateur>(0);

    public Statistique() {
    }

    public Statistique(Set<Administrateur> administrateurs) {
       this.administrateurs = administrateurs;
    }
   
    public Integer getIdstat() {
        return this.idstat;
    }
    
    public void setIdstat(Integer idstat) {
        this.idstat = idstat;
    }
    public Set<Administrateur> getAdministrateurs() {
        return this.administrateurs;
    }
    
    public void setAdministrateurs(Set<Administrateur> administrateurs) {
        this.administrateurs = administrateurs;
    }




}


