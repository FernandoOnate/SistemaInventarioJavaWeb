/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Conexion.Conexion;
import Interfaces.validar;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thene
 */
public class UsuarioDAO implements validar {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario us = new Usuario();
    

    @Override
    public int validar(Usuario user) {
        int i=0;
        String sql = "SELECT * FROM tb_usuarios WHERE identificacion=? AND clave=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setNString(1, user.getIdentificacion());
            ps.setString(2, user.getClave());
            rs = ps.executeQuery();
            while (rs.next()) {
                i++;
                user.setNombre(rs.getString("nombre"));
                user.setIdentificacion(rs.getString("identificacion"));

            }
            if(i == 1){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("NO SE VALIDAR USUARIO " + e);
        }
return 0;
    }
   public Modelo.Usuario mostrarUsuario(String clave) {
        String sql = "SELECT * FROM tb_usuarios WHERE clave=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellidos"));
                us.setIdentificacion(rs.getString("identificacion"));
                us.setTelefono(rs.getString("telefono"));
                us.setClave(rs.getString("clave"));
                us.setCorreo(rs.getString("correo"));
                us.setCodigo_admin(rs.getString("codigo_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("NO SE PUDO OBTENER AL USUARIO " + e);
        }
        return us;
   }
   public boolean agregarUsuario(Modelo.Usuario u) {
        String sql = "INSERT INTO tb_usuarios"
                + "(nombre,apellidos,identificacion,telefono,correo,codigo_usuario,clave)"
                + "VALUES"
                + "('" + u.getNombre() + "','" + u.getApellido() + "','" + u.getIdentificacion() + "','" + u.getTelefono() + "','" + u.getCorreo() + "','" + u.getCodigo_admin() + "','" + u.getClave() + "')";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Agregado correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo agregar el usuario " + e);
        }
        return false;
    }

}
