/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.sql.Blob;


public class ingreso {
  private String cod_per; 
  private String nombre;
  private Blob imagen;
  private String codigo;
  private String contra1;

    public ingreso(String cod_per, String nombre, String codigo, String contra1, Blob imagen) {
        this.cod_per = cod_per;
        this.nombre = nombre;
        this.imagen = imagen;
        this.codigo = codigo;
        this.contra1 = contra1;
    }

    public ingreso(String cod_per, String nombre, String codigo, String contra1) {
        this.cod_per = cod_per;
        this.nombre = nombre;
        this.codigo = codigo;
        this.contra1 = contra1;
    }

  
  
    public ingreso(String cod_per, String nombre) {
        this.cod_per = cod_per;
        this.nombre = nombre;
    }

    public ingreso() {
    }

    public ingreso(String cod_per, String nombre, Blob imagen) {
        this.cod_per = cod_per;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getCod_per() {
        return cod_per;
    }

    public void setCod_per(String cod_per) {
        this.cod_per = cod_per;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContra1() {
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }
  
  
  
}
