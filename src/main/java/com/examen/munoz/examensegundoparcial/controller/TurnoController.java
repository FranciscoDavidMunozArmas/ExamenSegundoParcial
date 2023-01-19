package com.examen.munoz.examensegundoparcial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.munoz.examensegundoparcial.controller.dto.RQCalificacion;
import com.examen.munoz.examensegundoparcial.controller.dto.RQGeneracionTurno;
import com.examen.munoz.examensegundoparcial.controller.dto.RSTurno;
import com.examen.munoz.examensegundoparcial.controller.mapper.TurnoMapper;
import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
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
    public ResponseEntity<RSTurno> crearTurno(
            @RequestBody RQGeneracionTurno rqGeneracionTurno) {
        try {
            Integer turno = this.turnoService.crearTurno(rqGeneracionTurno.getCedulaCliente(),
                    rqGeneracionTurno.getNombre() + rqGeneracionTurno.getApellidos());
            return ResponseEntity.ok(TurnoMapper.map(turno));
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{turno}")
    public ResponseEntity registrarAtencion(
            @PathVariable("turno") Integer turnoInteger,
            @RequestBody RQCalificacion rqCalificacion) {
        try {
            this.turnoService.calificar(rqCalificacion.getCedulaCliente(), turnoInteger,
                    rqCalificacion.getCalificacion());
            return ResponseEntity.ok().build();
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/iniciar/{turno}/{codigoUsuarioEjecutivo}")
    public ResponseEntity<String> iniciarTurno(
            @PathVariable("turno") Integer turno,
            @PathVariable("codigoUsuarioEjecutivo") String codigoUsuarioEjecutivo) {
        try {
            this.turnoService.registrarAtencion(turno, codigoUsuarioEjecutivo);
            return ResponseEntity.ok("Actualizado con exito");
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/finalizar/{turno}")
    public ResponseEntity<String> finalizarTurno(
            @PathVariable("turno") Integer turno) {
        try {
            this.turnoService.finalizarAtencion(turno);
            return ResponseEntity.ok("Actualizado con exito");
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
