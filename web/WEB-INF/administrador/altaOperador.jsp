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
                    <li class="active"><a href="../ServletAdministrador/altaOperador">Alta nuevo operador</a></li>
                    <li><a href="../ServletAdministrador/listadoOperadores">Listar operadores</a></li>
                    <li><a href="../ServletAdministrador/altaHotel">Alta nuevo hotel</a></li>
                    <li><a href="../ServletAdministrador/listadoHoteles">Listar hoteles</a></li>
                </ul>
            </div>
            <h1>Área de Administración - Alta de Operador</h1>

            <!-- Contenido -->

            <c:if test="${respuesta == 'ok'}">
                <div class="alert alert-success fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Éxito!</strong> El operador ha sido creado correctamente
                </div>
            </c:if>
            <c:if test="${respuesta == 'error'}">
                <div class="alert alert-danger fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Oops!</strong> El operador no ha podido ser creado. Inténtelo de nuevo.
                </div>
            </c:if>

            <form class="form-horizontal" role="form" method="post" action="../ServletAdministrador/altaOperador">
                <div class="form-group">
                    <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                    <div class="col-sm-10">
                        <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre del operador">
                    </div>
                </div>
                <div class="form-group">
                    <label for="direccion" class="col-sm-2 control-label">Dirección</label>
                    <div class="col-sm-10">
                        <input type="text" name="direccion" class="form-control" id="direccion" placeholder="Dirección del operador">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cif" class="col-sm-2 control-label">CIF</label>
                    <div class="col-sm-10">
                        <input type="text" name="cif" class="form-control" id="cif" placeholder="CIF del operador">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success" name="enviadoNuevoOperador" value="Crear operador"/>
                        <input type="reset" class="btn btn-default" value="Limpiar formulario"/>
                    </div>
                </div>
            </form>

            <!-- Site footer -->
            <div class="footer">
                <p>&copy;2013 <a href="http://david.galisteocantero.com" target="_blank">Galisteo</a> & <a href="http://www.twitter.com/AgustRuiz" target="_blank">Ruiz</a></p>
            </div>

        </div> <!-- /container -->
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</html>
