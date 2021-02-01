package pulperia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ventas {

  
   
    private String fecha;
    private int cantidad_vendedor;
    private  int id_vendedor;
    private int id_producto;

    public ventas( String fecha, int cantidad_vendedor, int id_vendedor, int id_producto) {
        
        this.fecha = fecha;
        this.cantidad_vendedor = cantidad_vendedor;
        this.id_vendedor = id_vendedor;
        this.id_producto = id_producto;
    }

   

    public String getFecha() {
        return fecha;
    }

    public int getCantidad_vendedor() {
        return cantidad_vendedor;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public static ventas ventas_de_id(String fecha) throws SQLException {
        ResultSet rs = Database.ExecuteResult("SELECT * FROM ventas WHERE  fecha = " + fecha);
        rs.first();
        return new ventas( rs.getString("fecha"), rs.getInt("cantidad_vendedor"), rs.getInt("id_producto"), rs.getInt("id_producto"));
    }

    public static ArrayList<ventas> ObtenerLista() throws SQLException {
        Connection conn = Database.getConn();

        ArrayList<ventas> ventasList = new ArrayList<>();

        String q = "SELECT * FROM ventas";
        PreparedStatement stmt = conn.prepareStatement(q);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ventas venta = new ventas(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4) );
            ventasList.add(venta);
        }
        return ventasList;
    }
    public static void nuevoVenta(int cantidad_ventas, int id_vendedor, int id_producto) throws SQLException {
        Connection conn = Database.getConn();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ventas (cantidad_ventas, id_vendedor, id_producto) VALUES (?, ?, ?)");
        stmt.setInt(1, cantidad_ventas );
        stmt.setInt(2, id_vendedor);
        stmt.setInt(3, id_producto);
        
        stmt.execute();
    }
    
    public String toString(){
        return this.fecha;
    }
}
