package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Reserva;
import java.util.List;
import java.util.Map;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class ServicioHotel {
    
    private static Map<String,Hotel> listaHoteles;
    
    /**
     * Devuelve la lista de hoteles
     * 
     * @return listaHoteles
     */
    public static Map<String, Hotel> getListaHoteles() {
        return listaHoteles;
    }

    /**
     * Establece la lista de hoteles
     * 
     * @param listaHoteles 
     */
    public static void setListaHoteles(Map<String, Hotel> listaHoteles) {
        ServicioHotel.listaHoteles = listaHoteles;
    }
    
    /**
     * Constructor por defecto
     */
    public ServicioHotel(){
        listaHoteles = ServicioAdministrador.getListaHoteles();
    }
    
    /**
     * Devuelve la lista de reservas para el hotel correspondiente
     * 
     * @param CIF
     * @return List<Reserva> listaReservas
     */
    List<Reserva> consultaReservas(String CIF){
        Hotel hot = listaHoteles.get(CIF);
        if(hot != null){
            List<Reserva> listaReservas = hot.getReservas();
            return listaReservas;
        }
        return null;        
    }
    
}
