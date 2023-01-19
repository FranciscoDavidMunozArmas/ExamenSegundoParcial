package com.examen.munoz.examensegundoparcial.model;

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
@Document(collection = "ejecutivo")
public class Ejecutivo {
    @Id
    private String id;
    private String codigoUsuarioEjecutivo;
    private String nombreCompleto;
    private Integer numeroEscritorioAsignado;
    private Boolean asignado;

    @Version
    private Long version;
}
