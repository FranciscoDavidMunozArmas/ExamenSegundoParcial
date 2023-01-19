package com.examen.munoz.examensegundoparcial.controller.mapper;

import com.examen.munoz.examensegundoparcial.controller.dto.RQPet;
import com.examen.munoz.examensegundoparcial.controller.dto.RQSample;
import com.examen.munoz.examensegundoparcial.controller.dto.RSSample;
import com.examen.munoz.examensegundoparcial.model.SampleModel;
import com.examen.munoz.examensegundoparcial.model.SamplePet;

public class SampleMapper {
    public static RSSample map(SampleModel sample) {
        return RSSample.builder()
                .lastname(sample.getLastname())
                .name(sample.getName()).build();
    }

    public static SampleModel map(RQSample sample) {
        return SampleModel.builder()
                .lastname(sample.getLastname())
                .name(sample.getName()).build();
    }

    public static SamplePet map(RQPet pet) {
        return SamplePet.builder()
                .name(pet.getName())
                .specie(pet.getSpecie())
                .legs(pet.getLegs())
                .build();
    }
}
