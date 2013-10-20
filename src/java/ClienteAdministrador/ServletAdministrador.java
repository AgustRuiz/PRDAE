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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");

            WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            ServicioAdministrador sa = (ServicioAdministrador) appContext.getBean("servicioAdministrador");

//            out.println(sa.getListaHoteles().size());
//            //prueba creación de objetos
//            Hotel hot = new Hotel();
//            sa.getAdmin().altaHotel(hot);
//            //prueba borrado de objetos
//            sa.getAdmin().bajaHotel("11111111A");
//            sa.getAdmin().bajaHotel("22222222B");
//            out.println(sa.getListaHoteles().size());


            //Pruebas para insertar un nuevo operador
//            try {
//                Operador op = new Operador("444B", "david", "direccion");
//                sa.getAdmin().altaOperador(op);
//            } catch (ErrorInsercion e) {
//                out.println(e.getMessage());
//            }



            //Get la string acction
            String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

            out.println("<h1>Área de Administración</h1>");
            //Menú principal
            out.println("<ul>");
            out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/altaOperador\">Alta Operador</a></li>");
            out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoOperadores\">Listar Operadores</a></li>");
            out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/altaHotel\">Alta Hotel</a></li>");
            out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoHoteles\">Listar Hoteles</a></li>");
            out.println("</ul>");

            if (action.equals("/altaOperador")) {
                out.println("<h2>Alta de operador</h2>");
                //Procesando nuevo operador
                if (request.getParameter("enviadoNuevoOperador") != null) {
                    try {
                        Operador op = new Operador(request.getParameter("cif"), request.getParameter("nombre"), request.getParameter("direccion"));
                        sa.getAdmin().altaOperador(op);
                        out.println("<div><strong><em>Éxito al crear el operador</em></strong></div>");
                    } catch (ErrorInsercion e) {
                        out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                    }
                }
                //Formulario para agregar nuevo cliente
                out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/altaOperador\">");
                out.println("<div><label>Nombre: <input type=\"text\" name=\"nombre\" /></label></div>");
                out.println("<div><label>Dirección: <input type=\"text\" name=\"direccion\" /></label></div>");
                out.println("<div><label>CIF: <input type=\"text\" name=\"cif\" /></label></div>");
                out.println("<div><input type=\"submit\" name=\"enviadoNuevoOperador\" value=\"Crear\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                out.println("</form>");
            } else if (action.equals("/listadoOperadores")) {
                out.println("<h2>Listado de operadores</h2>");
                //Procesando nuevo operador
                if (request.getParameter("cifOperadorEliminar") != null) {
                    try {
                        sa.getAdmin().bajaOperador(request.getParameter("cifOperadorEliminar"));
                        out.println("<div><strong><em>Éxito al eliminar el operador</em></strong></div>");
                    } catch (Exception e) {
                        out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                    }
                }
                //Procesar lista de operadores
                Map<String, Operador> listaOperadores = sa.getListaOperadores();
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Dirección</th>");
                out.println("<th>CIF</th>");
                out.println("<th>Operaciones</th>");
                out.println("</tr>");
                for (Operador op : listaOperadores.values()) {
                    out.println("<tr>");
                    out.println("<td>" + op.getNombre() + "</td>");
                    out.println("<td>" + op.getDireccion() + "</td>");
                    out.println("<td>" + op.getCIF() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoOperadores?cifOperadorEliminar=" + op.getCIF() + "\">Eliminar</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

            } else if (action.equals("/altaHotel")) {
                
                
                
                
                
                out.println("<h2>Alta de hotel</h2>");
                //Procesando nuevo operador
                if (request.getParameter("enviadoNuevoHotel") != null) {
                    try {
                        Hotel hotel = new Hotel();
                        hotel.setCIF(request.getParameter("cif"));
                        hotel.setNombre(request.getParameter("nombre"));
                        hotel.setDireccion(request.getParameter("direccion"));
                        hotel.setCiudad(request.getParameter("ciudad"));
                        sa.getAdmin().altaHotel(hotel);
                        out.println("<div><strong><em>Éxito al crear el hotel</em></strong></div>");
                    } catch (ErrorInsercion e) {
                        out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                    }
                }
                //Formulario para agregar nuevo cliente
                out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/altaHotel\">");
                out.println("<div><label>CIF: <input type=\"text\" name=\"cif\" /></label></div>");
                out.println("<div><label>Nombre: <input type=\"text\" name=\"nombre\" /></label></div>");
                out.println("<div><label>Dirección: <input type=\"text\" name=\"direccion\" /></label></div>");
                out.println("<div><label>Ciudad: <input type=\"text\" name=\"ciudad\" /></label></div>");
                
                out.println("<div><em>La parte de las habitaciones y el precio hay que trabajarlo porque no me queda claro (Agustín Ruiz)</em></div>");
                
                out.println("<div><input type=\"submit\" name=\"enviadoNuevoHotel\" value=\"Crear\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                out.println("</form>");
                
                
                
                
                
                
                
                
                
                
                
            } else if (action.equals("/listadoHoteles")) {
                out.println("<h2>Listado de hoteles</h2>");
                //Procesando nuevo hotel
                if (request.getParameter("cifHotelEliminar") != null) {
                    try {
                        sa.getAdmin().bajaHotel(request.getParameter("cifHotelEliminar"));
                        out.println("<div><strong><em>Éxito al eliminar el hotel</em></strong></div>");
                    } catch (Exception e) {
                        out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                    }
                }
                //Procesar lista de hoteles
                Map<String, Hotel> listaHoteles = sa.getListaHoteles();
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Ciudad</th>");
                out.println("<th>Dirección</th>");
                out.println("<th>CIF</th>");
                out.println("<th>Operaciones</th>");
                out.println("</tr>");
                for (Hotel hotel : listaHoteles.values()) {
                    out.println("<tr>");
                    out.println("<td>" + hotel.getNombre() + "</td>");
                    out.println("<td>" + hotel.getCiudad() + "</td>");
                    out.println("<td>" + hotel.getDireccion() + "</td>");
                    out.println("<td>" + hotel.getCIF() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoHoteles?cifHotelEliminar=" + hotel.getCIF() + "\">Eliminar</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("<div>Seleccione alguna opción del menú</div>");
            }








            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
