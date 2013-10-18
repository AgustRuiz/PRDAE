/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteOperador;

import es.ujaen.dae.galisteo_ruiz.hoteles.Hotel;
import es.ujaen.dae.galisteo_ruiz.hoteles.Operador;
import es.ujaen.dae.galisteo_ruiz.hoteles.Usuario;
import es.ujaen.dae.galisteo_ruiz.hoteles.beans.ServicioOperador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 */
@WebServlet(name = "ServletOperador", urlPatterns = {"/ServletOperador"})
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
            Operador op = so.getListaOperadores().get("444A");
            out.println(op.getNombre());
            
            out.println("Busqueda por Ciudad 1, elementos: "+op.buscarPorCiudad("Ciudad 1").size());
            
            out.println("Busqueda por Hotel1, elementos: "+op.buscarPorNombre("Hotel 1").size());
            
            //vamos a probar las reservas
            //creo 2 fechas
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date f1 = sdf.parse("2013-10-11");
            Date f2 = sdf.parse("2013-10-20");
            Usuario usu = ServicioOperador.getListaUsuarios().get("00000A");
            Hotel hot = ServicioOperador.getListaHoteles().get("22222222B");
            op.realizar_reserva(usu, hot, 6, 0, f1, f2);
            op.realizar_reserva(usu, hot, 1, 0, f1, f2);
            op.realizar_reserva(usu, hot, 1, 1, f1, f2);
            out.println("Reservas en hotel: "+ServicioOperador.getListaHoteles().get("22222222B").getReservas().size());
            
            out.println("<h1>Servlet ServletOperador at " + request.getContextPath() + "</h1>");
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
