/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.ingreso;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.SQLConexion;

/**
 *
 * @author hpe
 */
public class bd {
   
    
    
     public List<ingreso> LisProducto(String usu,String pas){
 List<ingreso> lis=new ArrayList<ingreso>();
 try{

String sql=" select  per.cod_per,per.nombre,usu.cod_usu,usu.contra1,per.foto\n" +
"  from  usuario usu inner join personal per\n" +
"  on usu.cod_per=per.cod_per \n" +
"  where usu.cod_usu=? and usu.contra1=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, usu);
st.setString(2, pas);
ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
	 // pro a=new pro(,);
         //ingreso ver=new ingreso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
         ingreso ver=new ingreso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBlob(5));
         
         lis.add(ver);
	
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return lis;	
}
}
