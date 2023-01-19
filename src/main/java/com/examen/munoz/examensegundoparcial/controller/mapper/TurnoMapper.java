package com.examen.munoz.examensegundoparcial.controller.mapper;

import com.examen.munoz.examensegundoparcial.controller.dto.RSTurno;

public class TurnoMapper {
    public static RSTurno map(Integer turno) {
        return RSTurno.builder()
                .turno(turno)
                .build();
    }
}
