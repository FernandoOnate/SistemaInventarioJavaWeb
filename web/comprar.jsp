<%-- 
    Document   : comprar
    Created on : 16/11/2021, 5:02:26 p. m.
    Author     : thene
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Comprar</title>
    </head>

    <body><br><br>
        <style>
            table {
                text-align: center;
            }
        </style>
        <div class="container">
            <div class="row">
                <div class="shadow-lg p-3 mb-5 mt-4 bg-body rounded">
                    <div class="justify-content-between mb-4">
                        <h1>Comprar un producto</h1><br>
                        <div class="m-2">
                            <a href="ServletControlador?accion=ver" class="btn btn-success" role="button">Volver</a>
                        </div>

                        <table class="table table-bordered table-striped table-hover caption-top">
                            <caption>Lista de productos</caption>
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Cantidad a comprar</th>
                                    <th>Efectuar compra</th>
                                </tr>
                            </thead>
                            <%
                                ProductoDAO pdao = new ProductoDAO();
                                List<Producto> listaP = pdao.mostrar();
                                Iterator<Producto> iterador = listaP.iterator();
                                Producto pr = null;
                                while (iterador.hasNext()) {
                                    pr = iterador.next();

                            %>
                            <tbody>
                                <tr>
                                    <td><%= pr.getNombre()%></td>                        
                                    <td><%= pr.getPrecio()%></td> 
                                    <td><%= pr.getCantidad()%></td>
                                    <td>  
                                        <form action="ServletControlador" method="get">
                                            <input type="number" name="txtCantidad" placeholder="No mayor a: <%= pr.getCantidad()%>" > </td>
                                            <td>
                                                <input class="btn btn-primary" type="submit" name="accion" value="Efectuar">
                                                <input type="hidden" name="id_producto" value="<%= pr.getId()%>">
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                            <% }%>
                        </table>

                    </div>
                </div>
            </div>
        </div>

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>
