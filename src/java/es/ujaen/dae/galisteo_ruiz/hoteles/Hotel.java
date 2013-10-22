package es.ujaen.dae.galisteo_ruiz.hoteles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David Galisteo Cantero (dgc00027@red.ujaen.es)
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
public class Hotel {

    private String nombre;
    private String direccion;
    private String ciudad;
    private String CIF;
    //cada posición del vector representa el número de individuales, dobles y triples
    private int[] numHabitaciones = new int[3];
    //cada posición del vector representa el precio de hab individual, doble y triple
    private float[] precioHabitaciones = new float[3];
    private List<Reserva> reservas;

    /**
     * Obtiene el vector de habitaciones
     *
     * @return vector de habitaciones
     */
    public int[] getNumHabitaciones() {
        return numHabitaciones;
    }

    /**
     * Establece el vector de habitaciones
     *
     * @param numHabitaciones vector numero de habitaciones
     */
    public void setNumHabitaciones(int[] numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    /**
     * Obtiene el vector de precios
     *
     * @return vector de precios
     */
    public float[] getPrecioHabitaciones() {
        return precioHabitaciones;
    }

    /**
     * Establece el vector de precios
     *
     * @param precioHabitaciones vector precios de habitaciones
     */
    public void setPrecioHabitaciones(float[] precioHabitaciones) {
        this.precioHabitaciones = precioHabitaciones;
    }
    
    /**
     * Obtiene la lista de reservas
     *
     * @return lista de reservas
     */
    public List<Reserva> getReservas() {
        return reservas;
    }
    
    /**
     * Obtiene el CIF
     *
     * @return CIF
     */
    public String getCIF() {
        return CIF;
    }

    /**
     * Establece el CIF
     *
     * @param CIF 
     */
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }
    
    /**
     * Obtiene el nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la direccion
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la ciudad
     *
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * comprueba si hay plazas para un tipo de habitación en un intervalo de fechas
     * @param numHab
     * @param tipoHab
     * @param fIni
     * @param fFin
     * @return hay
     */
    public boolean hayPlazas(int numHab, int tipoHab, Date fIni, Date fFin){
        int counter=0;
        boolean hay=true;
        if(numHab>getNumHabitaciones()[tipoHab]){
            hay = false;
        }else{
            for(Reserva r: getReservas()){
                if(r.getTipoHab() == tipoHab){
                    if(r.getFecIni().compareTo(fIni)>=0 && r.getFecIni().compareTo(fFin)<=0){
                        //si la reserva empieza dentro del períoro de tiempo especificado
                        counter+=r.getNumHabitaciones();
                    }else{
                        if(r.getFecFin().compareTo(fIni)>=0 && r.getFecFin().compareTo(fFin)<=0){
                            //si la reserva termina dentro del períoro de tiempo especificado
                            counter+=r.getNumHabitaciones();
                        }
                    }
                    //si tengo menos reservas en ese período que habitaciones totales --> Tengo libres
                    if(counter+numHab>getNumHabitaciones()[tipoHab]){
                        hay=false;
                    }
                }            
           }
        }
        return hay;
    }
    
    /**
     * Añade una nueva reserva a la lista
     * @param res
     */
    public void reserva(Reserva res){
        reservas.add(res);
    }
    
    /**
     * Constructor por defecto
     */
    public Hotel() {
        numHabitaciones[0]=11; numHabitaciones[1]=1; numHabitaciones[2]=1;
        precioHabitaciones[0]=20; precioHabitaciones[1]=30; precioHabitaciones[2]=40;
        reservas = new ArrayList<Reserva>();
    }

    /**
     * Constructor sobrecargado
     * @param cif
     * @param nom
     * @param dir
     * @param ciu
     * @param nHab
     * @param pHab 
     */
    public Hotel(String cif, String nom, String dir, String ciu, int[] nHab, float[] pHab) {
        CIF = cif;
        nombre = nom;
        direccion = dir;
        ciudad = ciu;
        numHabitaciones = nHab;
        precioHabitaciones = pHab;
        reservas = new ArrayList<Reserva>();
    }
}
