package Controlador;

import Modelo.Producto;
import Modelo.Usuario;
import ModeloDAO.ProductoDAO;
import ModeloDAO.UsuarioDAO;
import javax.swing.text.Document;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando oñate
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    String mostrar = "vistas/Mostrar.jsp";
    String agregar = "vistas/Agregar.jsp";
    String editar = "vistas/Editar.jsp";
    String registroUsuario = "vistas/AgregarUsuario.jsp";
    String index = "index.jsp";
    String login = "login.jsp";
    String comprar = "comprar.jsp";
    String error = "errorCompra.jsp";
    Producto p = new Producto();
    Usuario user = new Usuario();
    ProductoDAO dao = new ProductoDAO();
    UsuarioDAO daou = new UsuarioDAO();
    int resu;

    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      
        String accion = request.getParameter("accion");
       if (accion.equalsIgnoreCase("ingresar")) {

            String ide_usuario = request.getParameter("ide_user");
            String clave = request.getParameter("user_clave");

            user.setIdentificacion(ide_usuario);
            user.setClave(clave);
            resu = daou.validar(user);

            if (resu == 1) {
                user = daou.mostrarUsuario(clave);
                
                request.getSession().setAttribute("nombreUser", user.getNombre());
                request.getSession().setAttribute("identificacion_usuario", ide_usuario);
                request.getSession().setAttribute("clave_usuario", clave);
                accion = index;
            }
            else {
                accion = login;
            }
        } 
        request.getRequestDispatcher(accion).forward(request, response);
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("ver")) {
            acceso = mostrar;

        } else if (action.equalsIgnoreCase("agregarindex")) {
            acceso = agregar;

        } else if (action.equalsIgnoreCase("agregar")) {
            String nombre = request.getParameter("txtNombre");
            Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            String codigo = request.getParameter("txtCodigo");
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            p.setNombre(nombre);
            p.setCodigo(codigo);
            p.setPrecio(precio);
            p.setCantidad(cantidad);
            dao.agregar(p);
            acceso = mostrar;

        } else if (action.equalsIgnoreCase("insertar")) {
            String nombre = request.getParameter("name");
            String apellidos = request.getParameter("last_name");
            String identificacion = request.getParameter("ide");
            String telefono = request.getParameter("phone");
            String codigo_admin = request.getParameter("user_code");
            String correo = request.getParameter("mail");
            String clave = request.getParameter("pass");
            
            user.setNombre(nombre);
            user.setApellido(apellidos);
            user.setIdentificacion(identificacion);
            user.setCorreo(correo);
            user.setTelefono(telefono);
            user.setCodigo_admin(codigo_admin);
            user.setClave(clave);
            
            daou.agregarUsuario(user);
            acceso = registroUsuario;

        }else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idProd", request.getParameter("id"));
            acceso = editar;

        } else if (action.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String nombre = request.getParameter("txtNombre");
            Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            String codigo = request.getParameter("txtCodigo");
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            p.setNombre(nombre);
            p.setCodigo(codigo);
            p.setPrecio(precio);
            p.setCantidad(cantidad);
            p.setId(id);
            dao.editar(p);
            acceso = mostrar;

        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso = mostrar;

        } else if (action.equalsIgnoreCase("irindex")) {
            acceso = index;

        } else if (action.equalsIgnoreCase("cerrarsesion")) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("identificacion_usuario", null);
            sesion.setAttribute("clave_usuario", null);
            sesion.setAttribute("nombreUser", null);
            sesion.invalidate();
            request.getRequestDispatcher(login).forward(request, response);
        }else if (action.equalsIgnoreCase("registroUser")) {
            acceso = registroUsuario;

        }else if (action.equalsIgnoreCase("login")) {
            acceso = login;

        }else if (action.equalsIgnoreCase("comprar")) {
            acceso = comprar;

        }else if (action.equalsIgnoreCase("efectuar")) {
            id = Integer.parseInt(request.getParameter("id_producto"));
            int cant = Integer.parseInt(request.getParameter("txtCantidad"));
            boolean compra = dao.comprar(cant, id);
            if(!compra){
                acceso = error;
            }else{
                acceso = comprar;
            }
        }else if (action.equalsIgnoreCase("buscar")) {
            acceso = mostrar;

        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
