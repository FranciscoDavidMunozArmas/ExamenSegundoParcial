package com.examen.munoz.examensegundoparcial.service;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.model.Turno;
import com.examen.munoz.examensegundoparcial.repository.TurnoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno crearTurno(String cedulaCliente, String nombreCompletoCliente) {
        return null;
    }

    public void registrarAtencion(Integer turno, String codigoUsuarioEjecutivo) {

    }

    public void finalizarAtencion(Integer turno) {

    }

    public void calificar(String cedulaCliente, Integer numeroTurno, Integer calificacion) {

    }

}
