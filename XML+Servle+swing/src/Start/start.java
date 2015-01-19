/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.awt.EventQueue;

/**
 *
 * @author Alumno
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
          EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("a punto...");
                Vistas.Login go = new Vistas.Login();
            }

        });
        
        
    }
    
}
