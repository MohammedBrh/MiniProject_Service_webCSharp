package Model;

import java.util.*;


public class Etudiant {
    private int id;
    private String password;
    private String FirstName;
    private String LastName;
    private Inscription inscription;

    public Etudiant(){

    }

    public Etudiant(int id, String password, String FirstName, String LastName, Inscription inscription) {
        this.id = id;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.inscription = inscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
    
    




}