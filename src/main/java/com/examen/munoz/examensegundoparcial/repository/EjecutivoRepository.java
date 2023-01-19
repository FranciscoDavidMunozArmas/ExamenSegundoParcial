package com.examen.munoz.examensegundoparcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.munoz.examensegundoparcial.model.Ejecutivo;

public interface EjecutivoRepository extends MongoRepository<Ejecutivo, String>{
    
}
