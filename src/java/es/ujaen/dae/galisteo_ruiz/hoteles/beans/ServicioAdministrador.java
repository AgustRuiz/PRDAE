package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Administrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import java.util.Map;


/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class ServicioAdministrador {

    private static Administrador admin;
    private static Map<String, Hotel> listaHoteles;
    private static Map<String, Operador> listaOperadores;
    
    /**
     * Obtiene la lista de hoteles
     *
     * @return Lista de hoteles
     */
    public static Map<String, Hotel> getListaHoteles() {
        return listaHoteles;
    }

    /**
     * Establece la lista de hoteles
     *
     * @param listaHoteles Lista de hoteles
     */
    public static void setListaHoteles(Map<String, Hotel> listaHoteles) {
        ServicioAdministrador.listaHoteles = listaHoteles;
    }

    /**
     * Obtiene la lista de operadores
     *
     * @return Lista de operadores
     */
    public static Map<String, Operador> getListaOperadores() {
        return listaOperadores;
    }

    /**
     * Establece la lista de operadores
     *
     * @param listaOperadores Lista de operadores
     */
    public static void setListaOperadores(Map<String, Operador> listaOperadores) {
        ServicioAdministrador.listaOperadores = listaOperadores;
    }

    /**
     * Constructor por defecto
     *
     */
    public ServicioAdministrador(){
        
    }
    
    /**
     * Obtiene el administrador
     *
     * @return administrador
     */
    public static Administrador getAdmin() {
        return admin;
    }

    /**
     * Establece el administrador
     *
     * @param admin Administrador
     */
    public static void setAdmin(Administrador admin) {
        ServicioAdministrador.admin = admin;
    }

    
}
