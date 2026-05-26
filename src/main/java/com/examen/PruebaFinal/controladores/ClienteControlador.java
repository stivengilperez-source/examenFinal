package com.examen.PruebaFinal.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.PruebaFinal.modelos.Cliente;
import com.examen.PruebaFinal.servicios.ClienteServicio;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    ClienteServicio servicio;

    @PostMapping
    public ResponseEntity<?>controlar_guardado(@RequestBody Cliente datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_Cliente(datos));
    }

    @GetMapping
    public ResponseEntity<?>controlar_listado(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_clientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>controlar_buscar_por_id(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_cliente_por_id(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>controlar_modificar(@PathVariable Long id, @RequestBody Cliente datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_cliente(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlar_eliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_cliente(id));
    }
}
