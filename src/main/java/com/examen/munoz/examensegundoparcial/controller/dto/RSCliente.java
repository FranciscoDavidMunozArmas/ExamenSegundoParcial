package com.examen.munoz.examensegundoparcial.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.examen.munoz.examensegundoparcial.model.Cuenta;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RSCliente implements Serializable {
    private String cedula;
    private String nombreCompleto;
}
