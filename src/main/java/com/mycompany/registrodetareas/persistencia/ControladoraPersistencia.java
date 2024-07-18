package com.mycompany.registrodetareas.persistencia;

import com.mycompany.registrodetareas.logica.Cliente;
import com.mycompany.registrodetareas.logica.Electrodomestico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControladoraPersistencia {
    ClienteJpaController clienteJpa = new ClienteJpaController();
    ElectrodomesticoJpaController electrodomesticoJpa = new ElectrodomesticoJpaController();

    public void guardar(Cliente cliente, Electrodomestico electrodo) {
        // Crear en la base de datos el cliente
        clienteJpa.create(cliente);
        // Crear en la base de datos el electrodomestico
        electrodomesticoJpa.create(electrodo);
    }

    public List<Electrodomestico> traerElectrodomesticos() {
        return electrodomesticoJpa.findElectrodomesticoEntities();
    }

    public void borrarElectrodomestico(int num_cliente) {
        try {
            electrodomesticoJpa.destroy(num_cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Electrodomestico traerElectrodomestico(int num_cliente) {
        return electrodomesticoJpa.findElectrodomestico(num_cliente);
    }

    public void modificarMascota(Electrodomestico electrodo) {
        try {
            electrodomesticoJpa.edit(electrodo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente traerCliente(int id_Cliente) {
        return clienteJpa.findCliente(id_Cliente);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarElectrodomestico(Electrodomestico electrodo) {
        try {
            electrodomesticoJpa.edit(electrodo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
