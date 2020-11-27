/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tempo
 */
public class Note {
    private int noteR;
    private int noteO;
    private String EtudiantName;

    public Note() {
    }

    public Note(int noteR, int noteO, String EtudiantName) {
        this.noteR = noteR;
        this.noteO = noteO;
        this.EtudiantName = EtudiantName;
    }

    public int getNoteR() {
        return noteR;
    }

    public void setNoteR(int noteR) {
        this.noteR = noteR;
    }

    public int getNoteO() {
        return noteO;
    }

    public void setNoteO(int noteO) {
        this.noteO = noteO;
    }

    public String getNamModule() {
        return EtudiantName;
    }

    public void setNamModule(String EtudiantName) {
        this.EtudiantName = EtudiantName;
    }
    
    
    
}
