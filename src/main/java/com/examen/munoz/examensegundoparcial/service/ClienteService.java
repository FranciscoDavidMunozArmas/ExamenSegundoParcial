package com.examen.munoz.examensegundoparcial.service;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.model.Cliente;
import com.examen.munoz.examensegundoparcial.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarCliente(String cedula) {
        return null;
    }

}
