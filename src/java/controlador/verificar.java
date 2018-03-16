/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.contacto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.contactos;
import util.SQLConexion;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author hpe
 */
@WebServlet(name = "verificar", urlPatterns = {"/verificar"})
public class verificar extends HttpServlet {
    public  String Username = "christiancpb23@gmail.com";
    public  String PassWord = "P989414320";
    String Mensage = "";
    String To = "";
    String Subject = "";
     public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verificar</title>");            
            out.println("</head>");
            out.println("<body class='fondominsa'>");
            out.println("<h1>Servlet verificar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
          response.setContentType("text/html"); 
           HttpSession sesion = request.getSession(true);

        
          //
          String envi=request.getParameter("en");
          sesion.setAttribute("env", envi);
          String dni=request.getParameter("textDNI");
          if(dni!=null){
          sesion.setAttribute("dni", dni);
          }
          if(dni==null){
          dni=""+sesion.getAttribute("dni");
          }
          
          contactos ver=new contactos();
          
          if(ver.inden(dni).equals("")){
              JOptionPane.showMessageDialog(null, "No se encontro 0 ingreso mal el DNI");
            response.sendRedirect("Verificar_accidentado.jsp");
          }else{
          
          //chevere de la imagen<a href='imagen?id="+dni+"+' target='_bl'>Ver Foto</a> <br><iframe name='_bl' width='200' height='200'></iframe>"
          
   
         
       PrintWriter salida=response.getWriter();
       salida.println("<html><head><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"       \n" +
"        <link rel=\"stylesheet\" href=\"css/styles.css\"> </head><body class='fondominsa'>");
       salida.println("<center>");
      salida.println("<table class='table letrablanca'>");
      for(contacto x:ver.LisProducto(dni)){
      salida.println("<tr><td>"+x.getNombre()+"<th class='row' >"+"<td rowspan='3'><img src='imagen?id="+dni+"+' width='200' height='200'>");
      salida.println("<tr><td>"+x.getApellido());
      salida.println("<tr><td>"+x.getEdad());
      
      }
      salida.println("</table>");
     // salida.println("<img src='imagen?id="+dni+"+' width='200' height='200'>");
     salida.println("<h3 style='color: white;'>Contactos de emergencia</h3>");
     salida.println("<table class='table letrablanca'>");
     salida.println("<tr><th class='col'>Nombre<th>Apellido<th>Tipo<th>Celular,<th>Correo");
     for(contacto y:ver.C_emergencia(dni)){
     salida.println("<tr><th>"+y.getNombre()+"<th>"+y.getApellido()+"<th>"+y.getTipo()+"<th>"+y.getCelular()+"<th>"+y.getCorreo()+"");
     }
     salida.println("<tr><th class='col' colspan='5'><form action='verificar' method='post'><input name='en' type='submit' value='Enviar SMS' ></form>");
     salida.println("</table>");
      salida.println("</center>");
      /*
       salida.println("Nombre es:"+request.getParameter("nombre"));
        salida.println("<br>");
       salida.println("<br>");
       
       salida.println("Apellido es:"+request.getParameter("apellido"));
       salida.println("Apellido es:"+request.getParameter("apellido"));
      */
      
       salida.println("</body></html>"); 
       String correo1="";
       String correo2="";
       String correo3="";
       String correo4="";
       int con=1;
       for(contacto t:ver.C_emergencia(dni)){
              if(con==4){
           correo4=t.getCorreo();
           sesion.setAttribute("correo4", correo4);
           con++;
           }
            if(con==3){
           correo3=t.getCorreo();
           sesion.setAttribute("correo3", correo3);
           con++;
           }
            if(con==2){
           correo2=t.getCorreo();
           sesion.setAttribute("correo2", correo2);
           con++;
           }
           
           if(con==1){
           correo1=t.getCorreo();
           sesion.setAttribute("correo1", correo1);
           con++;
           }
            
              
             
    
     }
       con=1;
       if(envi.equals("Enviar SMS")){
          
       for(int g=1; g<=4; g++){
       Mensage = "Su hijo ha sido llevado al hospital de Jose Carlos Mariategi\n  MZJ L5 L os Jardines de Shangrila ";
       if(g==1){
        To =""+sesion.getAttribute("correo1");
        Subject = "Hospital Terminado";
        SendMail();
        JOptionPane.showMessageDialog(null, To);
       }
       if(g==2){
        To =""+sesion.getAttribute("correo2");
        Subject = "Hospital";
        SendMail();
        JOptionPane.showMessageDialog(null, To);
       }
       if(g==3){
        To =""+sesion.getAttribute("correo3");
        Subject = "Hospital";
        SendMail();
        JOptionPane.showMessageDialog(null, To);
       }
       if(g==4){
        To =""+sesion.getAttribute("correo4");
        Subject = "Hospital";
        SendMail();
        JOptionPane.showMessageDialog(null, To);
       }
        
       }
       }
          }
     
       
        //processRequest(request, response);
    }

    /** ,m.000000000000000000m 
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
