<%-- 
    Document   : index
    Created on : 24/10/2021, 3:57:42 p. m.
    Author     : thene
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Index</title>
    </head>

    <body><br><br>
        <div class="container">
            <div class="row">
                <div class="shadow-lg p-3 mb-5 mt-4 bg-body rounded">
                    <div class="justify-content-between mb-4">
                        <h1>Bienvenido ${nombreUser}, elige una opción</h1><br>
                        <a href="ServletControlador?accion=ver" class="btn btn-primary" role="button">Mostrar tabla de productos</a>
                        <a href="ServletControlador?accion=agregarindex" class="btn btn-primary" role="button">Agregar nuevo producto</a>
                        <a href="ServletControlador?accion=cerrarsesion" class="btn btn-danger" role="button">Cerrar sesión</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>