<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>easyHotel</title>
        <meta charset="UTF-8">

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="img/favicon.png" />

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/justified-nav.css">
    </head>
    <body>
        <div class="container">
            <!-- Jumbotron -->
            <div class="jumbotron">
                <h1>easyHotel</h1>
                <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
                <div class="col-lg-6">
                    <img src="img/operators.png"/>
                    <a class="btn btn-lg btn-success" href="ServletOperador">Acceso a Operadores</a>
                </div>
                <div class="col-lg-6">
                    <img src="img/administrator.png"/>
                    <a class="btn btn-lg btn-success" href="ServletAdministrador">Acceso a Administrador</a>
                </div>
            </div>
                    <a class="btn btn-lg" href="operador/indexOperador.jsp">Atajo JSP Operador?</a>
                    <a class="btn btn-lg" href="administrador/indexAdministrador.jsp">Atajo JSP Administración?</a>
            <!-- Site footer -->
            <div class="footer">
                <p>&copy;2013 <a href="http://david.galisteocantero.com" target="_blank">Galisteo</a> & <a href="http://www.twitter.com/AgustRuiz" target="_blank">Ruiz</a></p>
            </div>

        </div> <!-- /container -->
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.js"><\/script>');</script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</html>
