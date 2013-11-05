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
                    <li class="active"><a href="../ServletAdministrador/altaHotel">Alta nuevo hotel</a></li>
                    <li><a href="../ServletAdministrador/listadoHoteles">Listar hoteles</a></li>
                </ul>
            </div>
            <h1>Área de Administración - Alta de Hotel</h1>

            <!-- Contenido -->

            <c:if test="${respuesta == 'ok'}">
                <div class="alert alert-success fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Éxito!</strong> El hotel ha sido dado de alta correctamente
                </div>
            </c:if>
            <c:if test="${respuesta == 'error'}">
                <div class="alert alert-danger fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Oops!</strong> El hotel no ha podido ser dado de alta. Inténtelo de nuevo.
                </div>
            </c:if>

            <form class="form-horizontal" role="form" method="post" action="../ServletAdministrador/altaHotel">
                <div class="form-group">
                    <label for="cif" class="col-sm-2 control-label">CIF</label>
                    <div class="col-sm-10">
                        <input type="text" name="cif" class="form-control" id="cif" placeholder="CIF del hotel">
                    </div>
                </div>
                <div class="form-group">
                    <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                    <div class="col-sm-10">
                        <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre del hotel">
                    </div>
                </div>
                <div class="form-group">
                    <label for="direccion" class="col-sm-2 control-label">Dirección</label>
                    <div class="col-sm-10">
                        <input type="text" name="direccion" class="form-control" id="direccion" placeholder="Dirección del hotel">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ciudad" class="col-sm-2 control-label">Ciudad</label>
                    <div class="col-sm-10">
                        <input type="text" name="ciudad" class="form-control" id="ciudad" placeholder="Ciudad donde está el hotel">
                    </div>
                </div>
                <div class="form-group"> <!--Cambiar por un spinner-->
                    <label for="numHabitacionesIndividual" class="col-sm-2 control-label">Núm. Hab. Individuales</label>
                    <div class="col-sm-4">
                        <input type="text" name="numHabitacionesIndividual" class="form-control" id="numHabitacionesIndividual" placeholder="Número de habitaciones individuales">
                    </div>
                    <label for="precioHabitacionesIndividual" class="col-sm-2 control-label">Precio</label>
                    <div class="col-sm-4 input-group">
                        <input type="text" name="precioHabitacionesIndividual" class="form-control" id="precioHabitacionesIndividual" placeholder="Precio de las habitaciones individuales">
                        <span class="input-group-addon">€</span>
                    </div>
                </div>
                <div class="form-group"> <!--Cambiar por un spinner-->
                    <label for="numHabitacionesDoble" class="col-sm-2 control-label">Núm. Hab. Dobles</label>
                    <div class="col-sm-4">
                        <input type="text" name="numHabitacionesDoble" class="form-control" id="numHabitacionesDoble" placeholder="Número de habitaciones dobles">
                    </div>
                    <label for="precioHabitacionesDoble" class="col-sm-2 control-label">Precio</label>
                    <div class="col-sm-4 input-group">
                        <input type="text" name="precioHabitacionesDoble" class="form-control" id="precioHabitacionesDoble" placeholder="Precio de las habitaciones dobles">
                        <span class="input-group-addon">€</span>
                    </div>
                </div>
                <div class="form-group"> <!--Cambiar por un spinner-->
                    <label for="numHabitacionesTriple" class="col-sm-2 control-label">Núm. Hab. Triples</label>
                    <div class="col-sm-4">
                        <input type="text" name="numHabitacionesTriple" class="form-control" id="numHabitacionesTriple" placeholder="Número de habitaciones para grupos / niños">
                    </div>
                    <label for="precioHabitacionesTriple" class="col-sm-2 control-label">Precio</label>
                    <div class="col-sm-4 input-group">
                        <input type="text" name="precioHabitacionesTriple" class="form-control" id="precioHabitacionesTriple" placeholder="Precio de las habitaciones por grupos / niños">
                        <span class="input-group-addon">€</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success" name="enviadoNuevoHotel" value="Dar de alta nuevo hotel"/>
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
