package com.examen.munoz.examensegundoparcial.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
import com.examen.munoz.examensegundoparcial.model.Cliente;
import com.examen.munoz.examensegundoparcial.repository.ClienteRepository;
import com.examen.munoz.examensegundoparcial.utils.ResponseCodeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarCliente(String cedula) {
        Optional<Cliente> optional = this.clienteRepository.findByCedula(cedula);
        if (optional.isPresent()) {
            Cliente cliente = optional.get();
            return cliente;
        } else {
            throw new CustomRuntimeException("El cliente no ha sido encontrado", ResponseCodeUtils.NOT_FOUND.code);
        }
    }

}
