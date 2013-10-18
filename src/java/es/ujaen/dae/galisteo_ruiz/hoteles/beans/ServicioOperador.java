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
 * @author juanpepe
 */
public class ServicioOperador {
    
    private static Map<String,Operador> listaOperadores;
    private static Map<String,Hotel> listaHoteles;
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
    


}
