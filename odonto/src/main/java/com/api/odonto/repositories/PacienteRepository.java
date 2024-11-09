package com.api.odonto.repositories;

import com.api.odonto.models.Historico;
import com.api.odonto.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByCpf(String cpf);
    
    Optional<Paciente> findById(Long id);

}