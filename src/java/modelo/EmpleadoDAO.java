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
public class EmpleadoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado validar(String user, String dni) {
        
        Empleado empleado=new Empleado();
        String sql="select * from empleados where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()) {
                empleado.setId(rs.getInt("IdEmpleado"));
                empleado.setUser(rs.getString("User"));
                empleado.setDni(rs.getString("Dni"));
                empleado.setNombres(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return empleado;
    }
    
}