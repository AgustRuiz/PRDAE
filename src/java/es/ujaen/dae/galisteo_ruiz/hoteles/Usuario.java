/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

/**
 *
 * @author juanpepe
 */
public class Usuario {

    private String DNI;
    private String nombre;
    private String direccion;
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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
    
    Usuario(){
        
    }
    
    public Usuario (String dn, String nom, String dir){
        DNI=dn;
        nombre=nom;
        direccion=dir;
    }
    
}
