package com.api.odonto.controllers;

import com.api.odonto.models.Historico;
import com.api.odonto.models.Procedimentos;
import com.api.odonto.services.HistoricoServices;
import com.api.odonto.services.ProcedimentosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/procedimentos")
@Validated
public class ProcedimentosController {

    @Autowired
    private ProcedimentosServices procedimentosServices;
    @Autowired
    private HistoricoServices historicoServices;

    @PostMapping
    @Validated
    public ResponseEntity<Void> criar (@Valid @RequestBody Procedimentos procedimentos){
        this.procedimentosServices.criar(procedimentos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(procedimentos.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
