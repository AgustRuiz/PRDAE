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
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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

            <c:if test="${eliminarOperador == 'true'}">
                <div class="alert alert-success fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Éxito!</strong> El operador "${nombreOperador}" ha sido eliminado del sistema
                </div>
            </c:if>
            <c:if test="${eliminarOperador == 'false'}">
                <div class="alert alert-danger fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>¡Oops!</strong> No se ha podido eliminar el operador
                </div>
            </c:if>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>CIF</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Ciudad</th>
                        <th>Hab. Individuales</th>
                        <th>Hab. Dobles</th>
                        <th>Hab. Triples</th>
                        <th>Operaciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="h" items="${listaHoteles}">
                        <tr>
                            <td>
                                ${h.value.CIF}
                            </td>
                            <td>
                                ${h.value.nombre}
                            </td>
                            <td>
                                ${h.value.direccion}
                            </td>
                            <td>
                                ${h.value.ciudad}
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <span style="display:none;" class="nombre">${h.value.nombre}</span>
                                <span style="display:none;" class="CIF">${h.value.CIF}</span>
                                <a class="btn btn-default" href="#" data-toggle="modal"><span class="glyphicon glyphicon-edit"></span></a>
                                <a class="btn btn-danger eliminaHotel" href="#modalEliminar" data-toggle="modal"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Modal -->
            <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Eliminar hotel</h4>
                        </div>
                        <div class="modal-body">
                            <p>Se eliminará el hotel "<span id="nombreHotelEliminar">xxx</span>"</p>
                            <p>Esta operación no tendrá vuelta atrás. ¿Desea continuar?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <a href="#" id="confirmaElimina" class="btn btn-danger" id="confirmaElimina">Eliminar hotel</a>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <!-- Site footer -->
            <div class="footer">
                <p>&copy;2013 <a href="http://david.galisteocantero.com" target="_blank">Galisteo</a> & <a href="http://www.twitter.com/AgustRuiz" target="_blank">Ruiz</a></p>
            </div>

        </div> <!-- /container -->
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/listadoOperadores.js"></script>
</html>
