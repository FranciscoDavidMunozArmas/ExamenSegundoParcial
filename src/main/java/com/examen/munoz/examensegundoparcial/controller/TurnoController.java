package com.examen.munoz.examensegundoparcial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.munoz.examensegundoparcial.service.TurnoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity crearTurno() {
        return null;
    }

    @PutMapping
    public ResponseEntity registrarAtencion() {
        return null;
    }

    @GetMapping
    public ResponseEntity obtenerTurno() {
        return null;
    }

    @GetMapping
    public ResponseEntity obtenerTurno1() {
        return null;
    }

    @GetMapping
    public ResponseEntity obtenerTurno2() {
        return null;
    }
}
