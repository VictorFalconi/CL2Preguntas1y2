$(document).on("click", "#btnagregar", function(){
    $("#txtnrocuenta").val("");
    $("#txtfecharegistro").val("");
    $("#txtfechavencimiento").val("");
    $("#hddidcuenta").val("0");
    listarCboPersona(0);
    $("#modalcuenta").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtnrocuenta").val($(this).attr("data-nrocuenta"));
    $("#txtfecharegistro").val($(this).attr("data-fecharegistro"));
    $("#txtfechavencimiento").val($(this).attr("data-fechavencimiento"));
    $("#hddidcuenta").val($(this).attr("data-idcuenta"));
    $("#cbopersona").empty();
    listarCboPersona($(this).attr("data-cuentapersona"));
    $("#modalcuenta").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/cuenta/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idcuenta: $("#hddidcuenta").val(),
            nrocuenta: $("#txtnrocuenta").val(),
            fecharegistro: $("#txtfecharegistro").val(),
            fechavencimiento: $("#txtfechavencimiento").val(),
            idpersona: $("#cbopersona").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCuentas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalproduct").modal("hide");
});

function listarCuentas(){
    $.ajax({
        type: "GET",
        url: "/cuenta/list",
        dataType: "json",
        success: function(resultado){
            $("#tblcuenta > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcuenta > tbody").append(`<tr>`+
                `<td>${value.idcuenta}</td>`+
                `<td>${value.nrocuenta}</td>`+
                `<td>${value.fecharegistro}</td>`+
                `<td>${value.fechavencimiento}</td>`+
                `<td>${value.persona.IdPersona}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-idcuenta="${value.idcuenta}" `+
                    `data-nrocuenta="${value.nrocuenta}" `+
                    `data-fecharegistro="${value.fecharegistro}" `+
                    `data-fechavencimiento="${value.fechavencimiento}" `+
                    `data-cuentapersona="${value.persona.idpersona}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboPersona(idPersona){
    $("#cbopersona").empty();
    $.ajax({
        type: "GET",
        url: "/persona/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbopersona").append(
                    `<option value="${value.idpersona}">${value.nompersona}</option>`
                )
            });
            if(idPersona > 0){
                $("#cbopersona").val(idPersona);
            }
        }
    })
}