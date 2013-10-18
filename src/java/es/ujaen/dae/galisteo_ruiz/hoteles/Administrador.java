/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioAdministrador;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Administrador {
    
    
    /**
     * Constructor por defecto
     */
    Administrador() {
        
    }

    /**
     * Alta de un operador
     *
     * @param op Operador
     * @return true si se ha dado de alta el operador o false en caso contrario
     */
    public boolean altaOperador(Operador op) {
        //compruebo que no existe, y en ese caso, lo inserto en el mapa
        Operador opAux = ServicioAdministrador.getListaOperadores().get(op.getCIF());
        if(opAux == null){
            ServicioAdministrador.getListaOperadores().put(op.getCIF(), op);
        }else{
            return false;
        }
        return true;
    }

    /**
     * Baja de un operador
     *
     * @param CIF CIF del operador
     * @return true si se ha dado de baja el operador o false en caso contrario
     */
    public boolean bajaOperador(String CIF) {
        //compruebo si existe y en ese caso lo elimino
        Operador opAux = ServicioAdministrador.getListaOperadores().get(CIF);
        if (opAux == null) {
            return false;
        }else{
            ServicioAdministrador.getListaOperadores().remove(CIF);
        }
        return true;
    }

    /**
     * Alta de un hotel
     *
     * @param hot Hotel
     * @return true si se ha dado de alta el hotel o false en caso contrario
     */
    public boolean altaHotel(Hotel hot) {
        //compruebo que no exista y lo inserto en ese caso
        Hotel hotAux = ServicioAdministrador.getListaHoteles().get(hot.getCIF());
        if(hotAux == null){
            ServicioAdministrador.getListaHoteles().put(hot.getCIF(), hot);
        }else{
            return false;
        }
        return true;
    }

    /**
     * Baja de un hotel
     *
     * @param CIF CIF del hotel a dar de baja
     * @return true si se ha dado de baja correctamente o false en caso
     * contrario
     */
    public boolean bajaHotel(String CIF) {
        //compruebo su existencia y lo elimino en caso de que exista
        Hotel hotAux = ServicioAdministrador.getListaHoteles().get(CIF);
        if (hotAux == null) {
            return false;
        }else{
            ServicioAdministrador.getListaHoteles().remove(CIF);
        }
        return true;
    }
    
}
