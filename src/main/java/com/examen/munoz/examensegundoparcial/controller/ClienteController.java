package com.examen.munoz.examensegundoparcial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.munoz.examensegundoparcial.model.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @GetMapping
    public ResponseEntity<Cliente> buscarCliente() {
        return null;
    }
}
