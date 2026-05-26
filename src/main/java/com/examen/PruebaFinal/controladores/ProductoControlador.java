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

import com.examen.PruebaFinal.modelos.Producto;
import com.examen.PruebaFinal.servicios.ProductoServicio;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    ProductoServicio servicio;

    @PostMapping
    public ResponseEntity<?>controlarGuardado(@RequestBody Producto datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_producto(datos));
    }

    @GetMapping
    public ResponseEntity<?>controlarListado(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_productos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>controlarBuscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_producto_por_id(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>controlarModificar(@PathVariable Long id,@RequestBody Producto datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_Producto(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlarEliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_Producto(id));
    }
}
