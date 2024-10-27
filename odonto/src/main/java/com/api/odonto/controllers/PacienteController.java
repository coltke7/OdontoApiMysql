package com.api.odonto.controllers;


import com.api.odonto.models.Paciente;
import com.api.odonto.services.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/paciente")
@Validated
public class PacienteController {

    @Autowired
    private PacienteServices pacienteServices;

    @GetMapping("/{cpf}")
    public ResponseEntity<Paciente> findByCpf(@PathVariable String cpf){
        Paciente obj = this.pacienteServices.buscapeloCpf(cpf);
        return ResponseEntity.ok(obj);
    }


    @PostMapping
    @Validated
    public ResponseEntity<Void> create (@Valid @RequestBody Paciente obj){
        this.pacienteServices.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}