<%-- 
    Document   : ListaDeCelulares
    Created on : 31-ago-2019, 1:32:32
    Author     : xxx
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de celulares</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Color</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Foto</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dato" items="${lista}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getMarca()}</td>
                        <td>${dato.getModelo()}</td>
                        <td>${dato.getPrecio()}</td>
                        <td>${dato.getColor()}</td>
                        <td>${dato.getStock()}</td>
                        <td><img src="ControladorImg?id=${dato.getId()}" width="100" height="100"></td>
                        <td>
                            <a class="btn btn-info" href="Controlador?accion=Editar&id=${dato.getId()}">Editar</a>
                            <a class="btn btn-info" href="Controlador?accion=Eliminar&id=${dato.getId()}">Eliminar</a>
                            <a class="btn btn-info" href="Controlador?accion=RegistrarVenta&id=${dato.getId()}">Vender</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
