/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontactos;

/**
 *
 * @author JAIR
 */
public class Contactos {
    private int IdContacto;
    private String NombreContacto;
    private String ApellidoContacto;
    private String Direccion;
    private int Telefono;
    private String CreateAt;

    public Contactos(int IdContacto, String NombreContacto, String ApellidoContacto, String Direccion, int Telefono, String CreateAt) {
        this.IdContacto = IdContacto;
        this.NombreContacto = NombreContacto;
        this.ApellidoContacto = ApellidoContacto;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        
        this.CreateAt = CreateAt;
    }

    

 

    public int getIdContacto() {
        return IdContacto;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public String getApellidoContacto() {
        return ApellidoContacto;
    }
    
    public String getDireccion(){
        return Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getCreateAt() {
        return CreateAt;
    }
    
    
}
