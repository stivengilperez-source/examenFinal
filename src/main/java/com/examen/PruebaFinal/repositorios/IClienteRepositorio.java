package com.examen.PruebaFinal.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.PruebaFinal.modelos.Cliente;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Long>{

    List<Cliente>findByNombre(String nombre);

    List<Cliente>findByApellido(String apellido);

    Optional<Cliente>findByEmail(String email);

}
