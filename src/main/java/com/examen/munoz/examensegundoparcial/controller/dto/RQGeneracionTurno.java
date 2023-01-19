package com.examen.munoz.examensegundoparcial.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RQGeneracionTurno implements Serializable {
    private String cedula;
    private String nombreCompleto;
}
