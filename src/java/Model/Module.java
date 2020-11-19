/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author Mohammed
 */
public class Module {
    private int idModule;
   private List<NoteModule> noteModule=new ArrayList();

    public Module() {
    }

    public Module(int idModule) {
        this.idModule = idModule;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public List<NoteModule> getNoteModule() {
        return noteModule;
    }

    public void setNoteModule(List<NoteModule> noteModule) {
        this.noteModule = noteModule;
    }
    
    
    
}
