/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohammed
 */
public class Traitement {

    public List<User> GetUsers() {
        List<User> users = new ArrayList();

        return users;
    }

    public void readBD(String url, String motRoot, String motItems) throws IOException {
        
        try (BufferedReader in = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<" + motRoot)) {
                    if (line.contains("<" + motItems)) {
                        
                    }
                }

            }
        }

    }

}
