package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Verificar_005faccidentado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("  <body background=\"images/index.jpg\">\n");
      out.write("        ");

          String fdnii=request.getParameter("fdni");
          String fhuella=request.getParameter("fhue");
        if(fdnii==null && fhuella==null){
        
      out.write("\n");
      out.write("    <center>\n");
      out.write("        \n");
      out.write("        <h1>Ingreso \"DNI\" o \"HUELLA\"</h1>\n");
      out.write("        <div id=\"primero\" class=\"primero1\">\n");
      out.write("            <table border=\"10\">\n");
      out.write("                <tr><th colspan=\"2\" ><img src=\"images/foto2.jpg\" width=\"400\" height=\"400\">\n");
      out.write("                <tr>\n");
      out.write("                    <th><form action=\"Verificar_accidentado.jsp\" method=\"post\"><input type=\"submit\" value=\"DNI\" class=\"dnih\" name=\"fdni\"></form>\n");
      out.write("                    <th><form action=\"fVerificar\" method=\"post\"><input type=\"submit\" value=\"HUELLA\" class=\"dnihh\" name=\"fhue\"></form>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        ");

      
        
        }else{


if(fdnii.equals("DNI")==true){



      out.write(" \n");
      out.write("<center>    <div class=\"registro\">\n");
      out.write("        <form action=\"verificar\" method=\"post\"> <font color=\"red\"> Ingrese su numero de DNI° :</font> <input type=\"password\" name=\"textDNI\"> <input type=\"submit\" value=\"Enviar\"></form>\n");
      out.write("             \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

}
      }     
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        </center>\n");
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
