package com.api.odonto.services;


import com.api.odonto.models.Paciente;
import com.api.odonto.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente buscapeloCpf(String cpf){
        Optional<Paciente> paciente = this.pacienteRepository.findByCpf(cpf);
        return paciente.orElseThrow(() -> new RuntimeException("Usuario não encontrado cpf#" + cpf));
    }

    @Transactional
    public Paciente criar (Paciente obj){
        obj.setId(null);
        return this.pacienteRepository.save(obj);

    }
}