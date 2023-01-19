package com.examen.munoz.examensegundoparcial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SamplePet {
    private String name;
    private String specie;
    private Integer legs;
}
