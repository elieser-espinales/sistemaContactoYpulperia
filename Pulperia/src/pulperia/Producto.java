package pulperia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jair espinales
 */
public class Producto {

    private int Id;
    private String Nombre;
    private int precio_unidad;

    public Producto(int Id, String Nombre, int precio_unidad) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.precio_unidad = precio_unidad;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPrecio_unidad() {
        return precio_unidad;
    }

    public static Producto producto_de_id(int id_producto) throws SQLException {
        ResultSet rs = Database.ExecuteResult("SELECT * FROM producto WHERE id = " + id_producto);
        rs.first();
        return new Producto(rs.getInt("id"), rs.getString("Nombre"), rs.getInt("precio_unidad"));
    }

    public static ArrayList<Producto> ObtenerLista() throws SQLException {
        Connection conn = Database.getConn();

        ArrayList<Producto> List = new ArrayList<>();

        String q = "SELECT * FROM producto";
        PreparedStatement stmt = conn.prepareStatement(q);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Producto item = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3));
            List.add(item);
        }
        return List;
    }
   
    public static void nuevoProducto(String nombre, int precio) throws SQLException {
        Connection conn = Database.getConn();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO producto (nombre, precio_unidad) VALUES (?, ?)");
        stmt.setString(1, nombre);
        stmt.setInt(2, precio);
        stmt.execute();
    }
    
    public String toString(){
        return this.getNombre();
    }
}
