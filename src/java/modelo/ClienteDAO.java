/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xxx
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {

        String sql = "select * from clientes";
        List<Cliente> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombres(rs.getString(2));
                cliente.setDni(rs.getInt(3));
                lista.add(cliente);

            }

        } catch (Exception e) {
        }

        return lista;

    }

    public void agregar(Cliente cliente) {

        String sql = "insert into clientes(nombre, dni)values(?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombres());
            ps.setInt(2, cliente.getDni());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void eliminar(int id) {

        String sql = "delete from clientes where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public Cliente listarId(int id) {

        Cliente cliente = new Cliente();
        String sql = "select * from clientes where id=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                cliente.setNombres(rs.getString(2));
                cliente.setDni(rs.getInt(3));

            }

        } catch (Exception e) {
        }

        return cliente;

    }

    public int actualizar(Cliente cliente) {

        String sql = "update clientes set nombre=?, dni=? where id=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombres());
            ps.setInt(2, cliente.getDni());
            ps.setInt(3, cliente.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return r;

    }

}
