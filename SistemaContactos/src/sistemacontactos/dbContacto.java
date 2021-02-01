/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontactos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;/**/

/**
 *
 * @author JAIR
 */
public class dbContacto {

    private Connection conn;

    public dbContacto(Connection conn) {
        this.conn = conn;

    }

    public Contactos getContactos(int _IdContacto) {
        Contactos c = null;
        try {
            PreparedStatement stmt;
            stmt = this.conn.prepareStatement("SELECT * FROM contactos WHERE IdContacto = ?");
            stmt.setInt(1, _IdContacto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int IdContacto = rs.getInt("IdContacto");
                String NombreContacto = rs.getString("NombreContacto");
                String ApellidoContacto = rs.getString("ApellidoContacto");
                int Telefono = rs.getInt("Telefono");
                String Direccion = rs.getString("Direccion");
                String CreateAt = rs.getString("CreateAt");

                c = new Contactos(IdContacto, NombreContacto, ApellidoContacto, Direccion, Telefono, CreateAt);

            }
        } catch (SQLException ex) {
            Logger.getLogger(dbContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public void nuevoContacto(String NombreContcto, String ApellidoContacto, String Direccion, int Telefono) {
        String q = "INSERT INTO contactos (NombreContacto, ApellidoContacto, Direccion, Telefono) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt;
            stmt = conn.prepareCall(q);
            stmt.setString(1, NombreContcto);
            stmt.setString(2, ApellidoContacto);
            stmt.setString(3, Direccion);
            stmt.setInt(4, Telefono);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbContacto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void BorrarContacto(int _idContacto) {
        String q = "DELETE FROM  contactos WHERE IdContacto = ?";

        try {
            PreparedStatement stmt;
            stmt = conn.prepareCall(q);

            stmt.setInt(1, _idContacto);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbContacto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }/**/
}
