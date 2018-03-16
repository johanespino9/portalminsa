<%-- 
    Document   : paciente
    Created on : 14/02/2018, 01:34:51 PM
    Author     : hpe
--%>

<%@page import="entidad.consulta"%>
<%@page import="modelo.contactos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       
        <link rel="stylesheet" href="css/styles.css"> 
       
    </head>
    <body class="fondominsa"> <%
       
      
      
             
           
            
        %>
    <center>
       
       
        <form  class="margenes letrablanca" method="post" action="paciente.jsp">
      Ingrese DNI: <input name="dnii"> <input type="submit" value="enviar">
        </form>
        
        <table class="table letrablanca" >
        <%
        
        String dni=request.getParameter("dnii");
           List<contacto> lis=new ArrayList<contacto>();
         contactos ver=new contactos();
      
         lis=ver.LisProducto(dni);

         for(contacto x:lis){
             
             %>
             <tr><th scope="col" colspan="2"><center>Paciente</center>
            <tr><th scope="col"><%=x.getNombre()%><th rowspan="3"><a href="imagen?id=<%=dni %>" target="_bl">Ver Foto</a> <br><iframe name="_bl" width="280" height="250"></iframe>
             <tr><th scope="col"><%=x.getApellido()%>
            <tr> <th scope="col"><%=x.getEdad()%> 
        
         
         <%
         }
        %>
         </table> 
         <br>
         <br>
         <br>
         <br>
         <table class="table letrablanca" >
             
             <% 
                 int t=0;
             for(consulta j:ver.consultaDni(dni)){
                if(t==0){
                %>
                <tr><th>Dia de Ingreso<th>Hora de Ingreso<th>Dia de Salida<th>Hora de Salida<th>Hospital Internado<th>Enfermedad
                <%
                    t++;
                }
             %>
             
             <tr><td><%=j.getDia_ini()%><td><%=j.getHora_ini()%><td><%=j.getDia_fin()%><td><%=j.getHora_fin()%><td><%= j.getHospital()%><td><%=j.getEnfermedad()%>
             
             <%
             
             }
             
             %>
             
             
             
        </table>
        <%
 
   
    %> 
      
    </center>
   
    </body>
</html>
