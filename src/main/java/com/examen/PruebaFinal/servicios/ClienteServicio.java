package com.examen.PruebaFinal.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.examen.PruebaFinal.modelos.Cliente;
import com.examen.PruebaFinal.repositorios.IClienteRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    private IClienteRepositorio repositorio;

    public Cliente guardar_Cliente(Cliente datosCliente){
        Cliente resultadoTransaccion = repositorio.save(datosCliente);
        return resultadoTransaccion;
    }

    public List<Cliente> listar_clientes(){
        List<Cliente>resultadoTransaccion = repositorio.findAll();
        return resultadoTransaccion;
    }

    public Cliente buscar_cliente_por_id(Long id){
        Optional<Cliente>clienteQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (clienteQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El cliente no está en la BD"
            );
        }
        return clienteQueEstoyBuscandoTransaccion.get();
    }

    public Cliente modificar_cliente(Long id, Cliente datosModificadosCliente){
        Optional<Cliente>clienteQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (clienteQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El cliente no está en la BD"
            );
        }

        Cliente clienteEncontrado = clienteQueEstoyBuscandoTransaccion.get();

        clienteEncontrado.setNombre(datosModificadosCliente.getNombre());
        clienteEncontrado.setApellido(datosModificadosCliente.getApellido());
        clienteEncontrado.setEmail(datosModificadosCliente.getEmail());
        clienteEncontrado.setTelefono(datosModificadosCliente.getTelefono());
        clienteEncontrado.setCiudad(datosModificadosCliente.getCiudad());

        return repositorio.save(clienteEncontrado);
    }

    public boolean eliminar_cliente(Long id){
        Optional<Cliente>clienteQueEstoyBuscandoTransaccion = repositorio.findById(id);
        if (clienteQueEstoyBuscandoTransaccion.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El cliente no está en la BD"
            );
        }
        repositorio.deleteById(id);
        return true;
    }
}
