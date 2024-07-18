
package com.mycompany.registrodetareas.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno
 */
@Entity
public class Electrodomestico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    private String NombreElectrodomestico;
    private String marca;
    private String Observacion;
    @OneToOne
     private Cliente clienteDeElectrodomestico;

    public Electrodomestico(){
    }

    public Electrodomestico(int num_cliente, String NombreElectrodomestico, String marca, String Observacion, Cliente clienteDeElectrodomestico) {
        this.num_cliente = num_cliente;
        this.NombreElectrodomestico = NombreElectrodomestico;
        this.marca = marca;
        this.Observacion = Observacion;
        this.clienteDeElectrodomestico = clienteDeElectrodomestico;
    }



    public String getNombreElectrodomestico() {
        return NombreElectrodomestico;
    }

    public void setNombreElectrodomestico(String NombreElectrodomestico) {
        this.NombreElectrodomestico = NombreElectrodomestico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public Cliente getClienteDeElectrodomestico() {
        return clienteDeElectrodomestico;
    }

    public void setClienteDeElectrodomestico(Cliente clienteDeElectrodomestico) {
        this.clienteDeElectrodomestico = clienteDeElectrodomestico;
    }
    
    
}
