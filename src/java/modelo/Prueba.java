/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Color;
        
import java.awt.Desktop; 

import java.net.URI; 

import java.io.IOException;

class Prueba implements ActionListener
 {
    JFrame ventana = new JFrame();
          
    JLabel etiqueta = new JLabel ("  Pulse el boton para enviar correo");
          
    JButton boton = new JButton("Aceptar");
          
 Prueba()
 {
   ventana.setSize(350,350);
   
   ventana.setLayout(null);
   
   etiqueta.setBounds (60,60,250,20);
   
   boton.setBounds (110,150,100,30); 
   
   ventana.add(etiqueta);
   
   ventana.add(boton);
             
   ventana.getContentPane().setBackground(new Color(144, 238, 144 ));
   
   boton.addActionListener(this);
        
   ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
   ventana.setLocationRelativeTo(null);
        
   ventana.setVisible(true);
   
 }        
    
 public void actionPerformed(ActionEvent e)
 {
    if(e.getSource() == boton)
     {
       String correo = JOptionPane.showInputDialog(null,"Introduzca la direccion de correo electronico");

	 try { 
               
              URI correo_electronico = URI.create("mailto:" + correo);
            
              Desktop escritorio = null; 
              
	        if (Desktop.isDesktopSupported()) 
                { 
	          escritorio = Desktop.getDesktop(); 
	        } 
	  
	        if (escritorio != null)
                  
	          escritorio.mail(correo_electronico); 
              
	    } catch (IOException io) { 
	                               io.printStackTrace(); 
                                     } 
    }
 }
       public static void main(String[] arg) 
  { 
    new Prueba();
  }
}
