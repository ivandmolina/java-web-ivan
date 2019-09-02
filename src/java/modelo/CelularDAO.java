/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xxx
 */
public class CelularDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    int r;

    public List listar() {

        String sql = "select * from celulares";
        List<Celular> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Celular celular = new Celular();
                celular.setId(rs.getInt(1));
                celular.setMarca(rs.getString(2));
                celular.setModelo(rs.getString(3));
                celular.setPrecio(rs.getDouble(4));
                celular.setColor(rs.getString(5));
                celular.setStock(rs.getInt(6));
                celular.setFoto(rs.getBinaryStream(7));
                lista.add(celular);

            }

        } catch (Exception e) {
        }

        return lista;

    }

    //Muestra la imágen almacenada en la base de datos
    public void listarImg(int id, HttpServletResponse response) {

        String sql = "select * from celulares where id=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");

        try {
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream(7);
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }

    }

    public void agregar(Celular celular) {

        String sql = "insert into celulares(marca, modelo, precio, color, stock, foto)values(?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setDouble(3, celular.getPrecio());
            ps.setString(4, celular.getColor());
            ps.setInt(5, celular.getStock());
            ps.setBlob(6, celular.getFoto());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void eliminar(int id) {

        String sql = "delete from celulares where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public Celular listarId(int id) {

        Celular celular = new Celular();
        String sql = "select * from celulares where id=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                celular.setMarca(rs.getString(2));
                celular.setModelo(rs.getString(3));
                celular.setPrecio(rs.getDouble(4));
                celular.setColor(rs.getString(5));
                celular.setStock(rs.getInt(6));
                celular.setFoto(rs.getBinaryStream(7));

            }

        } catch (Exception e) {
        }

        return celular;

    }

    public int actualizar(Celular celular) {

        String sql = "update celulares set marca=?, modelo=?, precio=?, color=?, stock=?, foto=? where id=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setDouble(3, celular.getPrecio());
            ps.setString(4, celular.getColor());
            ps.setInt(5, celular.getStock());
            ps.setBlob(6, celular.getFoto());
            ps.setInt(7, celular.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return r;

    }

}
