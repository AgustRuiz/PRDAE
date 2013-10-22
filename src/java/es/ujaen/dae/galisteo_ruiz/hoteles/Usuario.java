package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Usuario {

    private String DNI;
    private String nombre;
    private String direccion;
    private List<Reserva> listaReservas;

    /**
     * Inseta una nueva Reserva en la lista
     * 
     * @param res 
     */
    public void insertarReserva(Reserva res){
        listaReservas.add(res);
    }
    
    /**
     * Obtiene la lista de reservas del usuario
     * 
     * @return listaReservas
     */
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * Establece la lista de reservas del usuario
     * 
     * @param listaReservas 
     */
    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    /**
     * Obtiene el DNI del usuario
     *
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Establece el DNI del usuario
     * 
     * @param DNI 
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene el nombre del usuario
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la direccion del usuario
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del usuario
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Constructor por defecto
     */
    public Usuario(){
        listaReservas = new ArrayList<Reserva>();
    }
    
    /**
     * Constructor sobrecargado
     * 
     * @param dn
     * @param nom
     * @param dir 
     */
    public Usuario (String dn, String nom, String dir){
        DNI=dn;
        nombre=nom;
        direccion=dir;
    }
    
}
