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
 * Offre generated by hbm2java
 */
@Entity
@Table(name="offre"
    ,catalog="pcd"
)
public class Offre  implements java.io.Serializable {


     private Integer idoffre;
     private Profil profil;
     private String offrenom;

    public Offre() {
    }

    public Offre(Profil profil, String offrenom) {
       this.profil = profil;
       this.offrenom = offrenom;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idoffre", unique=true, nullable=false)
    public Integer getIdoffre() {
        return this.idoffre;
    }
    
    public void setIdoffre(Integer idoffre) {
        this.idoffre = idoffre;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idprofil")
    public Profil getProfil() {
        return this.profil;
    }
    
    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    
    @Column(name="offrenom")
    public String getOffrenom() {
        return this.offrenom;
    }
    
    public void setOffrenom(String offrenom) {
        this.offrenom = offrenom;
    }




}


