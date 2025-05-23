package com.api.odonto.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.api.odonto.models.Procedimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.api.odonto.models.Historico;
import com.api.odonto.models.Paciente;
import com.api.odonto.services.HistoricoServices;
import com.api.odonto.services.PacienteServices;

@RestController
@RequestMapping("/historico")
@Validated
public class HistoricoController {


    @Autowired
    private HistoricoServices historicoServices;

    @Autowired
    private PacienteServices pacienteServices;

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Historico> findByCpf(@PathVariable String cpf) {
        Historico obj = this.historicoServices.buscaridc(cpf);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Historico> findById(@PathVariable Long id) {
        Historico obj = this.historicoServices.buscarid(id);
        return ResponseEntity.ok(obj);
    }


    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Historico obj) {
        this.historicoServices.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody Historico obj, @PathVariable Long id) {
        obj.setId(id);
        this.historicoServices.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.historicoServices.delete(id);
        return ResponseEntity.noContent().build();

    }


}
	
	
