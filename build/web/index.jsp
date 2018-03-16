<%-- 
    Document   : index
    Created on : 08/03/2018, 12:28:22 PM
    Author     : parra
--%>

<%@page import="entidad.ingreso"%>
<%@page import="controlador.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Sistema Biométrico de Identificación</title>
    <link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  </head>
  <body>
      <header>
          
      </header>
      <div class="container fondocentrado" >
          <div class="row margenes">
              <div class="col-4 offset-4 margenes" >
                  <form class="form-signin" method="post" action="index.jsp">
                    <div class="text-center mb-4">
                      <img class="mb-4" src="img/paramedic-logo.png" alt="" width="72" height="72">
                        <h1 class="letrablanca mb-3 ">Identificación</h1>
                      
                    </div>

                    <div class="form-label-group">
                      <input  id="inputEmail"  placeholder="DNI" name="usu">
                      <label for="inputEmail">Email address</label>
                    </div>

                    <div class="form-label-group">
                      <input type="password" id="inputPassword" name="pas" placeholder="Password" required>
                      <label for="inputPassword">Password</label>
                    </div>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Ingresar" name="btnIngresar">
                  </form>
              </div>
          </div>    
      </div>
      
       
      <%
       bd op=new bd();
       HttpSession sesion = request.getSession(); 
       if(request.getParameter("btnIngresar")!=null){
           String nombre=request.getParameter("usu");
           String pass=request.getParameter("pas");
          for(ingreso x:op.LisProducto(nombre, pass)){
           if(nombre.equalsIgnoreCase(x.getCodigo()) && pass.equalsIgnoreCase(x.getContra1())){
               sesion.setAttribute("cod_per", x.getCod_per());
               sesion.setAttribute("nombre", x.getNombre());
               response.sendRedirect("principal.jsp");
              break;
           }else{
            response.sendRedirect("index.jsp");
           }
       }
          
          
        
          
       }

      %>
  </body>
</html>
