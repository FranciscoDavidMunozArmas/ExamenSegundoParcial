package com.examen.munoz.examensegundoparcial.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class Cliente {
    
    @Id
    private String id;
    private String cedula;
    private String nombre;
    private String apellidos;
    private LocalDate date;
    private String direccionPrincipal;
    private String telefono;
    private String correoElectronico;
    private List<Cuenta> cuentas;

    @Version
    private Long version;
}
