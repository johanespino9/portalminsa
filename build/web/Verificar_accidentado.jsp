<%-- 
    Document   : Verificar_accidentado
    Created on : 20/02/2018, 06:56:29 PM
    Author     : hpe
--%>

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
    <body class="fondominsa">
        <%
           
          String fdnii=request.getParameter("fdni");
          String fhuella=request.getParameter("fhue");
        if(fdnii==null && fhuella==null){
        %>
    <center>
        
        <h4 style="color: white;">Ingreso "DNI" o "HUELLA"</h4>
        <div id="primero" class="primero1">
            <table class="table" >
                <tr><th class="col" colspan="2" >
                <tr>
                    <th class="col">
                        <div class="container">
                            <div class="row">
                                <div class="col offset-2">
                                    <form action="Verificar_accidentado.jsp" method="post"><input type="submit" value="DNI" class="dnih" name="fdni"></form>
                                </div>
                                <div class="col offset-3">
                                    <form action="R_huella" method="post"><input type="submit" value="HUELLA" class="dnihh" name="fhue"></form>
                                </div>
                            </div>
                        </div>
                            
                    
            </table>
            
        </div>
        <%
      
        
        }else{


if(fdnii.equals("DNI")==true){


%> 
<center>    <div class="registro">
        <form action="verificar" method="post">  <h4 style="color: white;">Ingrese su numero de DNI° :</h4> <input type="text" name="textDNI"> <input type="submit" value="Enviar"></form>
             
        </div>

</center>
        
        
        <%
}
      }     
        
        %>
        
        </center>
    </body>
</html>
