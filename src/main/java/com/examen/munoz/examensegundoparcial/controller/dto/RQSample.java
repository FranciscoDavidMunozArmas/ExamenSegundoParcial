package com.examen.munoz.examensegundoparcial.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RQSample implements Serializable {
    private String lastname;
    private String name;
}
