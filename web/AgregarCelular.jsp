<%-- 
    Document   : AgregarCelular
    Created on : 01-sep-2019, 1:47:54
    Author     : xxx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar celular</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="col-4" style="margin: 50px auto;">
            <form action="Controlador" method="Post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="marca" class="form-control" placeholder="Marca"  required="required">
                </div>
                <div class="form-group">
                    <input type="text" name="modelo" class="form-control" placeholder="Modelo"  required="required">
                </div>
                <div class="form-group">
                    <input type="text" name="precio" class="form-control" placeholder="Precio"  required="required">
                </div>
                <div class="form-group">
                    <input type="text" name="color" class="form-control" placeholder="Color"  required="required">
                </div>
                <div class="form-group">
                    <input type="text" name="stock" class="form-control" placeholder="Stock"  required="required">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Foto</label>
                    <input type="file" class="form-control-file" name="fileFoto" required="required">
                </div>
                <input type="submit" name="accion" value="Agregar nuevo celular" class="btn btn-info btn-block">
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
