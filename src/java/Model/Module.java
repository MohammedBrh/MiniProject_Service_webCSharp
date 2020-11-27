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
public class Module {
    private int id;
    private int SemesterId;
    private String name;

    public Module() {
    }

    public Module(int id, int SemesterId, String name) {
        this.id = id;
        this.SemesterId = SemesterId;
        this.name = name;
    }

    public int getSemesterId() {
        return SemesterId;
    }

    public void setSemesterId(int SemesterId) {
        this.SemesterId = SemesterId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
