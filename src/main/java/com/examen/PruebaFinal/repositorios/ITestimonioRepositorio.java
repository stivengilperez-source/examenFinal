package com.examen.PruebaFinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.PruebaFinal.modelos.Testimonio;

@Repository
public interface ITestimonioRepositorio extends JpaRepository<Testimonio,Long> {

    List<Testimonio>findByNombre(String nombre);
    
}
