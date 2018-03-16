package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidad.ingreso;
import controlador.bd;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Sistema Biométrico de Identificación</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <header>\n");
      out.write("          \n");
      out.write("      </header>\n");
      out.write("      <div class=\"container fondocentrado\" >\n");
      out.write("          <div class=\"row margenes\">\n");
      out.write("              <div class=\"col-4 offset-4 margenes\" >\n");
      out.write("                  <form class=\"form-signin\" method=\"post\" action=\"index.jsp\">\n");
      out.write("                    <div class=\"text-center mb-4\">\n");
      out.write("                      <img class=\"mb-4\" src=\"img/paramedic-logo.png\" alt=\"\" width=\"72\" height=\"72\">\n");
      out.write("                        <h1 class=\"letrablanca mb-3 \">Identificación</h1>\n");
      out.write("                      \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-label-group\">\n");
      out.write("                      <input  id=\"inputEmail\"  placeholder=\"DNI\" name=\"usu\">\n");
      out.write("                      <label for=\"inputEmail\">Email address</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-label-group\">\n");
      out.write("                      <input type=\"password\" id=\"inputPassword\" name=\"pas\" placeholder=\"Password\" required>\n");
      out.write("                      <label for=\"inputPassword\">Password</label>\n");
      out.write("                    </div>\n");
      out.write("                    <input class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" value=\"Ingresar\" name=\"btnIngresar\">\n");
      out.write("                  </form>\n");
      out.write("              </div>\n");
      out.write("          </div>    \n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("       \n");
      out.write("      ");

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

      
      out.write("\n");
      out.write("  </body>\n");
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
