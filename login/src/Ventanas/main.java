/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 *
 * @author Alumno
 */
public class main extends JFrame implements ActionListener {

    JButton envia = new JButton("Eviar");
     JTextField nombre = new JTextField();
       JTextField Ap = new JTextField();
       JTextField Am = new JTextField();
       ButtonGroup group = new ButtonGroup();
        JRadioButton op1 = new JRadioButton("Si");
        JRadioButton op2 = new JRadioButton("No");
       
       int sexx = 0;
       
       final Color fondo = new Color(0,200,200); //Todos los colores de fondo ;)
    
    public main() {
       
        
        System.out.println("Desplegando");
        
        JFrame content = new JFrame();
        content.setBounds(100, 100, 600, 500);
        content.setVisible(true);
        content.setLayout(null);
        content.setTitle("Formulario");
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container f = content.getContentPane();
        
        
        
        f.setBackground(fondo);
        
        
        envia.setBounds(250, 350, 150 , 30);
        
       
        nombre.setBounds(20, 20, 150, 30);
        
      
        Ap.setBounds(20, 100, 150, 30);
        
        
        Am.setBounds(20, 180, 150, 30);
        
        
        
        
        JLabel nombre_lbl = new JLabel("Nombre");
        nombre_lbl.setBounds(170, 20, 100, 30);
        
        JLabel ap_lbl = new JLabel("Apellido Paterno");
        ap_lbl.setBounds(170, 100, 100, 30);
        
        JLabel am_lbl = new JLabel("Apellido Materno");
        am_lbl.setBounds(170, 180, 100, 30);
        
        JLabel enf = new JLabel ("Estas enfermo?");
        enf.setBounds(50, 250, 100, 30);
        
        
        
        JLabel genero = new JLabel("Escoge tu genero:");
        genero.setBounds(50, 300, 120, 30);
        
        
        
       
        op1.setBounds(150, 250, 50, 30);
        
        
        
        op2.setBounds(200, 250, 50, 30);
        
        
        
        
        
        
        //Llenado dinamico del comboBox
        
        
        String valor ="";
        try {
            BD.cDatos base = new BD.cDatos();
            base.conectar();
            
            ResultSet rs = base.consulta("call sp_sexo");
            
            while (rs.next())
                    {
                       valor += rs.getString("sex") + ",";
                    }
            
            String [] abc = valor.toString().split(",");
            
            JComboBox sexo = new JComboBox(abc);
             sexo.setBounds(200, 300, 150, 30);
             sexo.setBackground(fondo);
             f.add(sexo);
             
             sexx = sexo.getSelectedIndex();
             
             
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        //Termina llenado de combo...
        
        
        
        
//        String[] v = {"Masculino","Femenino"};
        
        
        
        op1.setBackground(fondo);
        op2.setBackground(fondo);
        
        
        group.add(op1);
        group.add(op2);
        
        f.add(Ap);
        f.add(nombre);
        f.add(Am);
        
        f.add(ap_lbl);
        f.add(am_lbl);
        f.add(nombre_lbl);
        f.add(enf);
        
        
        f.add(op1);
        f.add(op2);
        
        f.add(genero);
        
        f.add(envia);
        
        envia.addActionListener(this);
        
        
        
       
        
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == envia)
        {
            String nom,ap,am,enf ="";
            
            nom = nombre.getText();
            ap = Ap.getText();
            am = Am.getText();
            
            
             if(op1.isSelected())
             {
                 enf="Si";
             }
             else
             {
                enf="No";
                 
             }
            
            try {
                BD.cDatos sql = new BD.cDatos();
                sql.conectar();
                
                sql.consulta("call sp_alta('"+nom+"','"+ap+"','"+am+"','"+enf+"','"+sexx+"')");
                
            }
            catch (SQLException ex) {
                System.out.println(ex.toString());
            }
             
        }
        
    }
    
}
