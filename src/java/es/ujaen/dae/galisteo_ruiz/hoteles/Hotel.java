/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Hotel {

    private String nombre;
    private String direccion;
    private String ciudad;
    private String CIF;
    //cada posición del vector representa el número de individuales, dobles y triples
    private int[] numHabitaciones = new int[3];

    public int[] getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int[] numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public float[] getPrecioHabitaciones() {
        return precioHabitaciones;
    }

    public void setPrecioHabitaciones(float[] precioHabitaciones) {
        this.precioHabitaciones = precioHabitaciones;
    }
    //cada posición del vector representa el precio de hab individual, doble y triple
    private float[] precioHabitaciones = new float[3];
    private List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public boolean reserva(Reserva res){
        reservas.add(res);
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

    public boolean hayPlazas(int numHab, int tipoHab, Date fIni, Date fFin){
        int counter=0;
        boolean hay=true;
        for(Reserva r: getReservas()){
            if(r.getTipoHab() == tipoHab){
                if(r.getFecIni().compareTo(fIni)>=0 && r.getFecIni().compareTo(fFin)<=0){
                    //si la reserva empieza dentro del períoro de tiempo especificado
                    counter+=r.getNumHabitaciones();
                }else{
                    if(r.getFecFin().compareTo(fIni)>=0 && r.getFecFin().compareTo(fFin)<=0){
                        //si la reserva termina dentro del períoro de tiempo especificado
                        counter+=r.getNumHabitaciones();
                    }
                }
                //si tengo menos reservas en ese período que habitaciones totales --> Tengo libres
                if(counter+numHab>getNumHabitaciones()[tipoHab]){
                    hay=false;
                }
            }            
       }
        return hay;
    }
    
    public Hotel() {
        numHabitaciones[0]=11; numHabitaciones[1]=1; numHabitaciones[2]=1;
        precioHabitaciones[0]=20; precioHabitaciones[1]=30; precioHabitaciones[2]=40;
        reservas = new ArrayList<Reserva>();
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
