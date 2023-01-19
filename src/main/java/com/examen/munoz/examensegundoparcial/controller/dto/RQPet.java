package com.examen.munoz.examensegundoparcial.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RQPet implements Serializable {
    private String name;
    private String specie;
    private Integer legs;
}
