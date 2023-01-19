package com.examen.munoz.examensegundoparcial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
import com.examen.munoz.examensegundoparcial.model.SampleModel;
import com.examen.munoz.examensegundoparcial.model.SamplePet;
import com.examen.munoz.examensegundoparcial.repository.SampleRepository;
import com.examen.munoz.examensegundoparcial.utils.ResponseCodeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {

    private final SampleRepository repository;

    public SampleService(SampleRepository repository) {
        this.repository = repository;
    }

    public void create(SampleModel sample) {
        try {
            this.repository.save(sample);
        } catch (Exception e) {
            throw new CustomRuntimeException("Data not found", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
        }
    }

    public void create(String id, SamplePet pet) {
        try {
            Optional<SampleModel> optional = this.repository.findById(id);
            if (optional.isPresent()) {
                SampleModel model = optional.get();
                log.info(model.toString());
                List<SamplePet> pets = model.getPets();
                if(pets == null) pets = new ArrayList<>();
                pets.add(pet);
                model.setPets(pets);
                this.repository.save(model);
            } else {
                throw new CustomRuntimeException("Data not found", ResponseCodeUtils.NOT_FOUND.code);
            }
        } catch (Exception e) {
            throw new CustomRuntimeException("Data not found", ResponseCodeUtils.INTERNAL_ERROR_SERVER.code);
        }
    }

    public SampleModel getOwner(String id) {
        Optional<SampleModel> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new CustomRuntimeException("Data not found", ResponseCodeUtils.NOT_FOUND.code);
        }
    }

    public List<SampleModel> getOwners(String name) {
        List<SampleModel> samples = this.repository.findByName(name);
        if (samples.isEmpty()) {
            throw new CustomRuntimeException("Data not found", ResponseCodeUtils.NOT_FOUND.code);
        } else {
            return samples;
        }
    }

    public List<SampleModel> getOwnersByPet(String name) {
        List<SampleModel> samples = this.repository.findByPetsName(name);
        if (samples.isEmpty()) {
            throw new CustomRuntimeException("Data not found", ResponseCodeUtils.NOT_FOUND.code);
        } else {
            return samples;
        }
    }
}
