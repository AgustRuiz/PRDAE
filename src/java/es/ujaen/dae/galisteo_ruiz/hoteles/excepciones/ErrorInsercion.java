package es.ujaen.dae.galisteo_ruiz.hoteles.excepciones;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es) 
 */
public class ErrorInsercion extends Exception {
    public ErrorInsercion (String mensaje){
        super(mensaje);
    }
}
