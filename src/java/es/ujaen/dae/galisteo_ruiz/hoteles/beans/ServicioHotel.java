/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Reserva;
import es.ujaen.dae.galisteo_ruiz.hoteles.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juanpepe
 */
public class ServicioHotel {
    
    private static Map<String,Hotel> listaHoteles;
    
    public static Map<String, Hotel> getListaHoteles() {
        return listaHoteles;
    }

    public static void setListaHoteles(Map<String, Hotel> listaHoteles) {
        ServicioHotel.listaHoteles = listaHoteles;
    }
    
    ServicioHotel(){
        listaHoteles = ServicioAdministrador.getListaHoteles();
    }
    
    List<Reserva> consultaReservas(String CIF){
        Hotel hot = listaHoteles.get(CIF);
        if(hot != null){
            List<Reserva> listaReservas = hot.getReservas();
            return listaReservas;
        }
        return null;        
    }
    
}
