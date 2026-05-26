package com.examen.PruebaFinal.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.examen.PruebaFinal.modelos.Testimonio;
import com.examen.PruebaFinal.repositorios.ITestimonioRepositorio;

public class TestimonioServicio {

    @Autowired
    private ITestimonioRepositorio repositorio;

    public Testimonio guardar_Testimonio(Testimonio datosTestimonio){

        Testimonio resultadoTransaccion=repositorio.save(datosTestimonio);
        return resultadoTransaccion;

    }

    public List<Testimonio> listar_testimonios(){

        List<Testimonio> resultadoTransaccion=repositorio.findAll();
        return resultadoTransaccion;
    }

    public Testimonio buscar_testimonio_por_id(Long id){
        Optional<Testimonio> busqueda_testimonio_transaccion=repositorio.findById(id);
        if(busqueda_testimonio_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El testimonio que estás buscando no existe en la DB"
            );
        }

        return busqueda_testimonio_transaccion.get();
        
    }

    public Testimonio modificar_Testimonio(Long id, Testimonio datosTestimonioNuevos){
        Optional<Testimonio>busqueda_testimonio_transaccion=repositorio.findById(id);
        if(busqueda_testimonio_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El testimonio que quieres modificar no existe en la DB"
            );
        }

    Testimonio testimonio_encontrado_en_db=busqueda_testimonio_transaccion.get();

        testimonio_encontrado_en_db.setMensaje(datosTestimonioNuevos.getMensaje());
        testimonio_encontrado_en_db.setCalificacion(datosTestimonioNuevos.getCalificacion());
        testimonio_encontrado_en_db.setAprobado(datosTestimonioNuevos.getAprobado());
        testimonio_encontrado_en_db.setFecha(datosTestimonioNuevos.getFecha());

        return repositorio.save(testimonio_encontrado_en_db);
    }

    public boolean eliminar_Testimonio(Long id){
        Optional<Testimonio>busqueda_testimonio_transaccion=repositorio.findById(id);
        if(busqueda_testimonio_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El testimonio que quiere eliminar no existe en la DB"
            );
        }
        repositorio.deleteById(id);
        return true;    
    }

}
