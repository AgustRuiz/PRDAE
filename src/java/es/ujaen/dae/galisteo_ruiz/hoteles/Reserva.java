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
    
    public Reserva(Usuario usu, Date fIni, Date fFin, int num){
        usuario=usu;
        fecIni = fIni;
        fecFin = fFin;
        numHabitaciones = num;
    }
    
}
