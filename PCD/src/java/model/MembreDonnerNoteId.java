package model;
// Generated 30 mars 2016 10:59:16 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MembreDonnerNoteId generated by hbm2java
 */
@Embeddable
public class MembreDonnerNoteId  implements java.io.Serializable {


     private int idmembre;
     private int idnote;

    public MembreDonnerNoteId() {
    }

    public MembreDonnerNoteId(int idmembre, int idnote) {
       this.idmembre = idmembre;
       this.idnote = idnote;
    }
   


    @Column(name="idmembre", nullable=false)
    public int getIdmembre() {
        return this.idmembre;
    }
    
    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }


    @Column(name="idnote", nullable=false)
    public int getIdnote() {
        return this.idnote;
    }
    
    public void setIdnote(int idnote) {
        this.idnote = idnote;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MembreDonnerNoteId) ) return false;
		 MembreDonnerNoteId castOther = ( MembreDonnerNoteId ) other; 
         
		 return (this.getIdmembre()==castOther.getIdmembre())
 && (this.getIdnote()==castOther.getIdnote());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdmembre();
         result = 37 * result + this.getIdnote();
         return result;
   }   


}

