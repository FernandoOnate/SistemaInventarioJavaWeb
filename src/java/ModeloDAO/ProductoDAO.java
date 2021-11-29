package ModeloDAO;

import Conexion.Conexion;
import Interfaces.CRUD;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Oñate
 */
public class ProductoDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto pr = new Producto();

    @Override
    public List mostrar() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM tb_productos";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCodigo(rs.getString("codigo_producto"));
                p.setCantidad(rs.getInt("cantidad"));

                listaProductos.add(p);
            }
        } catch (Exception e) {
            System.out.println("NO SE PUDO AGREGAR EL PDODUCTO " + e);
        }
        return listaProductos;
    }

    @Override
    public Modelo.Producto mostrar2(int id) {
        String sql = "SELECT * FROM tb_productos WHERE id=" + id;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt("id"));
                pr.setNombre(rs.getString("nombre"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setCantidad(rs.getInt("cantidad"));
                pr.setCodigo(rs.getString("codigo_producto"));
            }
        } catch (Exception e) {
            System.out.println("NO SE PUDO LISTAR EL PDODUCTO " + e);
        }
        return pr;
    }

    @Override
    public boolean agregar(Modelo.Producto p) {
        String sql = "INSERT INTO tb_productos(nombre,precio,codigo_producto,cantidad) VALUES('" + p.getNombre() + "','" + p.getPrecio() + "','" + p.getCodigo() + "','" + p.getCantidad() + "')";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Agregado correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo agregar el producto " + e);
        }
        return false;
    }

    @Override
    public boolean editar(Modelo.Producto prod) {
        String sql = "UPDATE tb_productos SET nombre='" + prod.getNombre() + "',precio='" + prod.getPrecio() + "',codigo_producto='" + prod.getCodigo() + "',cantidad='" + prod.getCantidad() + "' WHERE id=" + prod.getId();
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Actualizado correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el producto " + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM tb_productos WHERE id=" + id;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("NO SE PUDO ELIMINAR EL PDODUCTO " + e);
        }
        return false;
    }

    public boolean comprar(int cantidadUsuario, int id) {

        String sql = "SELECT * FROM tb_productos WHERE id=" + id;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();

            int cantidadVieja = rs.getInt("cantidad");
            System.out.println("CANTIDAD DE LA BD" + cantidadVieja);
            int cantidadNueva = cantidadVieja - cantidadUsuario;

            if (cantidadUsuario > cantidadVieja) {
                return false;
            } else {
                sql = "UPDATE tb_productos SET cantidad='" + cantidadNueva + "' WHERE id=" + id;
                try {
                    con = cn.conectar();
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();
                    System.out.println("Actualizado correctamente");
                    return true;
                } catch (Exception e) {
                    System.out.println("No se pudo actualizar el producto " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al traer la cantidad DE LA BD y actualizar " + e);
        }
        return false;
    }

    public List mostrarIndividual(String busqueda) {
        ArrayList<Producto> listaProducto = new ArrayList<>();
        String sql = "SELECT * FROM tb_productos WHERE nombre LIKE ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+busqueda+"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                pr.setId(rs.getInt("id"));
                pr.setNombre(rs.getString("nombre"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setCantidad(rs.getInt("cantidad"));
                pr.setCodigo(rs.getString("codigo_producto"));
                listaProducto.add(pr);
                
            }System.out.println("SI SE AGREGARON LOS PRODUCTOS");
        } catch (Exception e) {
            System.out.println("NO SE PUDO LISTAR EL PDODUCTO " + e);
        }
        return listaProducto;
    }

}
