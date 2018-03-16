package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mapa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <script type=\"text/javascript\" <script\n");
      out.write("    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAeYfac5fo2bMFDvE9sFGAeF-a_qyjo2so&callback=fn_mal\">\n");
      out.write("    </script>>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("        <h1>Prueba</h1>\n");
      out.write("        <div id=\"mapa\" style=\"width: 700px; height: 500px;\">\n");
      out.write("            --Aca va nuestro Mapa\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body><script type=\"text/javascript\">\n");
      out.write("            var divMapa=document.getElementById(\"mapa\");\n");
      out.write("            navigator.geolocation.getCurrentPosition(fn_ok,fn_mal);\n");
      out.write("        function fn_mal(){}\n");
      out.write("        function fn_ok( rta ){\n");
      out.write("         var lat=rta.coords.latitude;\n");
      out.write("         var lon=rta.coords.longitude;\n");
      out.write("         var glatLon=new google.maps.LatLng(lat,lon);\n");
      out.write("         var.objConfing={\n");
      out.write("             zoom:17,\n");
      out.write("             center:gLatLon;\n");
      out.write("         }\n");
      out.write("           var gMapa=new google.maps.Map( divMapa, objConfing); \n");
      out.write("        }\n");
      out.write("        </script>\n");
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
