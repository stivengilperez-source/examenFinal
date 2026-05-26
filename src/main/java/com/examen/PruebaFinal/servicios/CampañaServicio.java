package com.examen.PruebaFinal.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.examen.PruebaFinal.modelos.Campaña;
import com.examen.PruebaFinal.repositorios.ICampañaRepositorio;

@Service
public class CampañaServicio {

    @Autowired
    private ICampañaRepositorio repositorio;

    public Campaña guardar_Campaña(Campaña datosCampaña){
        Campaña resultadoTransaccion = repositorio.save(datosCampaña);
        return resultadoTransaccion;
    }

    public List<Campaña> listar_campañas(){
        List<Campaña>resultadoTransaccion = repositorio.findAll();
        return resultadoTransaccion;
    }

    public Campaña buscar_campaña_por_id(Long id){
        Optional<Campaña>campañaQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (campañaQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La campaña no está en la BD"
            );
        }
        return campañaQueEstoyBuscandoTransaccion.get();
    }

    public Campaña modificar_campaña(Long id, Campaña datosModificadosCampaña){
        Optional<Campaña>campañaQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (campañaQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La campaña no está en la BD"
            );
        }

        Campaña campañaEncontrado = campañaQueEstoyBuscandoTransaccion.get();

        campañaEncontrado.setNombre(datosModificadosCampaña.getNombre());
        campañaEncontrado.setDescripcion(datosModificadosCampaña.getDescripcion());
        campañaEncontrado.setPlataforma(datosModificadosCampaña.getPlataforma());
        campañaEncontrado.setFechaInicio(datosModificadosCampaña.getFechaInicio());
        campañaEncontrado.setFechaFin(datosModificadosCampaña.getFechaFin());
        campañaEncontrado.setPresupuesto(datosModificadosCampaña.getPresupuesto());

        return repositorio.save(campañaEncontrado);
    }

    public boolean eliminar_campaña(Long id){
        Optional<Campaña>campañaQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (campañaQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La campaña no está en la BD"
            );
        }
        repositorio.deleteById(id);
        return true;
    }


}
