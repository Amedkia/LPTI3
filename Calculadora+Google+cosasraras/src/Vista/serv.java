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

/**
 *
 * @author system
 */
public class serv extends JFrame implements ActionListener {

    JButton fb = new JButton("A feisbukk");
    JButton gogl = new JButton("A IzziZoft");
    JButton otro = new JButton("A otro servlet");
    JButton regresa = new JButton("Esto es del diablo");
    JFrame content = new JFrame();

    final Color fondo = new Color(50, 230, 100);

    public serv() {

        System.out.println("Aguantalas...");

        
        content.setBounds(100, 100, 600, 500);
        content.setVisible(true);
        content.setLayout(null);
        content.setTitle("Mas Opciones");
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container f = content.getContentPane();

        f.setBackground(fondo);

        fb.setBounds(100, 100, 300, 30);
        gogl.setBounds(100, 200, 300, 30);
        otro.setBounds(100, 300, 300, 30);
        regresa.setBounds(100, 400, 300, 30);

        fb.addActionListener(this);
        gogl.addActionListener(this);
        otro.addActionListener(this);
        regresa.addActionListener(this);

        f.add(fb);
        f.add(gogl);
        f.add(otro);
        f.add(regresa);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fb) {
            System.out.println("Algo raro pasa");
            try {

                Desktop.getDesktop().browse(new URI("http://localhost:8080/OtroServlet/servlet?op=3"));

            } catch (URISyntaxException | IOException ex) {

                System.out.println(ex);

            }
        }

        if (e.getSource() == gogl) {
            System.out.println("Algo raro pasa");
            try {

                Desktop.getDesktop().browse(new URI("http://localhost:8080/OtroServlet/servlet?op=1"));

            } catch (URISyntaxException | IOException ex) {

                System.out.println(ex);

            }
        }

        if (e.getSource() == otro) {
            System.out.println("Algo raro pasa");
            try {

                Desktop.getDesktop().browse(new URI("http://localhost:8080/OtroServlet/servlet"));

            } catch (URISyntaxException | IOException ex) {

                System.out.println(ex);

            }
        }

        if (e.getSource() == regresa) {
            System.out.println("Algo raro pasa");

           content.dispose();
            Calculadora c = new Calculadora();
        }
    }

}
