package com.examen.munoz.examensegundoparcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.munoz.examensegundoparcial.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String> {

}
