
package com.mycompany.registrodetareas.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bruno
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Cliente;
    private String Nombre;
    private String Celular;
    private String Direccion;
    private String esClienteNuevo; // patron state?

    public Cliente() {
    }

    public Cliente(int id_Cliente, String Nombre, String Celular, String Direccion, String esClienteNuevo) {
        this.id_Cliente = id_Cliente;
        this.Nombre = Nombre;
        this.Celular = Celular;
        this.Direccion = Direccion;
        this.esClienteNuevo = esClienteNuevo;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEsClienteNuevo() {
        return esClienteNuevo;
    }

    public void setEsClienteNuevo(String esClienteNuevo) {
        this.esClienteNuevo = esClienteNuevo;
    }


    
    
    
}
