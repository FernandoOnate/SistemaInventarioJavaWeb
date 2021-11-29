
package Interfaces;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author Fernando oñate
 */
public interface CRUD {
    public List mostrar();
    public Producto mostrar2(int id);
    public boolean agregar(Producto p);
    public boolean editar(Producto p);
    public boolean eliminar(int id);
    
}
