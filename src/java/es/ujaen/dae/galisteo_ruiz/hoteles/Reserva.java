package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.Date;


/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Reserva {
    private Usuario usuario;
    private Date fecIni;
    private Date fecFin;
    private int numHabitaciones;
    private int tipoHab;

    /**
     * Obtiene el tipo de habitacion
     *
     * @return tipoHab
     */
    public int getTipoHab() {
        return tipoHab;
    }

    /**
     * Establece el tipo de habitacion
     *
     * @param tipoHab
     */
    public void setTipoHab(int tipoHab) {
        this.tipoHab = tipoHab;
    }
    
    /**
     * Obtiene el numero de habitaciones
     *
     * @return numHabitaciones
     */
    public int getNumHabitaciones(){
        return numHabitaciones;
    }

    /**
     * Obtiene el usuario
     *
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la fecha de inicio
     *
     * @return fecIni
     */
    public Date getFecIni() {
        return fecIni;
    }

    /**
     * Establece la fecha de inicio
     *
     * @param fecIni
     */
    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    /**
     * Obtiene la fecha de fin
     *
     * @return fecFin
     */
    public Date getFecFin() {
        return fecFin;
    }

    /**
     * Establece la fecha de fin
     *
     * @param fecFin
     */
    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }
    
    /**
     * Constructor por defecto
     */
    public Reserva(){
        
    }
    
    /**
     * Constructor sobrecargado
     * 
     * @param usu
     * @param tipo
     * @param fIni
     * @param fFin
     * @param num 
     */
    public Reserva(Usuario usu, int tipo, Date fIni, Date fFin, int num){
        usuario=usu;
        tipoHab = tipo;
        fecIni = fIni;
        fecFin = fFin;
        numHabitaciones = num;
    }
    
}
