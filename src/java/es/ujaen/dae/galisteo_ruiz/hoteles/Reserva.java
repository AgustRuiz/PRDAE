/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.Date;


/**
 *
 * @author juanpepe
 */
public class Reserva {
    private Usuario usuario;
    private Date fecIni;
    private Date fecFin;
    private int numHabitaciones;
    private int tipoHab;

    public int getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(int tipoHab) {
        this.tipoHab = tipoHab;
    }
    
    public int getNumHabitaciones(){
        return numHabitaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }
    
    
    Reserva(){
        
    }
    
    public Reserva(Usuario usu, int tipo, Date fIni, Date fFin, int num){
        usuario=usu;
        tipoHab = tipo;
        fecIni = fIni;
        fecFin = fFin;
        numHabitaciones = num;
    }
    
}
