package com.examen.munoz.examensegundoparcial.controller.mapper;

import com.examen.munoz.examensegundoparcial.controller.dto.RSCliente;
import com.examen.munoz.examensegundoparcial.model.Cliente;

public class ClienteMapper {
    public static RSCliente map(Cliente cliente) {
        return RSCliente.builder()
                .cedula(cliente.getCedula())
                .nombreCompleto(cliente.getNombre() + cliente.getApellidos())
                .build();
    }
}
