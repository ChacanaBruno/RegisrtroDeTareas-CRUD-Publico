
package com.mycompany.registrodetareas.logica;

import com.mycompany.registrodetareas.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String electrodomestico, String marca, String nombreCliente, String celularCliente, 
                        String direccionCliente, String observaciones, String esClienteNuevo) {
       
        //creamos las instancias de cliente
        Cliente cliente = new Cliente();
        cliente.setNombre(nombreCliente);
        cliente.setCelular(celularCliente);
        cliente.setDireccion(direccionCliente);
        cliente.setEsClienteNuevo(esClienteNuevo);
        
        Electrodomestico electrodo = new Electrodomestico();
        electrodo.setNombreElectrodomestico(electrodomestico);
        electrodo.setMarca(marca);
        electrodo.setObservacion(observaciones);
        electrodo.setClienteDeElectrodomestico(cliente);
        
        
        controlPersis.guardar(cliente, electrodo);
    }

    public List<Electrodomestico> traerElectrodomesticos() {
        
        return controlPersis.traerElectrodomesticos();
    }

    public void borrarElectrodomestico(int num_cliente) {
        controlPersis.borrarElectrodomestico(num_cliente);
    }

    public Electrodomestico traerElectrodomestico(int num_cliente) {
        return controlPersis.traerElectrodomestico(num_cliente);
    }    

    public void modificarElectrodomestico(Electrodomestico electrodo, String electrodome,
                                            String marca, String nombreCliente, String celularCliente, String direccionCliente, 
                                            String observaciones, String esClienteNuevo) {
        
        electrodo.setNombreElectrodomestico(electrodome);
        electrodo.setMarca(marca);
        electrodo.setObservacion(observaciones);
       
        //modoifcar electrodomestico
        
        controlPersis.modificarElectrodomestico(electrodo);
        
        // seteo nuevos valores al cliente
        Cliente cliente = this.buscarCliente(electrodo.getClienteDeElectrodomestico().getId_Cliente());
        cliente.setCelular(nombreCliente);
        cliente.setNombre(nombreCliente);
        cliente.setDireccion(direccionCliente);
        
        this.modicarCliente(cliente);
    }

    private Cliente buscarCliente(int id_Cliente) {
        return controlPersis.traerCliente(id_Cliente);
    }

    private void modicarCliente(Cliente cliente) {
        controlPersis.modificarCliente(cliente);
    }
    
    
}
