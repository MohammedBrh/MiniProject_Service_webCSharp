package Model;

import java.util.*;


public class Etudiant {
    Private int id;
    Private String password;
    Private String FirstName;
    Private String LastName;
    Private Inscription inscription;

    public Etudiant(){

    }

    public Etudiant(int id,String password,String FirstName,String LAstName,Inscription inscription){
        this.id=id;
        this.password=password;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.inscription = new Inscription(inscription.GetId,inscription.getModules);

    }

    public int GetId(){
        return this.id;
    }
    
    public String GetPassword(){
        return this.password;
    }
    
    public String GetFirstName(){
        return this.FirstName;
    }
    
    public String GetLastName(){
        return this.LastName;
    }
    vv
    public Inscription GetInscription(){
        return this.inscription;
    }

    public void SetInscription(Inscription inscription){
        this.inscription=inscription;
    }

    public void SetId(int id){
        this.id=id;
    }
    public void SetFirstName(String FirstName){
        this.FirstName=FirstName;
    }
    public void SetLastName(String LastName){
        this.LastName=LastName;
    }
    public void SetPassword(String password){
        this.password=password;
    }

}