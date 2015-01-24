/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author system
 */
public class login extends JFrame implements ActionListener {

    final Color fondo = new Color(220, 170, 60);

    JButton entrar = new JButton("Entrar");
    JButton reg = new JButton("No tengo cuenta");

    JTextField usr = new JTextField();
    JLabel lbl_usr = new JLabel("Usuario");
    JPasswordField pwd = new JPasswordField();
    JLabel lbl_pwd = new JLabel("Contraseña");
    
    JFrame content = new JFrame();

    public login() {

        System.out.println("Andamos en el login");

        content.setBounds(100, 100, 500, 300);
        content.setVisible(true);
        content.setLayout(null);
        content.setTitle("Login");
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container f = content.getContentPane();

        f.setBackground(fondo);
        
        entrar.setBackground(fondo);
        entrar.setBounds(100, 150, 100, 30);
        entrar.addActionListener(this);
        
        reg.setBackground(fondo);
        reg.setBounds(250, 150, 200, 30);
        reg.addActionListener(this);
        
        
        usr.setBackground(fondo);
        usr.setBounds(150, 20, 100, 30);
        
        pwd.setBackground(fondo);
        pwd.setBounds(150, 60, 100, 30);
        
        lbl_usr.setBackground(fondo);
        lbl_usr.setBounds(270, 20, 100, 30);
        
        lbl_pwd.setBackground(fondo);
        lbl_pwd.setBounds(270, 60, 100, 30);
        
        f.add(entrar);
        f.add(reg);
        f.add(usr);
        f.add(pwd);
        f.add(lbl_usr);
        f.add(lbl_pwd);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==entrar)
        {
            String u = usr.getText();
            String p = pwd.getText();
            
            Crypto.Crypter16914 cryp = new Crypto.Crypter16914(); //Clase que cifra mediante cifrado cesar Distinguiendo Mayusculas de Minusculas
            
            String u_cryp = cryp.code(u);
            String p_cryp = cryp.code(p);
            
            
            
            
            logic.login entra = new logic.login(); //clase que prueba el nombre y la contraseña
            
            boolean ok = entra.ingresa(u_cryp,p_cryp);
            
            if(ok)
            {
                content.dispose();
                Calculadora cal = new Calculadora();
            }
            else
            {
                JOptionPane.showMessageDialog(content, "Error");
            }
        }
        
        if(e.getSource()==reg)
        {
             try {

                Desktop.getDesktop().browse(new URI("http://localhost:8080/calculadora_cosasraras/reg.html"));

            } catch (URISyntaxException | IOException ex) {

                System.out.println(ex);

            }
        }

    }

}
