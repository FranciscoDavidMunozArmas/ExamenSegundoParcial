package com.examen.munoz.examensegundoparcial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.munoz.examensegundoparcial.controller.dto.RQPet;
import com.examen.munoz.examensegundoparcial.controller.dto.RQSample;
import com.examen.munoz.examensegundoparcial.controller.dto.RSSample;
import com.examen.munoz.examensegundoparcial.controller.mapper.SampleMapper;
import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
import com.examen.munoz.examensegundoparcial.model.SampleModel;
import com.examen.munoz.examensegundoparcial.model.SamplePet;
import com.examen.munoz.examensegundoparcial.service.SampleService;
import com.examen.munoz.examensegundoparcial.utils.ResponseCodeUtils;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    private final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RSSample> getOwner(
            @PathVariable("id") String id) {

        try {
            SampleModel model = this.service.getOwner(id);
            RSSample sample = SampleMapper.map(model);
            return ResponseEntity.status(ResponseCodeUtils.SUCCESS.code)
                    .body(sample);
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(ResponseCodeUtils.INTERNAL_ERROR_SERVER.code)
                    .build();
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<RSSample>> getOwnersByName(
            @PathVariable("name") String name) {

        try {
            List<RSSample> samples = new ArrayList<>();
            List<SampleModel> models = this.service.getOwners(name);
            models.forEach(model -> {
                samples.add(SampleMapper.map(model));
            });
            return ResponseEntity.status(ResponseCodeUtils.SUCCESS.code)
                    .body(samples);
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(ResponseCodeUtils.INTERNAL_ERROR_SERVER.code)
                    .build();
        }
    }

    @GetMapping("pet/{name}")
    public ResponseEntity<List<RSSample>> getOwnersByPet(
            @PathVariable("name") String name) {

        try {
            List<RSSample> samples = new ArrayList<>();
            List<SampleModel> models = this.service.getOwnersByPet(name);
            models.forEach(model -> {
                samples.add(SampleMapper.map(model));
            });
            return ResponseEntity.status(ResponseCodeUtils.SUCCESS.code)
                    .body(samples);
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(ResponseCodeUtils.INTERNAL_ERROR_SERVER.code)
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createOwner(
            @RequestBody RQSample sample) {
        try {
            SampleModel model = SampleMapper.map(sample);
            this.service.create(model);
            return ResponseEntity.status(ResponseCodeUtils.SUCCESS.code).build();
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(ResponseCodeUtils.INTERNAL_ERROR_SERVER.code)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> createOwner(
            @PathVariable("id") String id,
            @RequestBody RQPet rqPet) {
        try {
            SamplePet pet = SampleMapper.map(rqPet);
            this.service.create(id, pet);
            return ResponseEntity.status(ResponseCodeUtils.SUCCESS.code).build();
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(ResponseCodeUtils.INTERNAL_ERROR_SERVER.code)
                    .build();
        }
    }
}
