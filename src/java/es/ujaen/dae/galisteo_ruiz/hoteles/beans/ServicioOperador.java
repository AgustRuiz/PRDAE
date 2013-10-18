/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Usuario;
import java.util.Map;


/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class ServicioOperador {
    
    private static Map<String,Operador> listaOperadores;
    private static Map<String,Hotel> listaHoteles;
    private static Map<String,Usuario> listaUsuarios;

    /**
     * Obtiene la lista de usuarios
     *
     * @return Lista de usuarios
     */
    public static Map<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Establece la lista de usuarios
     *
     * @param listaUsuarios Lista de usuarios
     */
    public static void setListaUsuarios(Map<String, Usuario> listaUsuarios) {
        ServicioOperador.listaUsuarios = listaUsuarios;
    }

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
        ServicioOperador.listaHoteles = listaHoteles;
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
        ServicioOperador.listaOperadores = listaOperadores;
    }
    
    /* 
     * Constructor por defecto
     */
    public ServicioOperador(){
        listaHoteles = ServicioAdministrador.getListaHoteles();
        listaOperadores = ServicioAdministrador.getListaOperadores();
    }
    


}
