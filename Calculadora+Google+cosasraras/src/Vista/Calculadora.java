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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author system
 */
public class Calculadora extends JFrame implements ActionListener {

    JButton calcula = new JButton("Calcular");
    JButton mas = new JButton("Mas cosas");
    
    JLabel n1 = new JLabel("Numero 1: ");
    JLabel n2 = new JLabel("Numero 2: ");

    JTextField n1_in = new JTextField();
    JTextField n2_in = new JTextField();

    JRadioButton sum = new JRadioButton("Suma");
    JRadioButton res = new JRadioButton("Resta");
    JRadioButton mul = new JRadioButton("Multiplica");
    JRadioButton div = new JRadioButton("Divide");
    
    ButtonGroup grupo = new ButtonGroup();
    JFrame content = new JFrame();
    
    

    final Color fondo = new Color(50, 230, 100);

    public Calculadora() {

        System.out.println("Andamos en la calculadora");

        
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
        
        
        n1_in.setBackground(fondo);
        n1_in.setBounds(150, 30, 100, 30);
        
        n2_in.setBackground(fondo);
        n2_in.setBounds(150, 100, 100, 30);
        
               
        sum.setBackground(fondo);
        sum.setBounds(100, 150, 100, 30);
        
        res.setBackground(fondo);
        res.setBounds(200, 150, 100, 30);
        
        mul.setBackground(fondo);
        mul.setBounds(300, 150, 100, 30);
        
        div.setBackground(fondo);
        div.setBounds(400, 150, 100, 30);
        
        calcula.setBackground(fondo);
        calcula.setBounds(150, 300, 100, 30);
        calcula.addActionListener(this);
        
        mas.setBackground(fondo);
        mas.setBounds(300, 300, 100, 30);
        mas.addActionListener(this);
        
        
        f.add(n1);
        f.add(n2);
        
        f.add(n1_in);
        f.add(n2_in);
        
        f.add(calcula);
        f.add(mas);
        
        f.add(sum);
        f.add(res);
        f.add(mul);
        f.add(div);
        
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        if(e.getSource()==mas)
        {
            content.dispose();
            serv s = new serv();
        }
        
        if(e.getSource()==calcula)
        {
            String num = n1_in.getText();
            String num2 = n2_in.getText();
            
            Calculado.Calc datoo = new Calculado.Calc(num,num2);
            
            if(sum.isSelected())
            {
                JOptionPane.showMessageDialog(content, datoo.suma());
            }
            
            if(res.isSelected())
            {
                JOptionPane.showMessageDialog(content, datoo.resta());
            }
            
            if(mul.isSelected())
            {
                JOptionPane.showMessageDialog(content, datoo.multiplica());
            }
            
            if(div.isSelected())
            {
                JOptionPane.showMessageDialog(content, datoo.divide());
            }
        }
        
    }

}
