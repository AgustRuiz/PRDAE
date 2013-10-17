/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author juanpepe
 */
public class Fecha {
    private String fecSinFormato;
    private SimpleDateFormat fec;    
    
    public Fecha(){
        
    }
    
    public Fecha(String cad) throws ParseException{
        fecSinFormato = cad;
        fec = new SimpleDateFormat("yyyMMdd");
        fec.parse(fecSinFormato);
    }
}
