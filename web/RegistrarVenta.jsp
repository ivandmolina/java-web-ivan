<%-- 
    Document   : RegistrarVenta
    Created on : 03-sep-2019, 20:55:40
    Author     : xxx
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resistrar venta</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-6">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">DNI</th>
                                <th scope="col">Seleccionar cliente</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                                <tr>
                                    <td>${dato.getNombres()}</td>
                                    <td>${dato.getDni()}</td>
                                    <td><input type="checkbox" name="cliente"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador" method="Post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" name="marca" class="form-control" value="${celular.getMarca()}" required="required" disabled>
                        </div>
                        <div class="form-group">
                            <input type="text" name="modelo" class="form-control" value="${celular.getModelo()}" required="required" disabled>
                        </div>
                        <div class="form-group">
                            <input type="text" name="precio" class="form-control" value="${celular.getPrecio()}"  required="required" disabled>
                        </div>
                        <div class="form-group">
                            <input type="text" name="color" class="form-control" value="${celular.getColor()}"  required="required" disabled>
                        </div>
                        <center>
                            <a class="btn btn-info" href="">Confirmar venta</a>
                            <a class="btn btn-info" href="Controlador?accion=Listar" target="myFrame">Cancelar</a>
                        </center>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
