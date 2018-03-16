<%-- 
    Document   : principal
    Created on : 07/02/2018, 12:31:33 PM
    Author     : hpe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
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
      <% 
          /*   <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script>
           
            $(document).ready(function(){
              $('#lo').click(function(){
                $("#a").load("Verificar_accidentado.jsp");
            });  
            
            $('#lo2').click(function(){
                $("#a").load("paciente.jsp");
            }); 
            });
            
           
        </script>
       
         */
      %>
        
        
    </head>
    <body >
        
        <%HttpSession sesion = request.getSession(); 
        
     
        String codigo=sesion.getAttribute("cod_per").toString();
     
        /* 
        out.print(sesion.getAttribute("cod_per"));
        out.print("<br>"+sesion.getAttribute("nombre"));
        out.print("<br>"+sesion.getAttribute("foto"));
        out.print("<br>"+sesion.getAttribute("foto2"));height="800"
        */
        if(codigo!=""){
        %>
        
        <div class="container">
            <div class="row">
                <div class="col ">
                    <nav class="navbar navbar-expand-md navbar-dark bg-primary mb-4">
                        <a class="navbar-brand " href="#">PORTAL MINSA</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarCollapse">
                          <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                              <a class="nav-link" href="#"> | <span class="sr-only">(current)</span></a>
                            </li>
                          </ul>
                            <a class="nav-item letrablanca" href="#">Nombre <%=sesion.getAttribute("nombre")%> Cod:     <%=sesion.getAttribute("cod_per")%>  <span class="sr-only">(current)</span></a>
                                
                        </div>
                    </nav>
                </div>
            </div>
        </div>
                            <div class="container ">
                                <div class="row">
                                    <div class="col-3 ">
                                        
                                        <div class="nav flex-column nav-pills fondominsa" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                          
                                            <a class="nav-link btnespacio" href="Verificar_accidentado.jsp" id="lo"  target="ventana">VERIFICAR ACCIDENTADO</a>
                                            <a class="nav-link btnespacio"  href="paciente.jsp" id="lo2" target="ventana" >HISTORIA CLINICA</a>
                                            <a class="nav-link btnespacio" href="index.jsp" id="lo3"  >CERRAR SESION</a>
                                            
                                          </div>
                                          
                                    </div>
                                    <div class="col">
                                        <div class="row">
                                            <div class="col">
                                                <iframe style="border: 0;" name="ventana" width="800" height="600"></iframe>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
   
            <%
            }else{

                  out.print("<script> location.replace('index.html')");
                 }

            %>
    </body>
</html>
