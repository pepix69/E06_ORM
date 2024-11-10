package com.upiiz.orm.services;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.repositories.ClienteReposotiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    ClienteReposotiry clienteReposotiry;

    //Listar todos
    public List<ClienteEntity> obtenerTodos(){
        return clienteReposotiry.findAll();
    }

    //Listar uno
    public Optional<ClienteEntity> obtenerUno(Long id){return  clienteReposotiry.findById(id);}

    //Guardar
    public ClienteEntity guardarCliente(ClienteEntity cliente){
        return clienteReposotiry.save(cliente);
    }

    //Actualizar
    public Optional<ClienteEntity> actualizarCliente(Long id, ClienteEntity cliente){
        return clienteReposotiry.findById(id).map(clienteExistente -> {
            // Aquí se actualizan solo los campos necesarios
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setEmail(cliente.getEmail());
            // Agrega más setters si necesitas actualizar otros campos

            return clienteReposotiry.save(clienteExistente);});
    }

    //Delete
    public void eliminarCliente(Long id){
        clienteReposotiry.deleteById(id);
    }

    
}
