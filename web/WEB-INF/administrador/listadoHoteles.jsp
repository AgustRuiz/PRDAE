<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Administración | easyHotel</title>
        <meta charset="UTF-8">

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="../img/favicon.png" />

        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/justified-nav.css">
    </head>
    <body>
        <div class="container">
            <div class="masthead">
                <ul class="nav nav-justified">
                    <li><a href="../ServletAdministrador">Home</a></li>
                    <li><a href="../ServletAdministrador/altaOperador">Alta nuevo operador</a></li>
                    <li><a href="../ServletAdministrador/listadoOperadores">Listar operadores</a></li>
                    <li><a href="../ServletAdministrador/altaHotel">Alta nuevo hotel</a></li>
                    <li class="active"><a href="../ServletAdministrador/listadoHoteles">Listar hoteles</a></li>
                </ul>
            </div>
            <h1>Área de Administración - Listado de Hoteles</h1>

            <!-- Contenido -->

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>CIF</th>
                        <th>Operaciones</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

            <!-- Site footer -->
            <div class="footer">
                <p>&copy;2013 <a href="http://david.galisteocantero.com" target="_blank">Galisteo</a> & <a href="http://www.twitter.com/AgustRuiz" target="_blank">Ruiz</a></p>
            </div>

        </div> <!-- /container -->
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</html>
