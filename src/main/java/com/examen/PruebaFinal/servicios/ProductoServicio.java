package com.examen.PruebaFinal.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.examen.PruebaFinal.modelos.Producto;
import com.examen.PruebaFinal.repositorios.IProductoRepositorio;

@Service
public class ProductoServicio {

    @Autowired
    private IProductoRepositorio repositorio;

    public Producto guardar_producto(Producto datosProducto){

        Producto resultadoTransaccion=repositorio.save(datosProducto);
        return resultadoTransaccion;

    }

    public List<Producto> listar_productos(){

        List<Producto> resultadoTransaccion=repositorio.findAll();
        return resultadoTransaccion;
    }

    public Producto buscar_producto_por_id(Long id){
        Optional<Producto> busqueda_producto_transaccion=repositorio.findById(id);
        if(busqueda_producto_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El producto que estás buscando no existe en la DB"
            );
        }

        return busqueda_producto_transaccion.get();
        
    }

    public Producto modificar_Producto(Long id, Producto datosProductoNuevos){
        Optional<Producto>busqueda_producto_transaccion=repositorio.findById(id);
        if(busqueda_producto_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El producto que quieres modificar no existe en la DB"
            );
        }

    Producto producto_encontrado_en_db=busqueda_producto_transaccion.get();

        producto_encontrado_en_db.setNombre(datosProductoNuevos.getNombre());
        producto_encontrado_en_db.setActivo(datosProductoNuevos.getActivo());
        producto_encontrado_en_db.setCategoria(datosProductoNuevos.getCategoria());
        producto_encontrado_en_db.setDescripcion(datosProductoNuevos.getDescripcion());
        producto_encontrado_en_db.setPrecio(datosProductoNuevos.getPrecio());
        producto_encontrado_en_db.setStock(datosProductoNuevos.getStock());

        return repositorio.save(producto_encontrado_en_db);
    }

    public boolean eliminar_Producto(Long id){
        Optional<Producto>busqueda_producto_transaccion=repositorio.findById(id);
        if(busqueda_producto_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El producto que quiere eliminar no existe en la DB"
            );
        }
        repositorio.deleteById(id);
        return true;    
    }
}
