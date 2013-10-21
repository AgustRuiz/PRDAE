package es.ujaen.dae.galisteo_ruiz.hoteles;

import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioOperador;
import es.ujaen.dae.galisteo_ruiz.hoteles.excepciones.ErrorBorrado;
import es.ujaen.dae.galisteo_ruiz.hoteles.excepciones.ErrorInsercion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Operador {

    private String CIF;
    private String nombre;
    private String direccion;
    
    /**
     * Obtiene el CIF del operador
     *
     * @return CIF
     */
    public String getCIF() {
        return CIF;
    }

    /**
     * Establece el CIF del operador
     * 
     * @param CIF 
     */
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    /**
     * Obtiene el nombre del operador
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del operador
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la direccion del operador
     * 
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del operador
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    /**
     * Constructor por defecto
     */
    public Operador(){
        
    }
    
    /**
     * Constructor sobrecargado
     * @param cif
     * @param nomb
     * @param dir 
     */
    public Operador(String cif, String nomb, String dir){
        CIF = cif;
        nombre = nomb;
        direccion = dir;
    }
    
    /**
     * Inserta un usuario en la lista
     * 
     * @param usu 
     * @throws Exception
     */
    public void altaUsuario(Usuario usu) throws Exception{
        //compruebo su existencia y lo inserto 
        Usuario usuAux = ServicioOperador.getListaUsuarios().get(usu.getDNI());
        if(usuAux == null){
            ServicioOperador.getListaUsuarios().put(usu.getDNI(),usu);
        }else{
            throw new ErrorInsercion("El usuario ya existe");
        }
    }
    
    /**
     * Elimina un usuario de la lista
     * 
     * @param dni
     * @throws Exception 
     */
    public void bajaUsuario(String dni) throws Exception{
        //compruebo su existencia y lo elimino
        Usuario usuAux = ServicioOperador.getListaUsuarios().get(dni);
        if(usuAux == null){
            throw new ErrorBorrado("El usuario no existe");
        }else{
            ServicioOperador.getListaUsuarios().remove(dni);
        }
    }
    
    /**
     * Busca hoteles por ciudad
     * 
     * @param ciudad
     * @return List<Hotel> listaPorCiudad
     */
    public List<Hotel> buscarPorCiudad(String ciudad){
        List<Hotel> listaPorCiudad = new ArrayList<Hotel>();
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            if (e.getValue().getCiudad().equals(ciudad)){
                listaPorCiudad.add(e.getValue());
            }
        }
        return listaPorCiudad;
    }

    /**
     * Busca hoteles por nombre
     * 
     * @param nombre
     * @return List<Hotel> listaPorNombre
     */
    public List<Hotel> buscarPorNombre(String nombre){
        ArrayList<Hotel> listaPorNombre = new ArrayList<Hotel>();
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            if (e.getValue().getNombre().equals(nombre)){
                listaPorNombre.add(e.getValue());
            }
        }
        return listaPorNombre;
    }
    
    /**
     * Busca hoteles por disponibilidad de fechas
     * 
     * @param tipoHab
     * @param fIni
     * @param fFin
     * @return List<Hotel> listaPorFecha
     */
    public List<Hotel> bucarPorFecha(int tipoHab, Date fIni, Date fFin){    /////////////////////////////////////////
        ArrayList<Hotel> listaPorFecha = new ArrayList<Hotel>();
        //recorro la lista de hoteles buscando entre sus reservas
        Hotel hot;
        for(Map.Entry<String, Hotel> e: ServicioOperador.getListaHoteles().entrySet()){
            hot=e.getValue();
            //recorro la lista de reservas del hotel y cuento las reservas que COINCIDEN en el período de tiempo
            if(hot.hayPlazas(tipoHab, 0, fIni, fFin))
                listaPorFecha.add(hot);
        }
        return listaPorFecha;
    }

    /**
     * Crea reserva y la manda al hotel para que la inserte en su lista
     * 
     * @param usu
     * @param hot
     * @param numHab
     * @param tipoHab
     * @param fIni
     * @param fFin
     * @return boolean 
     */
    public boolean realizarReserva(Usuario usu,Hotel hot, int numHab, int tipoHab, Date fIni, Date fFin){
        //debo comprobar si las reservas para ese momento están completas en ese hotel concreto
        if(hot.hayPlazas(numHab, tipoHab, fIni,fFin)){
            Reserva res = new Reserva(usu, tipoHab, fIni, fFin, numHab);
            hot.reserva(res);
        }else{
            return false;
        }
        return true;
    }
    
}
