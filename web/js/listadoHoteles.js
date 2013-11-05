$(document).ready(function(){
    $(".eliminaHotel").click(function(){
        var nombreOperadorEliminar = $(this).parent().find("span.nombre").html();
        var CIF = $(this).parent().find("span.CIF").html();
        $("#nombreHotelEliminar").html(nombreOperadorEliminar);
        //$("#confirmaElimina").attr("href", "../ServletAdministrador/listadoOperadores?cifOperadorEliminar="+CIF+"&nombreOperador="+nombreOperadorEliminar);
        $("#modalElimina").show();
    });
});
