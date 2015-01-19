/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class servlets {

    public String[] llena_combo(String raiz,String papa) {
        String[] value = null;

        try {
            URL url = new URL("http://localhost:8084/Servlets/xml");

            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(url.openStream())
                );
                
                
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(servlets.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

}
