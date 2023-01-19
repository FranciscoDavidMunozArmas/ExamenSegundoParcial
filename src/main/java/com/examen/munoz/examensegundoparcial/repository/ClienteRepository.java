package com.examen.munoz.examensegundoparcial.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.munoz.examensegundoparcial.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    public Optional<Cliente> findByCedula(String cedula);
}
