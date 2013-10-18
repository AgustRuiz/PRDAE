/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author juanpepe
 */
public class Hotel {

    private String nombre;
    private String direccion;
    private String ciudad;
    private String CIF;
    //cada posición del vector representa el número de individuales, dobles y triples
    private int[] numHabitaciones = new int[3];
    //cada posición del vector representa el precio de hab individual, doble y triple
    private float[] precioHabitaciones = new float[3];
    private List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public boolean reserva(Reserva res){
        try{
            reservas.add(res);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public int totalHabitaciones(){
        return numHabitaciones[0]+numHabitaciones[1]+numHabitaciones[2];
    }
    
    public String getCIF() {
        return CIF;
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

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Hotel() {
    }

    public Hotel(String cif, String nom, String dir, String ciu, int[] n_hab, float[] p_hab) {
        CIF = cif;
        nombre = nom;
        direccion = dir;
        ciudad = ciu;
        numHabitaciones = n_hab;
        precioHabitaciones = p_hab;
        reservas = new ArrayList<Reserva>();
    }
}
