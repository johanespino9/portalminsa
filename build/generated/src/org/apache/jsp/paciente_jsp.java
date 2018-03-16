package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidad.consulta;
import modelo.contactos;
import java.util.List;
import java.util.ArrayList;
import entidad.contacto;

public final class paciente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body> ");

       
      
      
             
           
            
        
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("       \n");
      out.write("        <form method=\"post\" action=\"paciente.jsp\">\n");
      out.write("      Ingrese DNI: <input name=\"dnii\"> <input type=\"submit\" value=\"enviar\">\n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        <table border=\"10\">\n");
      out.write("        ");

        
        String dni=request.getParameter("dnii");
           List<contacto> lis=new ArrayList<contacto>();
         contactos ver=new contactos();
      
         lis=ver.LisProducto(dni);

         for(contacto x:lis){
             
             
      out.write("\n");
      out.write("        <tr><th colspan=\"2\">Paciente\n");
      out.write("        <tr><th>");
      out.print(x.getNombre());
      out.write("<th rowspan=\"3\"><a href=\"imagen?id=");
      out.print(dni );
      out.write("\" target=\"_bl\">Ver Foto</a> <br><iframe name=\"_bl\" width=\"200\" height=\"200\"></iframe>\n");
      out.write("             <tr><th>");
      out.print(x.getApellido());
      out.write("\n");
      out.write("            <tr> <th>");
      out.print(x.getEdad());
      out.write(" \n");
      out.write("        \n");
      out.write("         \n");
      out.write("         ");

         }
        
      out.write("\n");
      out.write("         </table> \n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("         <table border=\"10\">\n");
      out.write("             \n");
      out.write("             ");
 
                 int t=0;
             for(consulta j:ver.consultaDni(dni)){
                if(t==0){
                
      out.write("\n");
      out.write("                <tr><th>Dia de Ingreso<th>Hora de Ingreso<th>Dia de Salida<th>Hora de Salida<th>Hospital Internado<th>Enfermedad\n");
      out.write("                ");

                    t++;
                }
             
      out.write("\n");
      out.write("             \n");
      out.write("             <tr><td>");
      out.print(j.getDia_ini());
      out.write("<td>");
      out.print(j.getHora_ini());
      out.write("<td>");
      out.print(j.getDia_fin());
      out.write("<td>");
      out.print(j.getHora_fin());
      out.write("<td>");
      out.print( j.getHospital());
      out.write("<td>");
      out.print(j.getEnfermedad());
      out.write("\n");
      out.write("             \n");
      out.write("             ");

             
             }
             
             
      out.write("\n");
      out.write("             \n");
      out.write("             \n");
      out.write("             \n");
      out.write("        </table>\n");
      out.write("        ");

 
   
    
      out.write(" \n");
      out.write("      \n");
      out.write("    </center>\n");
      out.write("   \n");
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
