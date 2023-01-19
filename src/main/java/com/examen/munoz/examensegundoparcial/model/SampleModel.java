package com.examen.munoz.examensegundoparcial.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Owner")
public class SampleModel {
    
    @Id
    private String id;
    @Indexed
    private String lastname;
    private String name;
    private List<SamplePet> pets;

    @Version
    private Long version;
}
