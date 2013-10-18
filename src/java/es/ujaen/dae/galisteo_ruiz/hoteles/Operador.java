/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioOperador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        CIF = cif;
        nombre = nomb;
        direccion = dir;
    }
    
    
    public boolean altaUsuario(Usuario usu){
        //compruebo su existencia y lo inserto 
        Usuario usuAux = ServicioOperador.getListaUsuarios().get(usu.getDNI());
        if(usuAux == null){
            ServicioOperador.getListaUsuarios().put(usu.getDNI(),usu);
        }else{
            return false;
        }
        return true;        
    }
    
    public boolean bajaUsuario(String dni){
        //compruebo su existencia y lo elimino
        Usuario usuAux = ServicioOperador.getListaUsuarios().get(dni);
        if(usuAux == null){
            return false;
        }else{
            ServicioOperador.getListaUsuarios().remove(dni);
        }
        return true;
    }
    
    public List<Hotel> buscarPorCiudad(String ciudad){
        List<Hotel> listaPorCiudad = new ArrayList<Hotel>();
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            if (e.getValue().getCiudad().equals(ciudad)){
                listaPorCiudad.add(e.getValue());
            }
        }
        return listaPorCiudad;
    }

    public List<Hotel> buscarPorNombre(String nombre){
        ArrayList<Hotel> listaPorNombre = new ArrayList<Hotel>();
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            if (e.getValue().getNombre().equals(nombre)){
                listaPorNombre.add(e.getValue());
            }
        }
        return listaPorNombre;
    }

    private boolean hayPlazas(Hotel hot, Date fIni, Date fFin){
        int counter=0;
        boolean hay=false;
        for(Reserva r: hot.getReservas()){
                if(r.getFecIni().compareTo(fIni)>0 && r.getFecIni().compareTo(fFin)<0){
                    //si la reserva empieza dentro del períoro de tiempo especificado
                    counter+=r.getNumHabitaciones();
                }
                if(r.getFecFin().compareTo(fIni)>0 && r.getFecFin().compareTo(fFin)<0){
                    //si la reserva termina dentro del períoro de tiempo especificado
                    counter+=r.getNumHabitaciones();
                }
                //si tengo menos reservas en ese período que habitaciones totales --> Tengo libres
                if(counter<hot.totalHabitaciones()){
                    hay=true;
                }
            }
        return hay;
    }

    public List<Hotel> bucarPorFecha(Date fIni, Date fFin){    /////////////////////////////////////////
        ArrayList<Hotel> listaPorFecha = new ArrayList<Hotel>();

        //recorro la lista de hoteles buscando entre sus reservas
        Hotel hot;
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            hot=e.getValue();
            //recorro la lista de reservas del hotel y cuento las reservas que COINCIDEN en el período de tiempo
            if(hayPlazas(hot,fIni,fFin))
                listaPorFecha.add(hot);
        }
        return listaPorFecha;
    }

    public boolean realizar_reserva(Usuario usu,Hotel hot,int num_hab, Date fIni, Date fFin){
        //debo comprobar si las reservas para ese momento están completas en ese hotel concreto

        if(hayPlazas(hot,fIni,fFin)){
            Reserva res = new Reserva(usu, fIni, fFin, num_hab);
            hot.reserva(res);
        }else{
            return false;
        }

        return true;
    }
    
}
