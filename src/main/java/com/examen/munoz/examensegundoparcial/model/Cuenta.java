package com.examen.munoz.examensegundoparcial.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoPromedio;
}
