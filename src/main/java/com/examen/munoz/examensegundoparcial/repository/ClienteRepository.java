package com.examen.munoz.examensegundoparcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.munoz.examensegundoparcial.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
