/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioAdministrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.excepciones.ErrorBorrado;
import es.ujaen.dae.galisteo_ruiz.hoteles.excepciones.ErrorInsercion;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Administrador {
    
    
    
    /**
     * Constructor por defecto
     */
    public Administrador() {
        
    }

    /**
     * Alta de un operador
     *
     * @param op Operador
     */
    public void altaOperador(Operador op) throws Exception {
        //compruebo que no existe, y en ese caso, lo inserto en el mapa
        Operador opAux = ServicioAdministrador.getListaOperadores().get(op.getCIF());
        if(opAux == null){
            ServicioAdministrador.getListaOperadores().put(op.getCIF(), op);
        }else{
            throw new ErrorInsercion("El operador ya existe");
        }
    }

    /**
     * Baja de un operador
     *
     * @param CIF CIF del operador
     */
    public void bajaOperador(String CIF) throws Exception {
        //compruebo si existe y en ese caso lo elimino
        Operador opAux = ServicioAdministrador.getListaOperadores().get(CIF);
        if (opAux == null) {
            throw new ErrorBorrado("El operador no existe");
        }else{
            ServicioAdministrador.getListaOperadores().remove(CIF);
        }
    }

    /**
     * Alta de un hotel
     *
     * @param hot Hotel
     */
    public void altaHotel(Hotel hot) throws Exception {
        //compruebo que no exista y lo inserto en ese caso
        Hotel hotAux = ServicioAdministrador.getListaHoteles().get(hot.getCIF());
        if(hotAux == null){
            ServicioAdministrador.getListaHoteles().put(hot.getCIF(), hot);
        }else{
            throw new ErrorInsercion("El hotel ya existe");
        }
    }

    /**
     * Baja de un hotel
     *
     * @param CIF CIF del hotel a dar de baja
     */
    public void bajaHotel(String CIF) throws Exception {
        //compruebo su existencia y lo elimino en caso de que exista
        Hotel hotAux = ServicioAdministrador.getListaHoteles().get(CIF);
        if (hotAux == null) {
            throw new ErrorBorrado("El hotel no existe");
        }else{
            ServicioAdministrador.getListaHoteles().remove(CIF);
        }
    }
    
}
