package com.upiiz.orm.controllers;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getClientes(){
        return ResponseEntity.ok(clientesService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteEntity>> getClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> guardar(@RequestBody ClienteEntity cliente){
        return ResponseEntity.ok(clientesService.guardarCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ClienteEntity>> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente){
        return ResponseEntity.ok(clientesService.actualizarCliente(id, cliente));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clientesService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
