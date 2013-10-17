package es.ujaen.dae.galisteo_ruiz.hoteles;

import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioAdministrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioOperador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        //appContext.registerShutdownHook();
        
        //ServicioOperador ser_op = (ServicioOperador) appContext.getBean("operador");
        //ServicioAdministrador ser_ad = (ServicioAdministrador) appContext.getBean("administrador");
        
        //System.out.println(ser_ad.getListaHoteles().size());
        
        //Operador op = new Operador("555","operador5", "direccion5");
        //System.out.println(ser_op.getListaOperadores().size());
        
        //ser_ad.AltaOperador("555","operador5", "direccion5");
        //System.out.println(ser_op.getListaOperadores().size());
        
        //Hotel hot = ser_op.getListaHoteles().get("33333333B");
        //System.out.println(hot.getNombre());
        //System.out.println(ser_op.getLista_hoteles().size());
        
        //List<Hotel> listaPorCiudad = new ArrayList<Hotel>();
        //listaPorCiudad = ser_op.buscarPorCiudad("Ciudad 1");
        
        //System.out.println(listaPorCiudad.size());
    }
}
