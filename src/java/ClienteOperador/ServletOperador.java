/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteOperador;

import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Reserva;
import es.ujaen.dae.galisteo_ruiz.hoteles.Usuario;
import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioAdministrador;
import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioOperador;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
@WebServlet(name = "ServletOperador", urlPatterns = {"/ServletOperador/*"})
public class ServletOperador extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOperador</title>");
            out.println("</head>");
            out.println("<body>");

            WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            ServicioOperador so = (ServicioOperador) appContext.getBean("servicioOperador");

            //selecciono un operador
//            Operador op = so.getListaOperadores().get("444A");
//            out.println(op.getNombre());
//
//            out.println("Busqueda por Ciudad 1, elementos: " + op.buscarPorCiudad("Ciudad 1").size());
//
//            out.println("Busqueda por Hotel1, elementos: " + op.buscarPorNombre("Hotel 1").size());
//
//            //vamos a probar las reservas
            Operador op = ServicioAdministrador.getListaOperadores().get("444A");
            //creo 2 fechas
            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
            Date f11 = sdff.parse("2013-10-11");
            Date f22 = sdff.parse("2013-10-20");
            Usuario usuario = ServicioOperador.getListaUsuarios().get("00000A");
            Hotel hot = ServicioOperador.getListaHoteles().get("22222222B");
            op.realizarReserva(usuario, hot, 6, 0, f11, f22);
            op.realizarReserva(usuario, hot, 1, 0, f11, f22);
            hot = ServicioOperador.getListaHoteles().get("11111111A");
            op.realizarReserva(usuario, hot, 1, 1, f11, f22);
//            out.println("Reservas en hotel: " + ServicioOperador.getListaHoteles().get("22222222B").getReservas().size());

            
            
//            boolean login=false;
//            Operador op = null;
//            out.println("<h2>Identificación de usuario</h2>");
//                if (request.getParameter("loginOp") != null) {
//                    op = ServicioAdministrador.getListaOperadores().get(request.getParameter("loginOp"));
//                    if(op == null){
//                        out.println("Operador no encontrado");
//                    }else{
//                        out.println("Logueado operador con CIF "+request.getParameter("loginOp"));
//                    }
//                          
//                }
//                //Formulario para login operador
//                out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/loginOperador\">");
//                out.println("<div><label>CIF operador: <input type=\"text\" name=\"loginOp\" /></label></div>");
//                out.println("<div><input type=\"submit\" name=\"lusu\" value=\"Login\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
//                out.println("</form>");

            //if(op != null){
                //Get la string acction
                String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

                out.println("<h1>Área de operador</h1>");



                //Menú principal
                out.println("<ul>");
                out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/altaUsuario\">Alta Cliente</a></li>");
                out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoUsuarios\">Listar Clientes</a></li>");
                out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/busquedaCiudad\">Buscar hotel por ciudad</a></li>");
                out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/busquedaNombre\">Buscar hotel por nombre</a></li>");
                out.println("<li><a href=\"" + request.getContextPath() + request.getServletPath() + "/busquedaFecha\">Buscar por fechas</a></li>");

                out.println("</ul>");

                if (action.equals("/altaUsuario")) {
                    out.println("<h2>Alta de clientes</h2>");

                    //Procesando nuevo operador
                    if (request.getParameter("enviadoNuevoUsuario") != null) {
                        try {
                            Usuario us = new Usuario(request.getParameter("dni"), request.getParameter("nombre"), request.getParameter("direccion"));
                            ServicioOperador.getListaUsuarios().put(request.getParameter("dni"), us);
                            out.println("<div><strong><em>Éxito al crear el operador</em></strong></div>");
                        } catch (Exception e) {
                            out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                        }
                    }
                    //Formulario para agregar nuevo cliente
                    out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/altaUsuario\">");
                    out.println("<div><label>DNI: <input type=\"text\" name=\"dni\" /></label></div>");
                    out.println("<div><label>Nombre: <input type=\"text\" name=\"nombre\" /></label></div>");
                    out.println("<div><label>Dirección: <input type=\"text\" name=\"direccion\" /></label></div>");
                    out.println("<div><input type=\"submit\" name=\"enviadoNuevoUsuario\" value=\"Crear\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                    out.println("</form>");
                } else if (action.equals("/listadoUsuarios")) {
                    out.println("<h2>Listado de clientes</h2>");
                    //Procesando eliminar operador
                    if (request.getParameter("dniUsuarioEliminar") != null) {
                        try {
                            ServicioOperador.getListaUsuarios().remove(request.getParameter("dniUsuarioEliminar"));
                            out.println("<div><strong><em>Éxito al eliminar el usuario</em></strong></div>");
                        } catch (Exception e) {
                            out.println("<div><strong><em>ERROR: </em>"+e.getMessage()+"</strong></div>");
                        }
                    }
                    //Procesar lista de usuarios
                    Map<String, Usuario> listaUsuarios = ServicioOperador.getListaUsuarios();
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>DNI</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Dirección</th>");
                    out.println("</tr>");
                    for (Usuario us : listaUsuarios.values()) {
                        out.println("<tr>");
                        out.println("<td>" + us.getDNI() + "</td>");
                        out.println("<td>" + us.getNombre() + "</td>");
                        out.println("<td>" + us.getDireccion() + "</td>");
                        out.println("<td>");
                        out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoUsuarios?dniUsuarioEliminar=" + us.getDNI() + "\">Eliminar</a> ");
                        out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/verReservas?dniUsuarioEliminar=" + us.getDNI() + "\">Ver reservas</a> ");
                        //out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/realizarReserva?dniUsuarioEliminar=" + us.getDNI() + "\">Realizar reserva</a> ");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                } else if (action.equals("/verReservas")) {
                    String dniUser = request.getParameter("dniUsuarioEliminar");
                    out.println("<h2>Reservas del usuario "+dniUser+"</h2>");
                    Usuario usu = ServicioOperador.getListaUsuarios().get(dniUser);
                    ArrayList<Reserva> listadoReservas;
                    listadoReservas = (ArrayList<Reserva>) usu.getListaReservas();
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<th>CIF Hotel</th>");
                        out.println("<th>Fecha inicio</th>");
                        out.println("<th>Fecha fin</th>");
                        out.println("<th>Número de habitaciones</th>");
                        out.println("<th>Tipo de habitaciones</th>");
                        out.println("</tr>");
                        Reserva[] valor;
                        valor = ( Reserva[] )listadoReservas.toArray( new Reserva[ listadoReservas.size() ] );
                        int i;
                        for(i=0;i<listadoReservas.size();i++){
                            out.println("<tr>");
                            out.println("<td>" + valor[i].getHotel().getCIF() + "</td>");
                            out.println("<td>" + valor[i].getFecIni() + "</td>");
                            out.println("<td>" + valor[i].getFecFin() + "</td>");
                            out.println("<td>" + valor[i].getNumHabitaciones() + "</td>");
                            out.println("<td>" + valor[i].getTipoHab() + "</td>");
                            out.println("</td>");
                            out.println("</tr>");
                        
                    }

                } else if (action.equals("/realizarReserva")) {
                    out.println("<h2>Realizar reservas</h2>");

                }else if (action.equals("/busquedaCiudad")){
                    out.println("<h2>Búsqueda por ciudad</h2>");
                    if (request.getParameter("ciu") != null) {
                        ArrayList<Hotel> listadoHoteles = (ArrayList<Hotel>) op.buscarPorCiudad(request.getParameter("ciu"));
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<th>CIF</th>");
                        out.println("<th>Nombre</th>");
                        out.println("<th>Dirección</th>");
                        out.println("<th>Ciudad</th>");
                        out.println("</tr>");
                        Hotel[] valor;
                        valor = ( Hotel[] )listadoHoteles.toArray( new Hotel[ listadoHoteles.size() ] );
                        int i;
                        for(i=0;i<listadoHoteles.size();i++){
                            out.println("<tr>");
                            out.println("<td>" + valor[i].getCIF() + "</td>");
                            out.println("<td>" + valor[i].getNombre() + "</td>");
                            out.println("<td>" + valor[i].getDireccion() + "</td>");
                            out.println("<td>" + valor[i].getCiudad() + "</td>");
//                            out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/listadoUsuarios?dniUsuarioEliminar=" + us.getDNI() + "\">Eliminar</a> ");
//                            out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/verReservas?dniUsuarioEliminar=" + us.getDNI() + "\">Ver reservas</a> ");
//                            out.println("<a href=\"" + request.getContextPath() + request.getServletPath() + "/realizarReserva?dniUsuarioEliminar=" + us.getDNI() + "\">Realizar reserva</a> ");
                            out.println("</td>");
                            out.println("</tr>");
                        
                    }
                    out.println("</table>");
                    }
                    //Formulario para buscar por ciudad
                    out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/busquedaCiudad\">");
                    out.println("<div><label>Ciudad: <input type=\"text\" name=\"ciu\" /></label></div>");
                    out.println("<div><input type=\"submit\" name=\"bciu\" value=\"Buscar\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                    out.println("</form>");
                } else if (action.equals("/busquedaNombre")){
                    out.println("<h2>Búsqueda por Nombre</h2>");
                    if (request.getParameter("nom") != null) {
                        ArrayList<Hotel> listadoHoteles = (ArrayList<Hotel>) op.buscarPorNombre(request.getParameter("nom"));
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<th>CIF</th>");
                        out.println("<th>Nombre</th>");
                        out.println("<th>Dirección</th>");
                        out.println("<th>Ciudad</th>");
                        out.println("</tr>");
                        Hotel[] valor;
                        valor = ( Hotel[] )listadoHoteles.toArray( new Hotel[ listadoHoteles.size() ] );
                        int i;
                        for(i=0;i<listadoHoteles.size();i++){
                            out.println("<tr>");
                            out.println("<td>" + valor[i].getCIF() + "</td>");
                            out.println("<td>" + valor[i].getNombre() + "</td>");
                            out.println("<td>" + valor[i].getDireccion() + "</td>");
                            out.println("<td>" + valor[i].getCiudad() + "</td>");
                            out.println("</td>");
                            out.println("</tr>");
                        
                    }
                    out.println("</table>");
                    }
                    //Formulario para buscar por nombre
                    out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/busquedaNombre\">");
                    out.println("<div><label>Nombre: <input type=\"text\" name=\"nom\" /></label></div>");
                    out.println("<div><input type=\"submit\" name=\"bnom\" value=\"Buscar\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                    out.println("</form>");
                } else if (action.equals("/busquedaFecha")){
                    out.println("<h2>Búsqueda por Fecha</h2>");
                    if (request.getParameter("hab") != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date f1 = sdf.parse(request.getParameter("fIni"));
                        Date f2 = sdf.parse(request.getParameter("fFin"));
                        String tipo = request.getParameter("hab");
                        int tHab = 0;
                        if(tipo.equals("0"))
                            tHab = 0;
                        if(tipo.equals("1"))
                            tHab = 1;
                        if(tipo.equals("2"))
                            tHab = 2;
                            
                        ArrayList<Hotel> listadoHoteles;
                        listadoHoteles = (ArrayList<Hotel>) op.bucarPorFecha(tHab, f1, f2);
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<th>CIF</th>");
                        out.println("<th>Nombre</th>");
                        out.println("<th>Dirección</th>");
                        out.println("<th>Ciudad</th>");
                        out.println("</tr>");
                        Hotel[] valor;
                        valor = ( Hotel[] )listadoHoteles.toArray( new Hotel[ listadoHoteles.size() ] );
                        int i;
                        for(i=0;i<listadoHoteles.size();i++){
                            out.println("<tr>");
                            out.println("<td>" + valor[i].getCIF() + "</td>");
                            out.println("<td>" + valor[i].getNombre() + "</td>");
                            out.println("<td>" + valor[i].getDireccion() + "</td>");
                            out.println("<td>" + valor[i].getCiudad() + "</td>");
                            out.println("</td>");
                            out.println("</tr>");
                        
                    }
                    out.println("</table>");
                }
                    //Formulario para buscar por fecha
                    out.println("<form method=\"post\" action=\"" + request.getContextPath() + request.getServletPath() + "/busquedaFecha\">");
                    out.println("<div><label>Tipo Habitacion: <input type=\"text\" name=\"hab\" /></label></div>");
                    out.println("<div><label>Fecha inicio: <input type=\"text\" name=\"fIni\" /></label></div>");
                    out.println("<div><label>Fecha fin: <input type=\"text\" name=\"fFin\" /></label></div>");
                    out.println("<div><input type=\"submit\" name=\"bfec\" value=\"Buscar\"/><input type=\"reset\" value=\"Limpiar formulario\"/></div>");
                    out.println("</form>");
                }


                out.println("</body>");
                out.println("</html>");
            //} 
        }finally{
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
        } catch (ParseException ex) {
            Logger.getLogger(ServletOperador.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ServletOperador.class.getName()).log(Level.SEVERE, null, ex);
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
