package com.examen.munoz.examensegundoparcial.service;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.repository.EjecutivoRepository;

@Service
public class EjecutivoService {
    private final EjecutivoRepository ejecutivoRepository;

    public EjecutivoService(EjecutivoRepository ejecutivoRepository) {
        this.ejecutivoRepository = ejecutivoRepository;
    }

    

}
