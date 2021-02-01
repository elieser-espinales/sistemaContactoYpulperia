package pulperia;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jair espinales
 */
public class vendedor {

    private int Id;
    private String Nombre;

    public vendedor(int Id, String Nombre) {
        this.Id = Id;
        this.Nombre = Nombre;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public static vendedor vendedor_de_id(int id_vendedor) throws SQLException {
        ResultSet rs = Database.ExecuteResult("SELECT * FROM vendedor WHERE id = " + id_vendedor);
        rs.first();
        return new vendedor(rs.getInt("id"), rs.getString("Nombre"));
    }
}
