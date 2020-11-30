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
    private String moduleName;

    public Note(int noteR, int noteO, String EtudiantName, String moduleName) {
        this.noteR = noteR;
        this.noteO = noteO;
        this.EtudiantName = EtudiantName;
        this.moduleName = moduleName;
    }

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

    public String getEtudiantName() {
        return EtudiantName;
    }

    public void setEtudiantName(String EtudiantName) {
        this.EtudiantName = EtudiantName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getNoteO() {
        return noteO;
    }

    public void setNoteO(int noteO) {
        this.noteO = noteO;
    }

    public String getNamModule() {
        return moduleName;
    }

    public void setNamModule(String EtudiantName) {
        this.EtudiantName = EtudiantName;
    }
    
    
    
}
