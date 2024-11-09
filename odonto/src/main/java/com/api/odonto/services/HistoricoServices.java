package com.api.odonto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.odonto.models.Historico;
import com.api.odonto.models.Paciente;
import com.api.odonto.repositories.HistoricoRepository;

@Service
public class HistoricoServices {
	
	@Autowired
	private HistoricoRepository historicoRepository;
	
	@Autowired
	private PacienteServices pacienteService;
	
	
	public Historico buscarid(Long id) {
		Optional<Historico> historico = this.historicoRepository.findById(id);
		return historico.orElseThrow(()-> new RuntimeException("Historico não encontrado id#" + id));
	}
	
	@Transactional
	public Historico criar(Historico obj) {

		Paciente paciente = pacienteService.buscapeloId(obj.getPaciente().getId());
		obj.setPaciente(paciente);
		return this.historicoRepository.save(obj);
	}
	
	public Historico update(Historico obj) {
		Historico newObj = buscarid(obj.getId());
		newObj.setProcimentosRealizados(obj.getProcimentosRealizados());
		return this.historicoRepository.save(newObj);
	}
	
	public void delete (Long id) {
		buscarid(id);
		try {
			this.historicoRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Não é possivel excluir o historico");
		}
	}

}
