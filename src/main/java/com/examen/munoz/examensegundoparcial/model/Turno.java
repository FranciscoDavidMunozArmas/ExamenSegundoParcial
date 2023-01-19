package com.examen.munoz.examensegundoparcial.model;

import java.time.LocalDateTime;

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
@Document(collection = "turno")
public class Turno {

    @Id
    private String id;
    private Integer numeroTurno;
    private String cedulaCliente;
    private String nombreCliente;
    private String codigoUsuarioEjecutivo;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraInicioAtencion;
    private LocalDateTime fechaHoraFinAtencion;
    private Integer calificacion;

    @Version
    private Long version;

}
