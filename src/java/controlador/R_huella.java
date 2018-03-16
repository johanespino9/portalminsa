/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BD.ConexionBD;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import entidad.contacto;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import lector.CapturaHuella;
import modelo.contactos;
import util.SQLConexion;

















/**
 *
 * @author hpe
 */
@WebServlet(name = "R_huella", urlPatterns = {"/R_huella"})
public class R_huella extends HttpServlet {
    String dea=null;
    // de aca para abajo del msm
    /*
    
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
    */
    // de aca para abajo de la huella 
    
     public void AdicionUsuario(){
     ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
     Integer tamañoHuella=template.serialize().length;
	int resp=0; // "0" no grabo
	 try{
  String sql="Insert into usuario values(?,?,?,?)";
  PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
 // FileInputStream ver=new FileInputStream(p.getContra2());
  String nombre = JOptionPane.showInputDialog("codigo de usuario:");
  String contra = JOptionPane.showInputDialog("contraseña:");
  String cod = JOptionPane.showInputDialog("codigo del personal:");
st.setString(1,nombre);
st.setString(2,contra);
st.setBinaryStream(3, datosHuella,tamañoHuella);
st.setString(4, cod);

  
	
        
    resp=st.executeUpdate();
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
	//return resp;	
	}
    
     public R_huella() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual",
                    "Lookandfeel invalido.",
                    JOptionPane.ERROR_MESSAGE);
        }
       // initComponents();
       
    } 
  // Variable que permite iniciar el dispositiio de lector de huella conectado
    // con sus distintos metodos.
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    
    // Variable que permite establecer las capturas de las huellas, para determinar
    // sus caracteristicas y poder estimar la creacion de un template de la huella
    // para luego poder guardarla
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    
    // Esta variable tambien captura una huella del lector y crea sus caracteristicas 
    // para autentificar o verificarla con alguna y guarda en la BD 
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();
    
    // Variable para crear el template de la huella luego de que se hallan creado 
    // las caracteristicas de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";
    
    protected void Iniciar(){
        
   Lector.addDataListener(new DPFPDataAdapter() {
    @Override public void dataAcquired(final DPFPDataEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    JOptionPane.showMessageDialog(null,"La Huella Digital ha sido Capturada");
    ProcesarCaptura(e.getSample());
        
    }});}
   });

   Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
    @Override public void readerConnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    //JOptionPane.showMessageDialog(null,"El Sensor de Huella Digital esta Activado o Conectado");
    }});}
    @Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    //JOptionPane.showMessageDialog(null,"El Sensor de Huella Digital esta Desactivado o no Conectado");
    }});}
   });

   Lector.addSensorListener(new DPFPSensorAdapter() {
    @Override public void fingerTouched(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    //JOptionPane.showMessageDialog(null,"El dedo ha sido colocado sobre el Lector de Huella");
    }});}
    @Override public void fingerGone(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
   // JOptionPane.showMessageDialog(null,"El dedo ha sido quitado del Lector de Huella");
    }});}
   });

   Lector.addErrorListener(new DPFPErrorAdapter(){
    public void errorReader(final DPFPErrorEvent e){
    SwingUtilities.invokeLater(new Runnable() {  public void run() {
    JOptionPane.showMessageDialog(null,"Error: "+e.getError());
    }});}
   });
}
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
    
    public  void ProcesarCaptura(DPFPSample sample)
 {
 // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
 featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

 // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
 featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

 // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
 if (featuresinscripcion != null)
     try{
     System.out.println("Las Caracteristicas de la Huella han sido creada");
     Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

     // Dibuja la huella dactilar capturada.
     Image image=CrearImagenHuella(sample);
     DibujarHuella(image);
    
     //btnVerificar.setEnabled(true);
     //btnIdentificar.setEnabled(true);
 try {
            identificarHuella();
            Reclutador.clear();
        } catch (IOException ex) {
            Logger.getLogger(R_huella.class.getName()).log(Level.SEVERE, null, ex);
        }
     }catch (DPFPImageQualityException ex) {
     System.err.println("Error: "+ex.getMessage());
     }

     finally {
     EstadoHuellas();
     // Comprueba si la plantilla se ha creado.
	switch(Reclutador.getTemplateStatus())
        {
            case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
	    stop();
            setTemplate(Reclutador.getTemplate());
	    JOptionPane.showMessageDialog(null,"La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
	    //btnIdentificar.setEnabled(false);
            //btnVerificar.setEnabled(false);
            //btnGuardar.setEnabled(true);
           // btnGuardar.grabFocus();
            break;

	    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
	    Reclutador.clear();
            stop();
	    EstadoHuellas();
	    setTemplate(null);
	  // JOptionPane.showMessageDialog(R_huella.this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
	    start();
	    break;
	}
	     }
}
    
    public  DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose){
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
    try {
        return extractor.createFeatureSet(sample, purpose);
    } catch (DPFPImageQualityException e) {
        return null;
    }
}
    public  Image CrearImagenHuella(DPFPSample sample) {
    return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }
    public void DibujarHuella(Image image) {
      //  lblImagenHuella.setIcon(new ImageIcon(
       // image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
       // repaint();
    }

    public  void EstadoHuellas(){
       // JOptionPane.showMessageDialog(null,"Muestra de Huellas Necesarias para Guardar Template "+ Reclutador.getFeaturesNeeded());
    }

   // public void EnviarTexto(String string) {
    // txtArea.append(string + "\n");
    //}

    public  void start(){
    Lector.startCapture();
   //JOptionPane.showMessageDialog(null,"Utilizando el Lector de Huella Dactilar ");
    }

    public  void stop(){
        Lector.stopCapture();
       //JOptionPane.showMessageDialog(null,"No se está usando el Lector de Huella Dactilar ");
    } 

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        
       
    }

    ConexionBD con=new ConexionBD();
    
    /*
  * Guarda los datos de la huella digital actual en la base de datos
  */
    public void guardarHuella(){
     //Obtiene los datos del template de la huella actual
     ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
     Integer tamañoHuella=template.serialize().length;

     //Pregunta el nombre de la persona a la cual corresponde dicha huella
     String nombre = JOptionPane.showInputDialog("Nombre:");
     try {
     //Establece los valores para la sentencia SQL
     Connection c=con.conectar(); //establece la conexion con la BD
     PreparedStatement guardarStmt = c.prepareStatement("Insert into persona values(?,?)");

     /*
     String sql="Insert into persona values(?,?,?,?)";
  PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
     */
     
     
     guardarStmt.setString(1,nombre);
     guardarStmt.setBinaryStream(2, datosHuella,tamañoHuella);
     //Ejecuta la sentencia
     guardarStmt.execute();
     guardarStmt.close();
     JOptionPane.showMessageDialog(null,"Huella Guardada Correctamente");
     con.desconectar();
    // btnGuardar.setEnabled(false);
    // btnVerificar.grabFocus();
     } catch (SQLException ex) {
     //Si ocurre un error lo indica en la consola
     System.err.println("Error al guardar los datos de la huella.");
     }finally{
     con.desconectar();
     }
   }
    
    /**
* Verifica la huella digital actual contra otra en la base de datos
*/
public void verificarHuella(String nom) {
    try {
    //Establece los valores para la sentencia SQL
    //Connection c=con.conectar();
    //Obtiene la plantilla correspondiente a la persona indicada
    /*String sql=" select cod_usu,contra1,contra2,cod_per from usuario where cod_usu=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, cod);
ResultSet rs=st.executeQuery();*/
   // PreparedStatement verificarStmt = c.prepareStatement("SELECT huehuella FROM somhue WHERE huenombre=?");
   // verificarStmt.setString(1,nom);
   // ResultSet rs = verificarStmt.executeQuery();
String sql="  SELECT contra2 FROM usuario WHERE cod_usu=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, nom);
ResultSet rs=st.executeQuery();
    //Si se encuentra el nombre en la base de datos
    if (rs.next()){
    //Lee la plantilla de la base de datos
    byte templateBuffer[] = rs.getBytes("contra2");
    //Crea una nueva plantilla a partir de la guardada en la base de datos
    DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
    //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
    setTemplate(referenceTemplate);

    // Compara las caracteriticas de la huella recientemente capturda con la
    // plantilla guardada al usuario especifico en la base de datos
    DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

    //compara las plantilas (actual vs bd)
    if (result.isVerified())
    JOptionPane.showMessageDialog(null, "Las huella capturada coinciden con la de "+nom,"Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
    else
    JOptionPane.showMessageDialog(null, "No corresponde la huella con "+nom, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);

    //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
    } else {
    JOptionPane.showMessageDialog(null, "No existe un registro de huella para "+nom, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
    }
    } catch (SQLException e) {
    //Si ocurre un error lo indica en la consola
    System.err.println("Error al verificar los datos de la huella.");
    }finally{
       con.desconectar();
    }
   }
     /**
  * Identifica a una persona registrada por medio de su huella digital
  */
   public void identificarHuella() throws IOException{
     try {
       //Establece los valores para la sentencia SQL
       
   /*    public List<usuario1> LisUsuario(String cod){
 List<usuario1> lis=new ArrayList<>();
 try{

String sql=" select cod_usu,contra1,contra2,cod_per from usuario where cod_usu=?";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
st.setString(1, cod);
ResultSet rs=st.executeQuery();
	 //llenar el arraylist con la clase curso
 while(rs.next()){
     
     //String codigo, String nombre, double origen, double precio, int stock
   
	  usuario1 a=new usuario1(rs.getString(1),rs.getString(2),rs.getBlob(3),rs.getString(4));
	  lis.add(a);
	 }
 }catch(Exception ex){
	 ex.printStackTrace();
 }
return lis;	
}*/
      // Connection c=con.conectar();

       //Obtiene todas las huellas de la bd
     //  PreparedStatement identificarStmt = c.prepareStatement("SELECT cod_usu, contra2 FROM usuario");
     //  ResultSet rs = identificarStmt.executeQuery();
String sql=" select dedo, dni from huella_2";
PreparedStatement st=SQLConexion.getConexion().prepareStatement(sql);
ResultSet rs=st.executeQuery();
       //Si se encuentra el nombre en la base de datos
       while(rs.next()){
       //Lee la plantilla de la base de datos
       byte templateBuffer[] = rs.getBytes("dedo");
       String nombre=rs.getString("dni");
       //Crea una nueva plantilla a partir de la guardada en la base de datos
       DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
       //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
       setTemplate(referenceTemplate);

       // Compara las caracteriticas de la huella recientemente capturda con la
       // alguna plantilla guardada en la base de datos que coincide con ese tipo
       DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

       //compara las plantilas (actual vs bd)
       //Si encuentra correspondencia dibuja el mapa
       //e indica el nombre de la persona que coincidió.
       if (result.isVerified()){
       //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
       //JOptionPane.showMessageDialog(null, "Las huella capturada es de "+nombre,"Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
      dea=nombre;
       return;
                               }
       }
       //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
       JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
       setTemplate(null);
       dea="asd";
       } catch (SQLException e) {
       //Si ocurre un error lo indica en la consola
       System.err.println("Error al identificar huella dactilar."+e.getMessage());
        
       }finally{
       con.desconectar();
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
            out.println("<title>Servlet R_huella</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet R_huella at " + request.getContextPath() + "</h1>");
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
        String dni="";
        response.setContentType("text/html"); 
        PrintWriter salida=response.getWriter();
       salida.println("<html><body>");
 
       salida.println("<center>");
        JOptionPane.showMessageDialog(null, "Ingrese dedo y confirmar para indentificar");
        if(dea==null){
        Iniciar();
        start();
        //EstadoHuellas();
        }
      

        
         
          
           HttpSession sesion = request.getSession(true);

        
          //
          String envi=request.getParameter("en");
          sesion.setAttribute("env", envi);
          
          
          
          contactos ver=new contactos();
          int confirma=JOptionPane.showConfirmDialog(null, "Antes de confirma Debes Ingresar tu Dedo");
if(JOptionPane.OK_OPTION==confirma){
     dni=dea;
    if(dni!=null){
          sesion.setAttribute("dni", dni);
          }
          if(dni==null){
          dni=""+sesion.getAttribute("dni");
          }
    
          if(ver.inden(dni).equals("")){
             // JOptionPane.showMessageDialog(null, "No se encontro 0 ingreso mal el DNI");
            response.sendRedirect("Verificar_accidentado.jsp");
          }else{
              
                 RequestDispatcher rd = request.getRequestDispatcher("verificar");
                    rd.forward(request, response);
          }
}else{
//if(ver.inden(dni).equals("")){
             // JOptionPane.showMessageDialog(null, "No se encontro 0 ingreso mal el DNI");
            response.sendRedirect("Verificar_accidentado.jsp");
         // }
}


          //chevere de la imagen<a href='imagen?id="+dni+"+' target='_bl'>Ver Foto</a> <br><iframe name='_bl' width='200' height='200'></iframe>"
          
   
         
       
       /*
      salida.println("<table border='10'>");
      for(contacto x:ver.LisProducto(dni)){
      salida.println("<tr><td>"+x.getNombre()+"<th rowspan='3'>"+"<img src='imagen?id="+dni+"+' width='200' height='200'>");
      salida.println("<tr><td>"+x.getApellido());
      salida.println("<tr><td>"+x.getEdad());
      
      }
      salida.println("</table>");
     // salida.println("<img src='imagen?id="+dni+"+' width='200' height='200'>");
     salida.println("<h1>Contactos de emergencia</h1>");
     salida.println("<table border='10'>");
     salida.println("<tr><th>Nombre<th>Apellido<th>Tipo<th>Celular,<th>Correo");
     for(contacto y:ver.C_emergencia(dni)){
     salida.println("<tr><th>"+y.getNombre()+"<th>"+y.getApellido()+"<th>"+y.getTipo()+"<th>"+y.getCelular()+"<th>"+y.getCorreo()+"");
     }
     salida.println("<tr><th colspan='5'><form action='verificar' method='post'><input name='en' type='submit' value='Enviar SMS' ></form>");
     salida.println("</table>");
      salida.println("</center>");
    
       //salida.println("Nombre es:"+request.getParameter("nombre"));
      //  salida.println("<br>");
       //salida.println("<br>");
       
       //salida.println("Apellido es:"+request.getParameter("apellido"));
       //salida.println("Apellido es:"+request.getParameter("apellido"));
      
      
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
       Mensage = "Recoje a tu hijo muerto";
       if(g==1){
        To =""+sesion.getAttribute("correo1");
        Subject = "Hospital";
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
     */
       int a=17;
       if(a==1){
           stop();
                   }
     
 //salida.println("<form action='verificar' method='post'><input type='submit' value='Ver datos' ></form>");
       salida.println("</center>");
         salida.println("</body></html>");
       
    //    processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
