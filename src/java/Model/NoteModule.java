/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mohammed
 */
public class NoteModule {
    private int id;
    private String abs;
    private double noteOr;
    private double noteRat;

    public NoteModule() {
    }

    public NoteModule(int id, String abs) {
        this.id = id;
        this.abs = abs;
    }

    public NoteModule(int id, String abs, double noteOr, double noteRat) {
        this.id = id;
        this.abs = abs;
        this.noteOr = noteOr;
        this.noteRat = noteRat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public double getNoteOr() {
        return noteOr;
    }

    public void setNoteOr(double noteOr) {
        this.noteOr = noteOr;
    }

    public double getNoteRat() {
        return noteRat;
    }

    public void setNoteRat(double noteRat) {
        this.noteRat = noteRat;
    }
    
}
