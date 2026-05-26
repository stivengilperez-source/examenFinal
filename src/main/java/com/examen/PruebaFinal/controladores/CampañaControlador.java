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

import com.examen.PruebaFinal.modelos.Campaña;
import com.examen.PruebaFinal.servicios.CampañaServicio;

@RestController
@RequestMapping("/api/campanas")
public class CampañaControlador {

    @Autowired
    CampañaServicio servicio;

    @PostMapping
    public ResponseEntity<?>controlar_guardado(@RequestBody Campaña datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_Campaña(datos));

    }

    @GetMapping
    public ResponseEntity<?>controlar_listado(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_campañas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>controlar_buscar_por_id(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_campaña_por_id(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>controlar_modificar(@PathVariable Long id, @RequestBody Campaña datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_campaña(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlar_eliminar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_campaña(id));
    }



}
