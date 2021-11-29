<%-- 
    Document   : Mostrar
    Created on : 24/10/2021, 4:00:02 p. m.
    Author     : thene
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Ver productos</title>
    </head>
    <style>
        table {
            text-align: center;
        }
    </style>

    <body>
        <div class="container">
            <div class="row">
                <div class="shadow-lg p-3 mb-5 mt-4 bg-body rounded">
                    <div class="d-sm-flex justify-content-between mb-4">
                        <h1>Tabla de productos disponibles</h1>
                    </div>
                    <div class="d-flex m-auto ">
                        <div class="m-2">
                            <a href="ServletControlador?accion=irindex" class="btn btn-outline-primary" role="button">Ir al inicio</a>
                        </div>
                        <div class="m-2">
                            <a href="ServletControlador?accion=agregarindex" class="btn btn-success" role="button">Agregar nuevo</a>
                        </div>
                        <div class="m-2">
                            <form class="d-flex" action="ServletControlador">
                                <input class="form-control me-2" type="search" placeholder="Buscar producto" name="txtBuscar"/>
                                <input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
                            </form>
                        </div>
                        <div class="m-2">
                            <a href="ServletControlador?accion=comprar" class="btn btn-primary" role="button">Comprar productos</a>
                        </div>
                        <div class="m-2">
                            <a href="ServletControlador?accion=cerrarsesion" class="btn btn-danger" role="button">Cerrar sesión</a>
                        </div>
                    </div>
                    <table class="table table-bordered table-striped table-hover caption-top">
                        <caption>Lista de productos</caption>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Referencia</th>
                                <th>Cantidad</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <%

                            ProductoDAO pdao = new ProductoDAO();
                            String busqueda = request.getParameter("txtBuscar");
                            List<Producto> listaP;
                            
                            if (busqueda==null || busqueda.isEmpty()) {
                                 listaP = pdao.mostrar();
                           }else {
                                listaP = pdao.mostrarIndividual(busqueda);
                            }
                            Iterator<Producto> iterador = listaP.iterator();
                            Producto pr = null;

                            while (iterador.hasNext()) {
                                pr = iterador.next();

                        %>
                        <tbody>
                            <tr>
                                <td><%= pr.getId()%></td>
                                <td><%= pr.getNombre()%></td>                        
                                <td><%= pr.getPrecio()%></td>  
                                <td><%= pr.getCodigo()%></td>
                                <td><%= pr.getCantidad()%></td>
                                <td colspan="2">
                                    <a class="btn btn-primary" href="ServletControlador?accion=editar&id=<%= pr.getId()%>">Editar</a>                            
                                    <a class="btn btn-danger" href="ServletControlador?accion=eliminar&id=<%= pr.getId()%>">Eliminar</a>
                                </td>
                            </tr>

                        </tbody>
                        <% }%>
                    </table>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>
