package Model;

import java.util.*;

public class Inscription{
    private int idSemister;
    private ArrayList<String> modules;
    public Inscription(){

    }

    public Inscription(int idSemister,ArrayList<String> modules){
        this.modules=modules;
        this.idSemister=idSemister;
    }
    public ArrayList<String> GetModules(){
        return this.modules;
    }
    
    public int GetId(){
        return this.idSemister;
    }
    
    public void SetId(int idSemister){
        this.idSemister=idSemister;
    }

    public void  SetModules(ArrayList<String> modules){
        this.modules=modules;
    }
}