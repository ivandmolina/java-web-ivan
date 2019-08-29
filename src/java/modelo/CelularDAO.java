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

/**
 *
 * @author xxx
 */
public class CelularDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*int r;

    public int agregar(Celular c) {
        String sql = "insert into celulares(marca,modelo,precio,color,foto,stock)values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setString(3, Double.toString(c.getPrecio()));
            ps.setString(4, c.getColor());
            ps.setString(5, c.getFoto());
            ps.setString(6, Integer.toString(c.getStock()));
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }*/

}
