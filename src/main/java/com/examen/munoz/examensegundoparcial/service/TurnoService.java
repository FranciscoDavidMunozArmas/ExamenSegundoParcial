package com.examen.munoz.examensegundoparcial.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
import com.examen.munoz.examensegundoparcial.model.Ejecutivo;
import com.examen.munoz.examensegundoparcial.model.Turno;
import com.examen.munoz.examensegundoparcial.repository.EjecutivoRepository;
import com.examen.munoz.examensegundoparcial.repository.TurnoRepository;
import com.examen.munoz.examensegundoparcial.utils.ResponseCodeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;
    private final EjecutivoRepository ejecutivoRepository;

    public TurnoService(TurnoRepository turnoRepository, EjecutivoRepository ejecutivoRepository) {
        this.turnoRepository = turnoRepository;
        this.ejecutivoRepository = ejecutivoRepository;
    }

    public Integer crearTurno(String cedulaCliente, String nombreCompletoCliente) {
        List<Turno> turnos = this.turnoRepository.findAll();
        List<Ejecutivo> ejecutivos = this.ejecutivoRepository.findByAsignado(false);
        if (ejecutivos.size() > 0) {
            try {
                Ejecutivo ejecutivo = ejecutivos.get(0);
                ejecutivo.setAsignado(true);
                Turno turno = Turno.builder()
                        .cedulaCliente(cedulaCliente)
                        .nombreCliente(nombreCompletoCliente)
                        .fechaHoraGeneracion(LocalDateTime.now())
                        .codigoUsuarioEjecutivo(ejecutivo.getCodigoUsuarioEjecutivo())
                        .numeroTurno(turnos.size() > 0 ? turnos.size() + 1 : 1)
                        .build();
                this.turnoRepository.save(turno);
                this.ejecutivoRepository.save(ejecutivo);
                return turno.getNumeroTurno();
            } catch (Exception e) {
                throw new CustomRuntimeException("Ha ocurrido un error", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
            }
        } else {
            throw new CustomRuntimeException("Ejecutivos no disponibles", ResponseCodeUtils.NOT_FOUND.code);
        }

    }

    public void registrarAtencion(Integer numeroTurno, String codigoUsuarioEjecutivo) {
        Optional<Turno> optional = this.turnoRepository.findByNumeroTurnoAndCodigoUsuarioEjecutivo(numeroTurno,
                codigoUsuarioEjecutivo);
        Optional<Ejecutivo> optEjecutivo = this.ejecutivoRepository.findById(codigoUsuarioEjecutivo);
        if (optional.isPresent() && optEjecutivo.isPresent()) {
            Turno turno = optional.get();
            turno.setFechaHoraInicioAtencion(LocalDateTime.now());
            Ejecutivo ejecutivo = optEjecutivo.get();
            ejecutivo.setAsignado(false);
            try {
                this.turnoRepository.save(turno);
                this.ejecutivoRepository.save(ejecutivo);
            } catch (Exception e) {
                throw new CustomRuntimeException("Ha ocurrido un error", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
            }
        } else {
            throw new CustomRuntimeException("El turno no ha sido encontrado", ResponseCodeUtils.NOT_FOUND.code);
        }
    }

    public void finalizarAtencion(Integer numeroTurno) {
        Optional<Turno> optional = this.turnoRepository.findByNumeroTurno(numeroTurno);
        if (optional.isPresent()) {
            Turno turno = optional.get();
            turno.setFechaHoraFinAtencion(LocalDateTime.now());
            try {
                this.turnoRepository.save(turno);
            } catch (Exception e) {
                throw new CustomRuntimeException("Ha ocurrido un error", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
            }
        } else {
            throw new CustomRuntimeException("El turno no ha sido encontrado", ResponseCodeUtils.NOT_FOUND.code);
        }
    }

    public void calificar(String cedulaCliente, Integer numeroTurno, Integer calificacion) {
        Optional<Turno> optional = this.turnoRepository.findByNumeroTurnoAndCedulaCliente(numeroTurno, cedulaCliente);
        if (optional.isPresent()) {
            Turno turno = optional.get();
            turno.setCalificacion(calificacion);
            try {
                this.turnoRepository.save(turno);
            } catch (Exception e) {
                throw new CustomRuntimeException("Ha ocurrido un error", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
            }
        } else {
            throw new CustomRuntimeException("El turno no ha sido encontrado", ResponseCodeUtils.NOT_FOUND.code);
        }
    }

}
