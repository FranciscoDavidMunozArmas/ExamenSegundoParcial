package com.examen.munoz.examensegundoparcial.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.munoz.examensegundoparcial.model.SampleModel;

@Repository
public interface SampleRepository extends MongoRepository<SampleModel, String> {
    public List<SampleModel> findByName(String name);
    public List<SampleModel> findByPetsName(String name);
}
