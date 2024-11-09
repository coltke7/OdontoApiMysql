package com.api.odonto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.odonto.models.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository <Historico,Long>{
	
	Optional<Historico> findById(Long id);
	

}
