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
public class consulta {
    private String dia_ini;
    private String hora_ini;
    private String dia_fin;
    private String hora_fin;
    private String hospital;
private String enfermedad;

    public consulta(String dia_ini, String hora_ini, String dia_fin, String hora_fin, String hospital, String enfermedad) {
        this.dia_ini = dia_ini;
        this.hora_ini = hora_ini;
        this.dia_fin = dia_fin;
        this.hora_fin = hora_fin;
        this.hospital = hospital;
        this.enfermedad = enfermedad;
    }


    public consulta() {
    }

    public consulta(String dia_ini, String hora_ini, String dia_fin, String hora_fin, String hospital) {
        this.dia_ini = dia_ini;
        this.hora_ini = hora_ini;
        this.dia_fin = dia_fin;
        this.hora_fin = hora_fin;
        this.hospital = hospital;
    }

    public String getDia_ini() {
        return dia_ini;
    }

    public void setDia_ini(String dia_ini) {
        this.dia_ini = dia_ini;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getDia_fin() {
        return dia_fin;
    }

    public void setDia_fin(String dia_fin) {
        this.dia_fin = dia_fin;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    
}
