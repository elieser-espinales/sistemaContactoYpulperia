package sistemacontactos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SistemaContactos {

    public static void main(String[] args) {

        Database db = new Database();
        Connection conn = db.getConnection();

        dbContacto contactos = new dbContacto(conn);

        Contactos c1 = contactos.getContactos(1);
        System.out.println("Nombre: " + c1.getNombreContacto());

         contactos.nuevoContacto("casiMiro", "Castro", "aqui", 12345678);
        contactos.BorrarContacto(3);

        insertTest(conn);
        System.out.println("datos insertados");
 try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contactos");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int IdContacto = rs.getInt("IdContacto");
                String NombreContacto = rs.getString("NombreContacto");
                String ApellidoContacto = rs.getString("ApellidoContacto");
                int Telefono = rs.getInt("Telefono");
                String Direccion = rs.getString("Direccion");
                String CreateAt = rs.getString("CreateAt");
                
                Contactos c = new Contactos(IdContacto, NombreContacto, ApellidoContacto, Direccion, Telefono, CreateAt);
                
                System.out.printf("El contacto se llama %s %s  y se creo el %s\r\n",c.getNombreContacto(), c.getApellidoContacto(), c.getCreateAt());
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(SistemaContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void insertTest(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
