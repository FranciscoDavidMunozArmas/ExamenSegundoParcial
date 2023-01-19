package com.examen.munoz.examensegundoparcial.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.munoz.examensegundoparcial.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String> {

    public Optional<Turno> findByNumeroTurno(Integer numeroTurno);

    public Optional<Turno> findByNumeroTurnoAndCodigoUsuarioEjecutivo(Integer numeroTurno,
            String codigoUsuarioEjecutivo);

    public Optional<Turno> findByNumeroTurnoAndCedulaCliente(Integer numeroTurno, String cedulaCliente);

}
