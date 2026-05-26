package com.examen.PruebaFinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.PruebaFinal.modelos.Campaña;

@Repository
public interface ICampañaRepositorio extends JpaRepository<Campaña, Long>{

    List<Campaña> findByNombre(String nombre);

    List<Campaña> findByFechaInicio(String fechaInicio);

    List<Campaña> findByFechaFin(String fechaFin);
}

