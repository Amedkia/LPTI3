/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author system
 */
public class login extends JFrame implements ActionListener {
    
    
    final Color fondo = new Color(50, 230, 100);

    public login() {

        System.out.println("Aguantalas...");

        JFrame content = new JFrame();
        content.setBounds(100, 100, 600, 500);
        content.setVisible(true);
        content.setLayout(null);
        content.setTitle("Login");
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container f = content.getContentPane();

        f.setBackground(fondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
