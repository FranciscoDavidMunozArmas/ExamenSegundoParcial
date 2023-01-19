package com.examen.munoz.examensegundoparcial.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RQCalificacion {
    private Integer calificacion;
    private String cedulaCliente;
}
