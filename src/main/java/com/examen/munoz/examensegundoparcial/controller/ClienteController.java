package com.examen.munoz.examensegundoparcial.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.munoz.examensegundoparcial.controller.dto.RSCliente;
import com.examen.munoz.examensegundoparcial.controller.mapper.ClienteMapper;
import com.examen.munoz.examensegundoparcial.error.CustomRuntimeException;
import com.examen.munoz.examensegundoparcial.model.Cliente;
import com.examen.munoz.examensegundoparcial.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<RSCliente> buscarCliente(
            @PathVariable("cedula") String cedula) {
        try {
            Cliente cliente = this.clienteService.buscarCliente(cedula);
            RSCliente response = ClienteMapper.map(cliente);
            return ResponseEntity.ok(response);
        } catch (CustomRuntimeException e) {
            return ResponseEntity.status(e.code).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
