<%-- 
    Document   : login
    Created on : 4/11/2021, 11:40:23 p. m.
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
    <link rel="stylesheet" href="../../css/hoja_estilos_css.css">

    <title>Login</title>
</head>
<body><br><br>
    <div class="container w-50">
        <div class="row w-75 m-auto">
            <div class="shadow-lg p-5 mb-4 mt-3 bg-body rounded">
                <div class="justify-content-between">
                    <h1>Login de usuario</h1><br>
                    <form class="row g-3 needs-validation" method="post" action="ServletControlador" novalidate>
                        <div class="mb-2">
                            <label class="form-label" for="txtCorreo">Identificación:</label>
                            <input type="number" class="form-control" placeholder="Ingresa tu identificacion" id="txtCorreo" name="ide_user" required="">
                            <div class="valid-feedback">
                                Identificación válida.
                            </div>
                            <div class="invalid-feedback">
                                Identificación inválida.
                            </div>
                        </div>
                        <div class="mb-2">
                            <label class="form-label" for="txtPass">Contraseña:</label>
                            <input type="password" class="form-control" placeholder="Ingresa tu contraseña" id="txtPass" name="user_clave" required="">                      
                            <div class="valid-feedback">
                                Contraseña válida.
                            </div>
                            <div class="invalid-feedback">
                                Contraseña inválida.
                            </div><br>
                            <div>
                                <a href="" class="olvido">¿Se te ha olvidado la contraseña?</a>
                            </div>
                            
                        </div>
                        <input type="submit" name="accion" class="btn btn-success" value="Ingresar">
                        <a href="ServletControlador?accion=registroUser" class="btn btn-primary">Registrarte</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function(form) {
                    form.addEventListener('submit', function(event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</body>

</html>
