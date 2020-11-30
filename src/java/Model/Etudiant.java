/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tempo
 */
public class Etudiant {
    private int id;
    private String prenom;
    private String password;
    private String nom;
    private List<Module> Module = new ArrayList<Module>();

    public Etudiant() {
    }

    public Etudiant(int id, String prenom, String password, String nom,List<Module> Module) {
        this.id = id;
        this.prenom = prenom;
        this.password = password;
        this.nom = nom;
        this.Module = Module;
        
    }
    public Etudiant(int id, String prenom, String password, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.password = password;
        this.nom = nom;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Module> getModule() {
        return Module;
    }

    public void setModule(List<Module> Module) {
        this.Module = Module;
    }
    
    

    

    
    
    
    
}
