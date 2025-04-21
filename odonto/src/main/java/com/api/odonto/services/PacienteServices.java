package com.api.odonto.services;


import com.api.odonto.models.Historico;
import com.api.odonto.models.Paciente;
import com.api.odonto.models.Procedimentos;
import com.api.odonto.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HistoricoServices historicoServices;

    public Paciente buscapeloCpf(String cpf){
        Optional<Paciente> paciente = this.pacienteRepository.findByCpf(cpf);
        return paciente.orElseThrow(() -> new RuntimeException("Usuario não encontrado cpf#" + cpf));
    }

    public Paciente buscapeloId(Long id){
        Optional<Paciente> paciente = this.pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException("Usuario não encontrado id#" + id));
    }

    @Transactional
    public Paciente criar (Paciente obj){
        obj.setId(null);
        this.pacienteRepository.save(obj);
        Historico historico = new Historico();
        historico.setPaciente(obj);
        historicoServices.criar(historico);
        return obj;
    }

    public Paciente update(Paciente obj) {
		Paciente newObj = buscapeloId(obj.getId());
		newObj.setEndereco(obj.getEndereco());
		newObj.setCep(obj.getCep());
		newObj.setNumero(obj.getNumero());

		return this.pacienteRepository.save(newObj);
	}

	public void delete (Long id) {
		buscapeloId(id);
		try {
			this.pacienteRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Não é possivel excluir o paciente, pois possui relação com historico");
		}
	}
    
    
}