package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("       \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\"> \n");
      out.write("      ");
 
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
      
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        \n");
      out.write("        ");
HttpSession sesion = request.getSession(); 
        
     
        String codigo=sesion.getAttribute("cod_per").toString();
     
        /* 
        out.print(sesion.getAttribute("cod_per"));
        out.print("<br>"+sesion.getAttribute("nombre"));
        out.print("<br>"+sesion.getAttribute("foto"));
        out.print("<br>"+sesion.getAttribute("foto2"));height="800"
        */
        if(codigo!=""){
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <nav class=\"navbar navbar-expand-md navbar-dark bg-primary mb-4\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\">PORTAL MINSA</a>\n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n");
      out.write("                          <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                            <li class=\"nav-item active\">\n");
      out.write("                              <a class=\"nav-link\" href=\"#\"> | <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                            </li>\n");
      out.write("                          </ul>\n");
      out.write("                            <a class=\"nav-item\" href=\"#\">Nombre ");
      out.print(sesion.getAttribute("nombre"));
      out.write(" Cod:     ");
      out.print(sesion.getAttribute("cod_per"));
      out.write("  <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                                \n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-3\">\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"nav flex-column nav-pills\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\n");
      out.write("                                            <a class=\"nav-link active\" href=\"#\" id=\"lo\"  >PRUEBA</a>\n");
      out.write("                                            <a class=\"nav-link active\" href=\"#\" id=\"lo2\"  >PRUEBA 2</a>\n");
      out.write("                                            <a class=\"nav-link active\" href=\"#\" id=\"lo3\"  >PRUEBA3</a>\n");
      out.write("                                            <a class=\"nav-link active\" id=\"v-pills-home-tab\" data-toggle=\"pill\" href=\"#v-pills-home\" role=\"tab\" aria-controls=\"v-pills-home\" aria-selected=\"true\">Inicio</a>\n");
      out.write("                                            <a class=\"nav-link\" id=\"v-pills-profile-tab\" data-toggle=\"pill\" href=\"#v-pills-profile\" role=\"tab\" aria-controls=\"v-pills-profile\" aria-selected=\"false\">Verficar Accidentado</a>\n");
      out.write("                                            <a class=\"nav-link\" id=\"v-pills-messages-tab\" data-toggle=\"pill\" href=\"#v-pills-messages\" role=\"tab\" aria-controls=\"v-pills-messages\" aria-selected=\"false\">Historia Clínica</a>\n");
      out.write("                                            <a class=\"nav-link\" id=\"v-pills-settings-tab\" data-toggle=\"pill\" href=\"#v-pills-settings\" role=\"tab\" aria-controls=\"v-pills-settings\" aria-selected=\"false\">Cerrar Sesion</a>\n");
      out.write("                                          </div>\n");
      out.write("                                          <div class=\"tab-content\" id=\"v-pills-tabContent\">\n");
      out.write("                                            <div class=\"tab-pane fade show active\" id=\"v-pills-home\" role=\"tabpanel\" aria-labelledby=\"v-pills-home-tab\">hola</div>\n");
      out.write("                                            <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\" aria-labelledby=\"v-pills-profile-tab\">TIO</div>\n");
      out.write("                                            <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\">COÑO</div>\n");
      out.write("                                            <div class=\"tab-pane fade\" id=\"v-pills-settings\" role=\"tabpanel\" aria-labelledby=\"v-pills-settings-tab\">MACHO</div>\n");
      out.write("                                          </div>\n");
      out.write("                                        <div id=\"a\">ESTE ES EL CONTENEDOR</div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col\">\n");
      out.write("                                                <p>COLUMNA 1</p>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col\">\n");
      out.write("                                                <p>COLUMNA 2</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <center>\n");
      out.write("        <table border=\"10\"  width=\"800\" bgcolor=\"red\">\n");
      out.write("                <tr><th>Nombre: ");
      out.print(sesion.getAttribute("nombre"));
      out.write("  <br>Codigo: ");
      out.print(sesion.getAttribute("cod_per"));
      out.write("<th Colspan=\"2\">Contactos de Emergencia\n");
      out.write("            <tr><th><form action=\"soyelmapa.html\" method=\"post\"target=\"winn\"><input type=\"submit\" value=\"Mapa Hospital\"></form><th colspan=\"2\" rowspan=\"4\"><iframe name=\"winn\" width=\"600\" height=\"500\"></iframe>\n");
      out.write("            <tr><th><form action=\"paciente.jsp\" method=\"post\"target=\"winn\"><input type=\"submit\" value=\"Historia Clinica\"></form>\n");
      out.write("            <tr><th><form action=\"Verificar_accidentado.jsp\" method=\"post\"target=\"winn\"><input type=\"submit\" value=\"Verificar Accidentado\"></form>\n");
      out.write("            <tr><th><form action=\"index.jsp\" method=\"post\"><input type=\"submit\" value=\"Cerrar Sesion\"></form>\n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("            ");

            }else{

                  out.print("<script> location.replace('index.html')");
                 }

            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
