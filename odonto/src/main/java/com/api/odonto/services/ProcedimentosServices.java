package com.api.odonto.services;


import com.api.odonto.models.Historico;
import com.api.odonto.models.Paciente;
import com.api.odonto.models.Procedimentos;
import com.api.odonto.repositories.HistoricoRepository;
import com.api.odonto.repositories.ProcedimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProcedimentosServices {

    @Autowired
    private ProcedimentosRepository procedimentosRepository;
    @Autowired
    private HistoricoServices historicoServices;

    public Procedimentos buscarProcedimento (Long id){
        Optional<Procedimentos> procedimentos = this.procedimentosRepository.findById(id);
        return procedimentos.orElseThrow(()-> new RuntimeException("Historico não encontrado id#" + id));
    }

    @Transactional
    public Procedimentos criar(Procedimentos obj) {
    	obj.setId(null);
        Historico historico = historicoServices.buscaridd(obj.getHistorico().getId());
        obj.setHistorico(historico);
        return this.procedimentosRepository.save(obj);
    }
}
