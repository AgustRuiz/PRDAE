package ClienteAdministrador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioAdministrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.excepciones.ErrorInsercion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author juanpepe
 * @author Agustín Ruiz Linares (arl00029@red.ujaen.es)
 */
@WebServlet(name = "ServletAdministrador", urlPatterns = {"/ServletAdministrador/*"})
public class ServletAdministrador extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        //PrintWriter out = response.getWriter();

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        String srvUrl = request.getContextPath() + request.getServletPath();

        RequestDispatcher rd;
        request.setAttribute("srvUrl", srvUrl);

        try {
            if (action.equals("/altaOperador")) {
                //Procesando nuevo operador
                if (request.getParameter("enviadoNuevoOperador") != null) {
                    try {
                        Operador op = new Operador(request.getParameter("cif"), request.getParameter("nombre"), request.getParameter("direccion"));
                        ServicioAdministrador.getAdmin().altaOperador(op);
                        request.setAttribute("respuesta", "ok");
                    } catch (ErrorInsercion e) {
                        request.setAttribute("respuesta", "error");
                    }
                }
                rd = request.getRequestDispatcher("/WEB-INF/administrador/altaOperador.jsp");
                rd.forward(request, response);
            } else if (action.equals("/listadoOperadores")) {
                //Procesando nuevo operador
                if (request.getParameter("cifOperadorEliminar") != null) {
                    try {
                        ServicioAdministrador.getAdmin().bajaOperador(request.getParameter("cifOperadorEliminar"));
                        request.setAttribute("eliminarOperador", true);      
                        request.setAttribute("nombreOperador", request.getParameter("nombreOperador"));
                    } catch (Exception e) {
                        request.setAttribute("eliminarOperador", false);
                    }
                }
                //Procesar lista de operadores
                Map<String, Operador> listaOperadores = ServicioAdministrador.getListaOperadores();
                request.setAttribute("listaOperadores", listaOperadores);
                rd = request.getRequestDispatcher("/WEB-INF/administrador/listadoOperadores.jsp");
                rd.forward(request, response);
            } else if (action.equals("/altaHotel")) {
                //Procesando nuevo operador
                if (request.getParameter("enviadoNuevoHotel") != null) {//*
                    try {
                        Hotel hotel = new Hotel();
                        hotel.setCIF(request.getParameter("cif"));
                        hotel.setNombre(request.getParameter("nombre"));
                        hotel.setDireccion(request.getParameter("direccion"));
                        hotel.setCiudad(request.getParameter("ciudad"));
                        int[] numHabitaciones = new int[3];
                        numHabitaciones[0] = Integer.parseInt(request.getParameter("numHabitacionesIndividual"));
                        numHabitaciones[1] = Integer.parseInt(request.getParameter("numHabitacionesDoble"));
                        numHabitaciones[2] = Integer.parseInt(request.getParameter("numHabitacionesTriple"));
                        hotel.setNumHabitaciones(numHabitaciones);
                        float[] precioHabitaciones = new float[3];
                        precioHabitaciones[0] = Float.parseFloat(request.getParameter("precioHabitacionesIndividual"));
                        precioHabitaciones[1] = Float.parseFloat(request.getParameter("precioHabitacionesDoble"));
                        precioHabitaciones[2] = Float.parseFloat(request.getParameter("precioHabitacionesTriple"));
                        hotel.setPrecioHabitaciones(precioHabitaciones);
                        ServicioAdministrador.getAdmin().altaHotel(hotel);
                        request.setAttribute("respuesta", "ok");
                    } catch (ErrorInsercion e) {
                        request.setAttribute("respuesta", "error");
                    }
                }
                rd = request.getRequestDispatcher("/WEB-INF/administrador/altaHotel.jsp");
                rd.forward(request, response);
            } else if (action.equals("/listadoHoteles")) {
                
                
                
                
                
//                out.println("<h2>Listado de hoteles</h2>");
                //Procesando nuevo hotel
                if (request.getParameter("cifHotelEliminar") != null) {
                    try {
                        ServicioAdministrador.getAdmin().bajaHotel(request.getParameter("cifHotelEliminar"));
//                        out.println("<div><strong><em>Éxito al eliminar el hotel</em></strong></div>");
                    } catch (Exception e) {
//                        out.println("<div><strong><em>ERROR: </em>" + e.getMessage() + "</strong></div>");
                    }
                }
                //Procesar lista de hoteles
//                Map<String, Hotel> listaHoteles = ServicioAdministrador.getListaHoteles();
//                out.println("<table border=\"1\">");
//                out.println("<tr>");
//                out.println("<th>Nombre</th>");
//                out.println("<th>Ciudad</th>");
//                out.println("<th>Dirección</th>");
//                out.println("<th>CIF</th>");
//                out.println("<th colspan=\"2\">Habitaciones</th>");
//                out.println("<th>Precio</th>");
//                out.println("<th>Operaciones</th>");
//                out.println("</tr>");
//                for (Hotel hotel : listaHoteles.values()) {
//                    out.println("<tr>");
//                    out.println("<td rowspan=\"3\">" + hotel.getNombre() + "</td>");
//                    out.println("<td rowspan=\"3\">" + hotel.getCiudad() + "</td>");
//                    out.println("<td rowspan=\"3\">" + hotel.getDireccion() + "</td>");
//                    out.println("<td rowspan=\"3\">" + hotel.getCIF() + "</td>");
//                    out.println("<th>Individuales</th>");
//                    out.println("<td>" + hotel.getNumHabitaciones()[0] + "</td>");
//                    out.println("<td>" + hotel.getPrecioHabitaciones()[0] + " €</td>");
//                    out.println("<td rowspan=\"3\">");
//                    out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoHoteles?cifHotelEliminar=" + hotel.getCIF() + "\">Eliminar</a>");
//                    out.println("</td>");
//                    out.println("</tr>");
//                    out.println("<tr>");
//                    out.println("<th>Dobles</th>");
//                    out.println("<td>" + hotel.getNumHabitaciones()[1] + "</td>");
//                    out.println("<td>" + hotel.getPrecioHabitaciones()[1] + " €</td>");
//                    out.println("</tr>");
//                    out.println("<tr>");
//                    out.println("<th>Grupo/Niños</th>");
//                    out.println("<td>" + hotel.getNumHabitaciones()[2] + "</td>");
//                    out.println("<td>" + hotel.getPrecioHabitaciones()[2] + " €</td>");
//                    out.println("</tr>");
//                }
//                out.println("</table>");


                Map<String, Hotel> listaHoteles = ServicioAdministrador.getListaHoteles();
                request.setAttribute("listaHoteles", listaHoteles);

                rd = request.getRequestDispatcher("/WEB-INF/administrador/listadoHoteles.jsp");
                rd.forward(request, response);

                
                
                
                
                
                
                
                
            } else { //Home
                rd = request.getRequestDispatcher("/WEB-INF/administrador/indexAdministrador.jsp");
                rd.forward(request, response);
            }
        } finally {
//            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
