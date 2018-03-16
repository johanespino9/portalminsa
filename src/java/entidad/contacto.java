/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author hpe
 */
public class contacto {
   private String nombre;
   private String apellido;
   private String edad;
       private byte[] img2;
       
       private String tipo;
       private int celular;
       private String correo;

    public contacto(String nombre, String apellido, String tipo, int celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.celular = celular;
        this.correo = correo;
    }
       

  

    public contacto(String nombre, String apellido, String tipo, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.celular = celular;
    }

       
       
    public contacto(String nombre, String apellido, String edad, byte[] img2) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.img2 = img2;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

       
       
    public contacto(String nombre, String apellido, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
