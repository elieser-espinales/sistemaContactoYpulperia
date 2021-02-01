/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulperia;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hende
 */
public class Pulperia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Database.conectar();

            Producto p1 = Producto.producto_de_id(1);

            System.out.println("El nombre es: " + p1.getNombre() + " y cuesta: " + p1.getPrecio_unidad());

            Database.cerrar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pulperia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pulperia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
