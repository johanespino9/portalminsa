/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidad.consulta;
import entidad.contacto;
import entidad.ingreso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

/**
 *
 * @author hpe
 */
public class contactos {
    
  public List<contacto> LisProducto(String dni){
 List<contacto> lis=new ArrayList<contacto>();
 
 try{

String sql=" select nombre,apellido,edad,foto from reniec where dni=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, dni);

ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
	 // pro a=new pro(,);
         //ingreso ver=new ingreso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
         contacto ver=new contacto(rs.getString(1), rs.getString(2), rs.getString(3),rs.getBytes(4));
         
         lis.add(ver);
	
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return lis;	
}  
  public List<consulta> consultaDni(String dni){
 List<consulta> lis=new ArrayList<consulta>();
 
 try{

String sql=" select ree.dia_ing,ree.hora_ing,ree.dia_fin,ree.hora_fin,hos.nombre_hos,ree.enfermedad\n" +
"   from registro ree inner join hospital hos\n" +
"   on hos.cod_hos=ree.cod_hos\n" +
"   where ree.dni=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, dni);

ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
	 // pro a=new pro(,);
         //ingreso ver=new ingreso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        // consulta ver=new consulta(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
         consulta ver=new consulta(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
         lis.add(ver);
	
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return lis;	
} 
  
 
  public List<contacto> C_emergencia(String dni){
 List<contacto> lis=new ArrayList<contacto>();
 
 try{

String sql=" select nombre,apellido,tipo,celular,correo from contactos where dni=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, dni);

ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
	 // pro a=new pro(,);
         //ingreso ver=new ingreso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
         contacto ver=new contacto(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5));
         
         lis.add(ver);
	
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return lis;	
} 
  
  public String inden(String dni){
String c="";
 
 try{

String sql=" select dni from reniec where dni=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, dni);

ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
	
    c=rs.getString(1);
	
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return c;	
}  
}
