<%--

    Document   : mapa
    Created on : 14/02/2018, 01:21:10 PM
    Author     : hpe

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script type="text/javascript" <script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAeYfac5fo2bMFDvE9sFGAeF-a_qyjo2so&callback=fn_mal">
    </script>>
                
            
            
        </script>
    </head>
    <body>
      
        <h1>Prueba</h1>
        <div id="mapa" style="width: 700px; height: 500px;">
            --Aca va nuestro Mapa
            
        </div>
        
        
    </body><script type="text/javascript">
            var divMapa=document.getElementById("mapa");
            navigator.geolocation.getCurrentPosition(fn_ok,fn_mal);
        function fn_mal(){}
        function fn_ok( rta ){
         var lat=rta.coords.latitude;
         var lon=rta.coords.longitude;
         var glatLon=new google.maps.LatLng(lat,lon);
         var.objConfing={
             zoom:17,
             center:gLatLon;
         }
           var gMapa=new google.maps.Map( divMapa, objConfing); 
        }
        </script>
</html>
