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

}
