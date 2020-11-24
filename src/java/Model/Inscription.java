package Model;

import java.util.*;

public Inscription{
    private int id;
    private ArrayList<String> modules;
    public Inscription(){

    }

    public Inscription(int id,ArrayList<String> modules){
        this.modules=modules;
        this.id=id;
    }
    public ArrayList<String> GetModules(){
        return this.LastName;
    }
    
    public int GetId(){
        return this.id;
    }
    
    public void SetId(int id){
        this.id=id;
    }

    public void  SetModules(ArrayList<String> modules){
        this.modules=modules;
    }
}