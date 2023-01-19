package com.examen.munoz.examensegundoparcial.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RSTurno implements Serializable {
    Integer turno;
}
