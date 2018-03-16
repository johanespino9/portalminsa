package util;
import java.sql.*;
public class SQLConexion
 { 
public static Connection getConexion(){ 
Connection con = null;
 try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
String url ="jdbc:sqlserver://localhost;database=huella3"; 
//jdbc:sqlserver://UTP074914\SQLEXPRESS\SQLEXPRESS:1433;databaseName=huella3


String usr = "sa"; 
String psw = "989414320"; 
con = DriverManager.getConnection(url,usr,psw); 
System.out.println("Conexion OK");} 
catch (ClassNotFoundException ex) { System.out.println("No hay Driver!!"); } 
catch (SQLException ex) 
{ System.out.println("Error con la BD"); }
 return con; }
 } 