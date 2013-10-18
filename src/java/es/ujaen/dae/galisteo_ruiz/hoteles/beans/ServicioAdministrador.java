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
     */
    ServicioAdministrador() {
        admin = null;
        listaHoteles = null;
        listaOperadores = null;
    }

    /**
     * Alta de un operador
     *
     * @param op Operador
     * @return true si se ha dado de alta el operador o false en caso contrario
     */
    public boolean altaOperador(Operador op) {
        //compruebo que no existe, y en ese caso, lo inserto en el mapa
        Operador opAux = listaOperadores.get(op.getCIF());
        if(opAux == null){
            listaOperadores.put(op.getCIF(), op);
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
        Operador opAux = listaOperadores.get(CIF);
        if (opAux == null) {
            return false;
        }else{
            listaOperadores.remove(CIF);
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
        Hotel hotAux = listaHoteles.get(hot.getCIF());
        if(hotAux == null){
            listaHoteles.put(hot.getCIF(), hot);
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
        Hotel hotAux = listaHoteles.get(CIF);
        if (hotAux == null) {
            return false;
        }else{
            ServicioAdministrador.listaHoteles.remove(CIF);
        }
        return true;
    }
}
