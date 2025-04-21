package com.api.odonto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.odonto.models.Procedimentos;
import com.api.odonto.repositories.ProcedimentosRepository;
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
    private ProcedimentosRepository procedimentosRepository;

	public Historico buscaridc(String cpf) {
		
		Optional<Historico> historico = this.historicoRepository.findBycpfp(cpf);
		return historico.orElseThrow(()-> new RuntimeException("Historico não encontrado cpf#" + cpf));
	}
	
	
	public Historico buscarid(Long id) {
		Optional<Historico> historico = this.historicoRepository.findByPaciente_Id(id);
		//List<Procedimentos> procedimentos = historico.get().getProcimentos();
		List<Procedimentos> procedimentos = procedimentosRepository.findAllByHistorico_Id(id);
		historico.get().setProcedimentos(procedimentos);
		return historico.orElseThrow(()-> new RuntimeException("Historico não encontrado cpf#" + id));
	}
	public Historico buscaridd(Long id) {
		Optional<Historico> historico = this.historicoRepository.findById(id);
		//List<Procedimentos> procedimentos = historico.get().getProcimentos();
		List<Procedimentos> procedimentos = procedimentosRepository.findAllByHistorico_Id(id);
		historico.get().setProcedimentos(procedimentos);
		return historico.orElseThrow(()-> new RuntimeException("Historico não encontrado cpf#" + id));
	}
	
		@Transactional
		public Historico criar(Historico obj) {
			if(!historicoRepository.findByPaciente_Id(obj.getPaciente().getId()).isPresent()) {
				obj.setId(null);
//				Paciente paciente = pacienteService.buscapeloId(obj.getPaciente().getId());
//				obj.setPaciente(paciente);
				obj.setCpfp(obj.getPaciente().getCpf());
			//	obj.setProcedimentos(new ArrayList<>());
				return this.historicoRepository.save(obj);
			}
			return null;
		}
	
	public Historico update(Historico obj) {
		Historico newObj = buscarid(obj.getId());
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
