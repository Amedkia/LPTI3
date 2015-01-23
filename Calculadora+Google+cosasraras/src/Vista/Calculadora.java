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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author system
 */
public class Calculadora extends JFrame implements ActionListener {

    JButton calcula = new JButton("Calcular");
    JLabel n1 = new JLabel("Numero 1: ");
    JLabel n2 = new JLabel("Numero 2: ");

    JTextField n1_in = new JTextField();
    JTextField n2_in = new JTextField();

    JRadioButton sum = new JRadioButton("Suma");
    JRadioButton res = new JRadioButton("Resta");
    JRadioButton mul = new JRadioButton("Multiplica");
    JRadioButton div = new JRadioButton("Divide");
    
    ButtonGroup grupo = new ButtonGroup();
    
    

    final Color fondo = new Color(50, 230, 100);

    public Calculadora() {

        System.out.println("Aguantalas...");

        JFrame content = new JFrame();
        content.setBounds(100, 100, 600, 500);
        content.setVisible(true);
        content.setLayout(null);
        content.setTitle("Calculadora Sexy");
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container f = content.getContentPane();

        f.setBackground(fondo);
        
        grupo.add(sum);
        grupo.add(res);
        grupo.add(mul);
        grupo.add(div);
        
        n1.setBounds(30, 30, 100, 30);
        n2.setBounds(30, 100, 100, 30);
        
        n1.setBackground(fondo);
        n2.setBackground(fondo);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
