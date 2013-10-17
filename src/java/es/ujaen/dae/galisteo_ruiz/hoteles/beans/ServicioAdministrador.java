package es.ujaen.dae.galisteo_ruiz.hoteles.beans;

import es.ujaen.dae.galisteo_ruiz.hoteles.Administrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import java.util.Map;

/**
 *
 * @author juanpepe
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
     * Dar de alta un operador
     *
     * @param nombre Nombre del operador
     * @param CIF CIF del operador
     * @param direccion Dirección del operador
     * @return true si se ha dado de alta el operador o false en caso contrario
     */
    public boolean altaOperador(String nombre, String CIF, String direccion) {
        Operador op_aux = new Operador(CIF, direccion, nombre);

        //comprobar que no exista
        try {
            this.listaOperadores.put(CIF, op_aux);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Dar de baja un operador
     *
     * @param CIF CIF del operador
     * @return true si se ha dado de baja el operador o false en caso contrario
     */
    public boolean bajaOperador(int CIF) {
        Operador op_aux = this.listaOperadores.get(CIF);

        if (op_aux == null) {
            return false;
        }

        try {
            this.listaOperadores.remove(op_aux);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Da de alta un hotel
     *
     * @param hot Hotel
     * @return true si se ha dado de alta el hotel o false en caso contrario
     */
    public boolean altaHotel(Hotel hot) {
        //comprobar que no exista
        try {
            this.listaHoteles.put(hot.getCIF(), hot);
        } catch (Exception e) {
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
    public boolean bajaHotel(int CIF) {
        Hotel hot_aux = this.listaHoteles.get(CIF);

        if (hot_aux == null) {
            return false;
        }

        try {
            this.listaHoteles.remove(hot_aux);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
