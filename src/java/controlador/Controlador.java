/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Celular;
import modelo.CelularDAO;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 *
 * @author xxx
 */
@MultipartConfig
public class Controlador extends HttpServlet {

    /*String usuarioDefecto = "ivan";
    String contraDefecto = "12345";*/
    Celular celular = new Celular();
    CelularDAO celularDAO = new CelularDAO();
    int idCelular;
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    int idCliente;

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
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");

        switch (accion) {

            case "Principal":
                request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
                break;

            case "Listar":
                List<Celular> lista = celularDAO.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("ListaDeCelulares.jsp").forward(request, response);
                break;

            case "Agregar":
                request.getRequestDispatcher("AgregarCelular.jsp").forward(request, response);
                break;

            case "Agregar nuevo celular":
                String marca = request.getParameter("marca");
                String modelo = request.getParameter("modelo");
                Double precio = Double.parseDouble(request.getParameter("precio"));
                String color = request.getParameter("color");
                int stock = Integer.parseInt(request.getParameter("stock"));
                Part part = request.getPart("fileFoto");
                InputStream inputStream = part.getInputStream();
                celular.setMarca(marca);
                celular.setModelo(modelo);
                celular.setPrecio(precio);
                celular.setColor(color);
                celular.setStock(stock);
                celular.setFoto(inputStream);
                celularDAO.agregar(celular);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;

            case "Eliminar":
                idCelular = Integer.parseInt(request.getParameter("id"));
                celularDAO.eliminar(idCelular);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;

            case "Editar":
                idCelular = Integer.parseInt(request.getParameter("id"));
                celular = celularDAO.listarId(idCelular);
                request.setAttribute("celular", celular);
                request.getRequestDispatcher("ActualizarCelular.jsp").forward(request, response);
                break;

            case "Actualizar":
                String marca1 = request.getParameter("marca");
                String modelo1 = request.getParameter("modelo");
                Double precio1 = Double.parseDouble(request.getParameter("precio"));
                String color1 = request.getParameter("color");
                int stock1 = Integer.parseInt(request.getParameter("stock"));
                Part part1 = request.getPart("fileFoto");
                InputStream inputStream1 = part1.getInputStream();
                celular.setMarca(marca1);
                celular.setModelo(modelo1);
                celular.setPrecio(precio1);
                celular.setColor(color1);
                celular.setStock(stock1);
                celular.setFoto(inputStream1);
                celular.setId(idCelular);
                celularDAO.actualizar(celular);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;

            case "ListarClientes":

                List<Cliente> listaClientes = clienteDAO.listar();
                request.setAttribute("lista", listaClientes);
                request.getRequestDispatcher("ListaDeClientes.jsp").forward(request, response);

                break;

            case "AgregarCliente":
                request.getRequestDispatcher("AgregarCliente.jsp").forward(request, response);
                break;

            case "Agregar nuevo cliente":
                String nombres = request.getParameter("nombres");
                int dni = Integer.parseInt(request.getParameter("dni"));
                cliente.setNombres(nombres);
                cliente.setDni(dni);
                clienteDAO.agregar(cliente);
                request.getRequestDispatcher("Controlador?accion=ListarClientes").forward(request, response);
                break;

            case "EliminarCliente":
                idCliente = Integer.parseInt(request.getParameter("id"));
                clienteDAO.eliminar(idCliente);
                request.getRequestDispatcher("Controlador?accion=ListarClientes").forward(request, response);
                break;

            case "EditarCliente":
                idCliente = Integer.parseInt(request.getParameter("id"));
                cliente = clienteDAO.listarId(idCliente);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("ActualizarCliente.jsp").forward(request, response);
                break;

            case "Actualizar cliente":
                String nombres1 = request.getParameter("nombres");
                int dni1 = Integer.parseInt(request.getParameter("dni"));
                cliente.setNombres(nombres1);
                cliente.setDni(dni1);
                cliente.setId(idCliente);
                clienteDAO.actualizar(cliente);
                request.getRequestDispatcher("Controlador?accion=ListarClientes").forward(request, response);
                break;

            case "RegistrarVenta":

                //Muestra la lista de clientes
                List<Cliente> listaClientes2 = clienteDAO.listar();
                request.setAttribute("lista", listaClientes2);
                idCelular = Integer.parseInt(request.getParameter("id"));
                celular = celularDAO.listarId(idCelular);
                request.setAttribute("celular", celular);

                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;

            case "Ventas":

                /*Calendar calendario=Calendar.getInstance();
                String fechaActual=calendario.get(Calendar.DATE)+"/"+calendario.get(Calendar.MONTH)+"/"+calendario.get(Calendar.YEAR);*/
                
                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                String fechaActual = ft.format(dNow);

                request.getRequestDispatcher("Ventas.jsp?fecha=" + fechaActual).forward(request, response);
                break;

            default:
                throw new AssertionError();

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
        processRequest(request, response);
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
