package model;
// Generated 24 avr. 2016 23:55:02 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * MembreDonnerNote generated by hbm2java
 */
public class MembreDonnerNote  implements java.io.Serializable {


     private MembreDonnerNoteId id;
     private Membre membre;
     private Note note;
     private Date date1;

    public MembreDonnerNote() {
    }

	
    public MembreDonnerNote(MembreDonnerNoteId id, Membre membre, Note note) {
        this.id = id;
        this.membre = membre;
        this.note = note;
    }
    public MembreDonnerNote(MembreDonnerNoteId id, Membre membre, Note note, Date date1) {
       this.id = id;
       this.membre = membre;
       this.note = note;
       this.date1 = date1;
    }
   
    public MembreDonnerNoteId getId() {
        return this.id;
    }
    
    public void setId(MembreDonnerNoteId id) {
        this.id = id;
    }
    public Membre getMembre() {
        return this.membre;
    }
    
    public void setMembre(Membre membre) {
        this.membre = membre;
    }
    public Note getNote() {
        return this.note;
    }
    
    public void setNote(Note note) {
        this.note = note;
    }
    public Date getDate1() {
        return this.date1;
    }
    
    public void setDate1(Date date1) {
        this.date1 = date1;
    }




}


