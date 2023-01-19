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
    private String nombre;
    private String apellidos;
    private LocalDate date;
    private String direccionPrincipal;
    private String telefono;
    private String correoElectronico;
    private List<Cuenta> cuentas;
}
