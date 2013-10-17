/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

/**
 *
 * @author juanpepe
 */
public class Operador {

    private String CIF;
    private String nombre;
    private String direccion;
    
    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    Operador(){
        
    }
    
    public Operador(String cif, String nomb, String dir){
        CIF=cif;
        nombre=nomb;
        direccion=dir;
    }
    
}
