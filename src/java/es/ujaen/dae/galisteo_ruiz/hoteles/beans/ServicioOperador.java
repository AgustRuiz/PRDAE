/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Administrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Fecha;
import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Reserva;
import es.ujaen.dae.galisteo_ruiz.hoteles.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author juanpepe
 */
public class ServicioOperador {
    
    private static Map<String,Hotel> listaHoteles;
    private static Map<String,Operador> listaOperadores;
    private static Map<String,Usuario> listaUsuarios;

    public static Map<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(Map<String, Usuario> listaUsuarios) {
        ServicioOperador.listaUsuarios = listaUsuarios;
    }

    public static Map<String, Hotel> getListaHoteles() {
        return listaHoteles;
    }

    public static void setListaHoteles(Map<String, Hotel> listaHoteles) {
        ServicioOperador.listaHoteles = listaHoteles;
    }

    public static Map<String, Operador> getListaOperadores() {
        return listaOperadores;
    }

    public static void setListaOperadores(Map<String, Operador> listaOperadores) {
        ServicioOperador.listaOperadores = listaOperadores;
    }
    
    ServicioOperador(){
        listaHoteles = ServicioAdministrador.getListaHoteles();
        listaOperadores = ServicioAdministrador.getListaOperadores();
    }
    
    public boolean altaUsuario(String dni, String nombre, String direccion){
        Usuario Usu_aux = new Usuario(dni,nombre,direccion);
        try{
            listaUsuarios.put(dni,Usu_aux);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean bajaUsuario(int dni){
        Usuario usu_aux = listaUsuarios.get(dni);
        
        if (usu_aux == null){
            return false;
        }
        
        try{
            listaUsuarios.remove(usu_aux);
        }catch(Exception e){
           return false; 
        }
        return true;
    }
    
public List<Hotel> buscarPorCiudad(String ciudad){
    ArrayList<Hotel> listaPorCiudad = new ArrayList<Hotel>();
    
    for(Entry<String, Hotel> e: this.listaHoteles.entrySet()){
        if (e.getValue().getCiudad().equals(ciudad)){
            listaPorCiudad.add(e.getValue());
        }
    }
    
    return listaPorCiudad;
}

public List<Hotel> buscarPorNombre(String nombre){
    ArrayList<Hotel> listaPorNombre = new ArrayList<Hotel>();
    
    for(Entry<String, Hotel> e: this.listaHoteles.entrySet()){
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
    for(Entry<String, Hotel> e: this.listaHoteles.entrySet()){
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
